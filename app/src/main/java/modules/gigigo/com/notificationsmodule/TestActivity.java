package modules.gigigo.com.notificationsmodule;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import modules.gigigo.com.notificationsdk.Builders.NotificationGeneratorBuilder;
import modules.gigigo.com.notificationsdk.NotificationGenerator;
import modules.gigigo.com.notificationsdk.ResBuilders.DrawablesNotGenBuilder;
import modules.gigigo.com.notificationsdk.ResBuilders.LayoutNotGenBuilder;
import modules.gigigo.com.notificationsdk.ResBuilders.ViewIdNotGenBuilder;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {
  NotificationGenerator mNotificationGenerator = new NotificationGenerator();
  DrawablesNotGenBuilder mDrawablesNotGenBuilder =
      new DrawablesNotGenBuilder().setLarge_color_icon(R.drawable.app_large_icon)
          .setSmall_alpha_icon(R.drawable.app_alpha_small_icon)
          .setSmall_color_icon(R.drawable.app_color_small_icon);

  LayoutNotGenBuilder mLayoutNotGenBuilder =
      new LayoutNotGenBuilder().setBig_local_notification_layout(
          R.layout.black_big_local_notification)
          .setBig_push_notification_layout(R.layout.black_big_push_notification)
          .setNormal_local_notification_layout(R.layout.black_normal_local_notification)
          .setNormal_push_notification_layout(R.layout.black_normal_push_notification);

  ViewIdNotGenBuilder mViewIdNotGenBuilder =
      new ViewIdNotGenBuilder().setDateTimeView(R.id.app_time_custom_local_notification)
          .setImageViewLargeIcon(R.id.app_notifimage_custom_local_notification)
          .setImageViewSmallColorIcon(R.id.app_notifimage_small_custom_local_notification)
          .setTextViewBody(R.id.app_notiftext_custom_local_notification)
          .setTextViewTitle(R.id.app_notiftitle_custom_local_notification);

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_test);
    getViewsAndSetOnClickListener();
  }

  private void createNotification(NotificationGeneratorBuilder builder, String title, String body) {
    NotificationGenerator.initResources(builder, getPackageName(), "Notifications Name");
    boolean isPush = false;
    isPush = ((CompoundButton) findViewById(R.id.chk_is_push)).isChecked();

    if (isPush) title = "PUSH " + title;
    NotificationGenerator.createNotification(title, body, isPush, getPendingIntent("urlscheme"));

  }

  private void getViewsAndSetOnClickListener() {
    findViewById(R.id.button1).setOnClickListener(this);
    findViewById(R.id.button2).setOnClickListener(this);
    findViewById(R.id.button3).setOnClickListener(this);
    findViewById(R.id.button4).setOnClickListener(this);
  }

  @Override public void onClick(View v) {
    NotificationGeneratorBuilder builder = new NotificationGeneratorBuilder(this);
    String title = "Notifications";
    String body = (String) ((Button) v).getText();
    if (v.getId() == R.id.button2) {
      builder.setmDrawablesNotGenBuilder(mDrawablesNotGenBuilder);
    }

    if (v.getId() == R.id.button3) {
      builder.setmLayoutNotGenBuilder(mLayoutNotGenBuilder);
      builder.setmViewIdNotGenBuilder(mViewIdNotGenBuilder);
    }

    if (v.getId() == R.id.button4) {
      builder.setmDrawablesNotGenBuilder(mDrawablesNotGenBuilder);
      builder.setmLayoutNotGenBuilder(mLayoutNotGenBuilder);
      builder.setmViewIdNotGenBuilder(mViewIdNotGenBuilder);
    }

    createNotification(builder, title, body);
  }

  public static final String EXTRA_NOTIFICATION_PUSH_URL_SCHEME_ACTION =
      "EXTRA_NOTIFICATION_PUSH_URL_SCHEME_ACTION";

  public PendingIntent getPendingIntent(String UrlScheme) {
     Intent i = new Intent(this, MyBroadCastReceiver.class);
    i.putExtra(EXTRA_NOTIFICATION_PUSH_URL_SCHEME_ACTION, UrlScheme);
    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
        | Intent.FLAG_ACTIVITY_NEW_TASK
        | Intent.FLAG_ACTIVITY_CLEAR_TASK);

    int notificationId = 1;
    return PendingIntent.getBroadcast(this, notificationId, i, PendingIntent.FLAG_UPDATE_CURRENT);
  }
}
