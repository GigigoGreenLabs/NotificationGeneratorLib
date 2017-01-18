package modules.gigigo.com.notificationsdk;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by nubor on 17/01/2017.
 */
/*

  se debe instanciar AndroidNotificationBuiklder al que se le debe pasar el intetn asi como el
  contenido de la notificacion, el intent es una putada, xq la interface debe ser android, no pasa na, xo eso es asine
      tab se debe dar una funcion q genere el intent y meta un list<String,object> en el intent
      los flags lo mismo tb o cosas configurables a parte de las imagenes y los layour q se hace cpor resources

  crear tb un NOtificatin builder al que se le pasan todos los datos
  siend un builder se le pueden pasar tb los resources desde la app integradora y riau tia coneja
  esto abre la veda a que se creen dos nuevos builders para este builder uno de imagesn y otro de layouts
*/
//no tiene mucho sentido el manager, aunque me gusta la pieza, a ver q invento para usarlo

  @Deprecated
 class NotificationGeneratorManager {

  Context mContext;

  /// esto reguleras, creo qestosobra
  //public static void createNotification(Context context, String title, String body){
  //  AndroidNotificationGenerator a = new AndroidNotificationGenerator(context, NotificationGenerator.mBuilder);
  //  NotificationModel n = new NotificationModel(title,body);
  //  a.createNotification(n,null);
  //}

/*generacion del pending intent inside notificacion*/
  @Deprecated public static final String EXTRA_NOTIFICATION_ACTION = "OX_EXTRA_NOTIFICATION_ACTION";
  public static final String NOTIFICATION_ACTION_OX = "NOTIFICATION_ACTION_OX";
  public static final String HAVE_ACTIVITY_NOTIFICATION_OX = "HAVE_ACTIVITY_NOTIFICATION_OX";


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
    return PendingIntent.getBroadcast(mContext, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
  }


  public PendingIntent getPendingIntent(HashMap<String,Objects> hashMap) {
    Intent intent = new Intent();/*
        new Intent(context, NotificationReceiver.class).setAction(NOTIFICATION_ACTION_OX)
            .putExtra(NotificationReceiver.NOTIFICATION_BROADCAST_RECEIVER,
                NotificationReceiver.NOTIFICATION_BROADCAST_RECEIVER)
            .putExtra(EXTRA_NOTIFICATION_ACTION, androidBasicAction)
            .putExtra(AndroidNotificationBuilder.HAVE_ACTIVITY_NOTIFICATION_OX, false)
            .setFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);

    notificationId = androidBasicAction.hashCode();
*/
    return PendingIntent.getBroadcast(mContext, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
  }


}


