package modules.gigigo.com.notificationsdk.ResBuilders;

import modules.gigigo.com.notificationsdk.R;

/**
 * Created by nubor on 18/01/2017.
 */
public class DrawablesNotGenBuilder {

  int small_color_icon = R.drawable.notification_color_small_icon;
  int large_color_icon = R.drawable.notification_large_icon;
  int small_alpha_icon = R.drawable.notification_small_alpha_icon;

  //region Getters
  public int getSmall_color_icon() {
    return small_color_icon;
  }

  public int getLarge_color_icon() {
    return large_color_icon;
  }

  public int getSmall_alpha_icon() {
    return small_alpha_icon;
  }

  //endregion
  //region Setters
  public DrawablesNotGenBuilder setSmall_color_icon(int small_color_icon) {
    this.small_color_icon = small_color_icon;
    return this;
  }

  public DrawablesNotGenBuilder setLarge_color_icon(int large_color_icon) {
    this.large_color_icon = large_color_icon;
    return this;
  }

  public DrawablesNotGenBuilder setSmall_alpha_icon(int small_alpha_icon) {
    this.small_alpha_icon = small_alpha_icon;
    return this;
  }
  //endregion
}
