package modules.gigigo.com.notificationsdk;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import modules.gigigo.com.notificationsdk.Builders.NotificationGeneratorBuilder;

/**
 * Created by nubor on 18/01/2017.
 */
public class NotificationGenerator {
  public static NotificationGeneratorBuilder mBuilder;

  public static void initResources(NotificationGeneratorBuilder builder) {
    mBuilder = builder;
  }

  public static void createNotification(String title, String body) {
    createNotification(title, body, false);
  }

  public static void createNotification(String title, String body, boolean isPush)
      throws RuntimeException {
    if (mBuilder.getmContext() != null) {
      AndroidNotificationGenerator a = new AndroidNotificationGenerator(mBuilder);
      NotificationModel n = new NotificationModel(title, body);
      if (isPush) {
        a.createNotificationPush(n, null);
      } else {
        a.createNotification(n, null);
      }
    } else {
      throw new RuntimeException();
    }
  }

  public PendingIntent getPendingIntent(Object androidBasicAction) {
    Intent intent = new Intent();/*
        new Intent(context, NotificationReceiver.class).setAction(NOTIFICATION_ACTION_OX)
            .putExtra(NotificationReceiver.NOTIFICATION_BROADCAST_RECEIVER,
                NotificationReceiver.NOTIFICATION_BROADCAST_RECEIVER)
            .putExtra(EXTRA_NOTIFICATION_ACTION, androidBasicAction)
            .putExtra(AndroidNotificationBuilder.HAVE_ACTIVITY_NOTIFICATION_OX, false)
            .setFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);

    notificationId = androidBasicAction.hashCode();
*/
    return PendingIntent.getBroadcast(mBuilder.getmContext(), 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
  }
}
