package modules.gigigo.com.notificationsdk.Builders;

import android.content.Context;
import modules.gigigo.com.notificationsdk.ResBuilders.DrawablesNotGenBuilder;
import modules.gigigo.com.notificationsdk.ResBuilders.LayoutNotGenBuilder;
import modules.gigigo.com.notificationsdk.ResBuilders.ViewIdNotGenBuilder;

/**
 * Created by nubor on 18/01/2017.
 */
public class NotificationGeneratorBuilder {
  private Context mContext;//constructor
  private LayoutNotGenBuilder mLayoutNotGenBuilder = new LayoutNotGenBuilder();
  private DrawablesNotGenBuilder mDrawablesNotGenBuilder = new DrawablesNotGenBuilder();
  private ViewIdNotGenBuilder mViewIdNotGenBuilder = new ViewIdNotGenBuilder();

  //region Getters

  public Context getmContext() {
    return mContext;
  }

  public LayoutNotGenBuilder getmLayoutNotGenBuilder() {
    return mLayoutNotGenBuilder;
  }

  public DrawablesNotGenBuilder getmDrawablesNotGenBuilder() {
    return mDrawablesNotGenBuilder;
  }

  public ViewIdNotGenBuilder getmViewIdNotGenBuilder() {
    return mViewIdNotGenBuilder;
  }
  //endregion

  //region Setters
  public NotificationGeneratorBuilder setmLayoutNotGenBuilder(
      LayoutNotGenBuilder mLayoutNotGenBuilder) {
    this.mLayoutNotGenBuilder = mLayoutNotGenBuilder;
    return this;
  }

  public NotificationGeneratorBuilder setmDrawablesNotGenBuilder(
      DrawablesNotGenBuilder mDrawablesNotGenBuilder) {
    this.mDrawablesNotGenBuilder = mDrawablesNotGenBuilder;
    return this;
  }

  public NotificationGeneratorBuilder setmViewIdNotGenBuilder(
      ViewIdNotGenBuilder mViewIdNotGenBuilder) {
    this.mViewIdNotGenBuilder = mViewIdNotGenBuilder;
    return this;
  }
  //endregion

  public NotificationGeneratorBuilder(Context mContext) {
    this.mContext = mContext;
  }
}
