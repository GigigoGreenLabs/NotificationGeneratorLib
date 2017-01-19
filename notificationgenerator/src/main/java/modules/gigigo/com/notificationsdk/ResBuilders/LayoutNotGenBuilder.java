package modules.gigigo.com.notificationsdk.ResBuilders;

import modules.gigigo.com.notificationsdk.R;

/**
 * Created by nubor on 18/01/2017.
 */
public class LayoutNotGenBuilder {

  private int big_push_notification_layout = R.layout.custom_big_push_notification;
  private int big_local_notification_layout = R.layout.custom_big_local_notification;

  private int normal_push_notification_layout = R.layout.custom_normal_push_notification;
  private int normal_local_notification_layout = R.layout.custom_normal_local_notification;

  //region getters
  public int getBig_push_notification_layout() {
    return big_push_notification_layout;
  }

  public int getBig_local_notification_layout() {
    return big_local_notification_layout;
  }

  public int getNormal_push_notification_layout() {
    return normal_push_notification_layout;
  }

  public int getNormal_local_notification_layout() {
    return normal_local_notification_layout;
  }

  //endregion
  //region setters
  public LayoutNotGenBuilder setBig_push_notification_layout(int big_push_notification_layout) {
    this.big_push_notification_layout = big_push_notification_layout;
    return this;
  }

  public LayoutNotGenBuilder setBig_local_notification_layout(int big_local_notification_layout) {
    this.big_local_notification_layout = big_local_notification_layout;
    return this;
  }

  public LayoutNotGenBuilder setNormal_push_notification_layout(
      int normal_push_notification_layout) {
    this.normal_push_notification_layout = normal_push_notification_layout;
    return this;
  }

  public LayoutNotGenBuilder setNormal_local_notification_layout(
      int normal_local_notification_layout) {
    this.normal_local_notification_layout = normal_local_notification_layout;
    return this;
  }
  //endregion
}
