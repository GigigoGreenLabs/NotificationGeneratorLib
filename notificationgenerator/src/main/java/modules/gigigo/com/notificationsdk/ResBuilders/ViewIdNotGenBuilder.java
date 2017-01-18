package modules.gigigo.com.notificationsdk.ResBuilders;

import modules.gigigo.com.notificationsdk.R;

/**
 * Created by nubor on 18/01/2017.
 */
public class ViewIdNotGenBuilder {
  int imageViewLargeIcon = R.id.ox_notifimage_custom_local_notification;
  int textViewTitle = R.id.ox_notiftitle_custom_local_notification;
  int textViewBody = R.id.ox_notiftext_custom_local_notification;
  int imageViewSmallColorIcon = R.id.ox_notifimage_small_custom_local_notification;
  int dateTimeView = R.id.ox_time_custom_local_notification;

  //region Getters
  public int getImageViewLargeIcon() {
    return imageViewLargeIcon;
  }

  public int getTextViewTitle() {
    return textViewTitle;
  }

  public int getTextViewBody() {
    return textViewBody;
  }

  public int getImageViewSmallColorIcon() {
    return imageViewSmallColorIcon;
  }

  public int getDateTimeView() {
    return dateTimeView;
  }
  //endregion

  //region Setters
  public ViewIdNotGenBuilder setImageViewLargeIcon(int imageViewLargeIcon) {
    this.imageViewLargeIcon = imageViewLargeIcon;
    return this;
  }

  public ViewIdNotGenBuilder setTextViewTitle(int textViewTitle) {
    this.textViewTitle = textViewTitle;
    return this;
  }

  public ViewIdNotGenBuilder setTextViewBody(int textViewBody) {
    this.textViewBody = textViewBody;
    return this;
  }

  public ViewIdNotGenBuilder setImageViewSmallColorIcon(int imageViewSmallColorIcon) {
    this.imageViewSmallColorIcon = imageViewSmallColorIcon;
    return this;
  }

  public ViewIdNotGenBuilder setDateTimeView(int dateTimeView) {
    this.dateTimeView = dateTimeView;
    return this;
  }
  //endregion
}
