package pl.polsl.gowor.oliwia.orders.management;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import static javafx.application.Application.launch;
import pl.polsl.gowor.oliwia.model.OrdersList;

/**
 * JavaFX App - main class of the application realizing the operations on the
 * orders database. 
 * Command line parameters order: program name
 * (OrdersManagement), role (admin - can see and modify data; or viewer - can
 * only see data). For example: OrdersManagement admin
 *
 * @author Oliwia Gowor
 * @version 3.0
 */
public class App extends Application {

    /**
     * Value represents object of the Scene class
     */
    public static Scene scene;
    /**
     * Value represents object of the OrdersList class
     */
    public static OrdersList model;

    /**
     * The start method is called after the init method has returned, and after
     * the system is ready for the application to begin running.
     *
     * @param stage The primary stage for this application, onto which the
     * application scene can be set
     * @throws IOException Signals that an I/O exception of some sort has
     * occurred.
     */
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("MainMenu"), 1310, 700);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Sets the value of the property root.
     *
     * @param fxml FXML file name
     * @throws IOException Signals that an I/O exception of some sort has
     * occurred.
     */
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Returns Parent object of fxml file.
     *
     * @param fxml FXML file name
     * @return Parent object
     * @throws IOException Signals that an I/O exception of some sort has
     * occurred.
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * Main method of the application used to start project
     *
     * @param args arguments entered into command line when the program is
     * started
     */
    public static void main(String[] args) {
        model = new OrdersList();
        model.initialize();
        launch();
    }

}
