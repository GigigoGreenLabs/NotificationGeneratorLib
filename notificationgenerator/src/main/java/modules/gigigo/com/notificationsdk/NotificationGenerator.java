package modules.gigigo.com.notificationsdk;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
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
    createNotification(title, body, false, null);
  }

  public static void createNotification(String title, String body, boolean isPush,
      PendingIntent pendingIntent) throws RuntimeException {
    if (mBuilder.getmContext() != null) {
      AndroidNotificationGenerator a = new AndroidNotificationGenerator(mBuilder);
      NotificationModel n = new NotificationModel(title, body);
      if (isPush) {
        a.createNotificationPush(n, pendingIntent);
      } else {
        a.createNotification(n, pendingIntent);
      }
    } else {
      throw new RuntimeException();
    }
  }

  public PendingIntent getPendingIntent(Bundle extras, Class classe, String actionStr) {
    return getPendingIntent(  extras, classe, actionStr, 1);
  }

  public PendingIntent getPendingIntent(Bundle extras, Class classe, String actionStr,
      int notificationId) {
    if (mBuilder.getmContext() != null) {
      Intent intent = new Intent();
      new Intent(mBuilder.getmContext(), classe).setAction(actionStr)
          .setFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
          .putExtras(extras);

      return PendingIntent.getBroadcast(mBuilder.getmContext(), notificationId, intent,
          PendingIntent.FLAG_UPDATE_CURRENT);
    } else {
      return null;
    }
  }


}
