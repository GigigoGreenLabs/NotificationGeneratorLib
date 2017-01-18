package modules.gigigo.com.notificationsdk;

/**
 * Created by nubor on 17/01/2017.
 */
public class NotificationModel {

  private String title;
  private String body;
  private boolean shown = false;

  private String Flags_Notification="ESTO ESTA POR VER COMO VIAJE; ARRAY DE INT ES MAS CORRECTO";
  private String Id_Notification="ESTO ESTA para ver si quieres q te tupa a notificaciones, o bien actualize una ya creada";


  public NotificationModel(String title, String body) {
    this.title = title;
    this.body = body;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public boolean shouldBeShown() {
    return !shown;
  }

  public void setShown(boolean shown) {
    this.shown = shown;
  }

  public boolean isShown() {
    return shown;
  }

//fixme Hashcode para poder ver si son notificaciones iguales o no
}
