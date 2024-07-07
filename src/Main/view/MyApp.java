package Main.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene=new Scene(
                FXMLLoader.load(getClass().getResource("EduApp.fxml"))
        );
        primaryStage.setScene(scene);
        primaryStage.setTitle("EduApp");
        primaryStage.show();

    }
}
