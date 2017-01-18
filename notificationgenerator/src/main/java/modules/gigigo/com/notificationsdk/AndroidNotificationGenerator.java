package modules.gigigo.com.notificationsdk;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.widget.RemoteViews;
import modules.gigigo.com.notificationsdk.Builders.NotificationGeneratorBuilder;

/**
 * Created by nubor on 17/01/2017.
 */
public class AndroidNotificationGenerator {

  private int notificationId = 0;
  private final Context context;
  private NotificationGeneratorBuilder mNotGenBuilder;

  public AndroidNotificationGenerator(NotificationGeneratorBuilder notificationGeneratorBuilder) {
    this.context = notificationGeneratorBuilder.getmContext();
    this.mNotGenBuilder = notificationGeneratorBuilder;
  }

  public void createNotificationPush(NotificationModel orchextraNotification,
      PendingIntent pendingIntent) {
    createNotification(orchextraNotification, pendingIntent, true);
  }

  public void createNotification(NotificationModel orchextraNotification,
      PendingIntent pendingIntent) {
    createNotification(orchextraNotification, pendingIntent, false);
  }

  private void createNotification(NotificationModel orchextraNotification,
      PendingIntent pendingIntent, boolean isPush) {
    Notification notification;

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
      notification = createBigNotification(orchextraNotification, pendingIntent, isPush);
    } else {
      notification = createNormalNotification(orchextraNotification, pendingIntent);
    }

    NotificationManager notificationManager =
        (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

    //only 1 notification entry, for the same action notificationManager.notify((int) notificationId, notification);
    //one notification for action response, no care if the same notification, this is the first implementation
    notificationManager.notify((int) (System.currentTimeMillis() % Integer.MAX_VALUE),
        notification);
  }

  @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
  private Notification createBigNotification(NotificationModel notification,
      PendingIntent pendingIntent, boolean isPush) {

    Bitmap largeIcon = BitmapFactory.decodeResource(context.getResources(),
        mNotGenBuilder.getmDrawablesNotGenBuilder().getLarge_color_icon());
    Notification.Builder mNotifyBuilder = new Notification.Builder(context);

    RemoteViews mContentView;
    if (isPush) {
      mContentView = new RemoteViews(this.context.getPackageName(),
          mNotGenBuilder.getmLayoutNotGenBuilder().getNormal_push_notification_layout());
    } else {
      mContentView = new RemoteViews(this.context.getPackageName(),
          mNotGenBuilder.getmLayoutNotGenBuilder().getNormal_local_notification_layout());
    }
    try {
      //images
      mContentView.setImageViewResource(
          mNotGenBuilder.getmViewIdNotGenBuilder().getImageViewLargeIcon(),
          mNotGenBuilder.getmDrawablesNotGenBuilder().getLarge_color_icon());
      mContentView.setImageViewResource(
          mNotGenBuilder.getmViewIdNotGenBuilder().getImageViewSmallColorIcon(),
          mNotGenBuilder.getmDrawablesNotGenBuilder().getSmall_color_icon());
      //title & body
      mContentView.setTextViewText(mNotGenBuilder.getmViewIdNotGenBuilder().getTextViewTitle(),
          notification.getTitle());
      mContentView.setTextViewText(mNotGenBuilder.getmViewIdNotGenBuilder().getTextViewBody(),
          notification.getBody());
      //time
      //fixme mContentView.setLong(R.id.time, "setTime", mNotifyBuilder.build().when);
      mContentView.setLong(mNotGenBuilder.getmViewIdNotGenBuilder().getDateTimeView(), "setTime",
          mNotifyBuilder.build().when);
    } catch (Exception e) {
      if (isPush) {
        System.out.println("Something gone wrong with Notification. \n"
            + "You can't delete/change id of Views, in R.layout.custom_normal_push_notification, use visibility gone instead");
      } else {
        System.out.println("Something gone wrong with Notification. \n"
            + "You can't delete/change id of Views, in R.layout.custom_normal_local_notification, use visibility gone instead");
      }
    }

    Notification builder = mNotifyBuilder.setSmallIcon(
        mNotGenBuilder.getmDrawablesNotGenBuilder().getSmall_alpha_icon())
        .setLargeIcon(largeIcon)
        .setContent(mContentView)
        .setContentIntent(pendingIntent)
        .setWhen(System.currentTimeMillis())
        .setAutoCancel(true)
        .build();

    //region big notification
    RemoteViews bigView;
    if (isPush) {
      bigView = new RemoteViews(this.context.getPackageName(),
          mNotGenBuilder.getmLayoutNotGenBuilder().getBig_push_notification_layout());
    } else {
      bigView = new RemoteViews(this.context.getPackageName(),
          mNotGenBuilder.getmLayoutNotGenBuilder().getBig_local_notification_layout());
    }

    try {
      //images
      bigView.setImageViewResource(mNotGenBuilder.getmViewIdNotGenBuilder().getImageViewLargeIcon(),
          mNotGenBuilder.getmDrawablesNotGenBuilder().getLarge_color_icon());
      bigView.setImageViewResource(
          mNotGenBuilder.getmViewIdNotGenBuilder().getImageViewSmallColorIcon(),
          mNotGenBuilder.getmDrawablesNotGenBuilder().getSmall_color_icon());
      //title & body
      bigView.setTextViewText(mNotGenBuilder.getmViewIdNotGenBuilder().getTextViewTitle(),
          notification.getTitle());
      bigView.setTextViewText(mNotGenBuilder.getmViewIdNotGenBuilder().getTextViewBody(),
          notification.getBody());
      //time
      //fixme  bigView.setLong(R.id.time, "setTime", mNotifyBuilder.build().when);
      bigView.setLong(mNotGenBuilder.getmViewIdNotGenBuilder().getDateTimeView(), "setTime",
          mNotifyBuilder.build().when);
    } catch (Exception e) {
      if (isPush) {
        System.out.println("Something gone wrong with Notification. \n"
            + "You can't delete/change id of Views, in R.layout.custom_big_push_notification, use visibility gone instead");
      } else {
        System.out.println("Something gone wrong with Notification. \n"
            + "You can't delete/change id of Views, in R.layout.custom_big_local_notification, use visibility gone instead");
      }
    }
    //endregion

    mNotifyBuilder.setContent(mContentView);
    builder.bigContentView = bigView;

    if (pendingIntent != null) {
      mNotifyBuilder.setContentIntent(pendingIntent);
    }

    return builder;
  }
  //region show notifications when  <Build.VERSION_CODES.JELLY_BEAN) (not Custom)

  private int getSmallIconResourceId() {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
        ? mNotGenBuilder.getmDrawablesNotGenBuilder().getSmall_alpha_icon()
        : mNotGenBuilder.getmDrawablesNotGenBuilder().getSmall_color_icon();
  }

  private Notification createNormalNotification(NotificationModel notification,
      PendingIntent pendingIntent) {
    Bitmap largeIcon = BitmapFactory.decodeResource(context.getResources(),
        mNotGenBuilder.getmDrawablesNotGenBuilder().getLarge_color_icon());
    Notification noti = new Notification();
    //// FIXME: 17/01/2017
    //cambiar a NOtification y pasar de la implementacion externa de la support?
   /**/
    // NotificationCompat.Builder builder;
    Notification.Builder builder;
    //  if (pendingIntent != null) {
     /* builder = new NotificationCompat.Builder(context).setLargeIcon(largeIcon)
          .setSmallIcon(getSmallIconResourceId())
          .setContentTitle(notification.getTitle())
          .setContentText(notification.getBody())
          .setTicker(notification.getTitle())
          .setContentIntent(pendingIntent)
          .setWhen(System.currentTimeMillis())
          .setAutoCancel(true);
*/
    builder = new Notification.Builder(context).setLargeIcon(largeIcon)
        .setSmallIcon(getSmallIconResourceId())
        .setContentTitle(notification.getTitle())
        .setContentText(notification.getBody())
        .setTicker(notification.getTitle())
        .setContentIntent(pendingIntent) //todo esto si debe comprobar si pending intent !=null
        .setWhen(System.currentTimeMillis())
        .setAutoCancel(true);

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
      noti = builder.build();
    } else {
      noti = builder.getNotification();
    }
    //}
    return noti;
  }
  //endregion
}
