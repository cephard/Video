
package self;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("view"), 700, 480);
        stage.setTitle("Cafe94");
        stage.setScene(scene);
        stage.show();
    }

    public static String userType="";
    private static final App instance = new App();
    public static App getInstance() {
        return instance;
    }
    @FXML
    private void switchToStaff() throws IOException {
        this.userType="Staff";
        App.setRoot("staffLogin");
    }

    @FXML
    private void switchToCustomer() throws IOException {
        this.userType="Customer";
        App.setRoot("login");
    }

    public static String getUserType(){
        return userType;
    }
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}
