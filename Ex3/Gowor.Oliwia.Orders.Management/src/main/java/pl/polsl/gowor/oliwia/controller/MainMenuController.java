/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pl.polsl.gowor.oliwia.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import pl.polsl.gowor.oliwia.orders.management.App;

/**
 * FXML Controller class responsible for controlling the MainMenu view of
 * application.
 *
 * @author Oliwia Gowor
 * @version 3.0
 */
public class MainMenuController {

    /**
     * Value represents object of the Button class
     */
    @FXML
    private Button buttonPrintOrders;
    /**
     * Value represents object of the Button class
     */
    @FXML
    private Button buttonAddOrder;
    /**
     * Value represents object of the Button class
     */
    @FXML
    private Button buttonDeleteOrder;
    /**
     * Value represents object of the Button class
     */
    @FXML
    private Button buttonSearchOrder;
    /**
     * Value represents object of the Button class
     */
    @FXML
    private Button buttonQuit;

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param url The location used to resolve relative paths for the root
     * object, or null if the location is not known.
     * @param rb The resources used to localize the root object, or null if the
     * root object was not localized.
     */
    public void initialize(URL url, ResourceBundle rb) {
    }

    /**
     * Button handler which opens ShowAllOrders view.
     *
     * @param event An event representing some type of action
     * @throws IOException Signals that an I/O exception of some sort has
     * occurred.
     */
    @FXML
    private void printOrders(ActionEvent event) throws IOException {
        App.setRoot("ShowAllOrders");
    }

    /**
     * Button handler which opens AddOrder view.
     *
     * @param event An event representing some type of action
     * @throws IOException Signals that an I/O exception of some sort has
     * occurred.
     */
    @FXML
    private void addOrder(ActionEvent event) throws IOException {
        App.setRoot("AddOrder");
    }

    /**
     * Button handler which opens DeleteOrder view.
     *
     * @param event An event representing some type of action
     * @throws IOException Signals that an I/O exception of some sort has
     * occurred.
     */
    @FXML
    private void deleteOrder(ActionEvent event) throws IOException {
        App.setRoot("DeleteOrder");
    }

    /**
     * Button handler which opens SearchMenu view.
     *
     * @param event An event representing some type of action
     * @throws IOException Signals that an I/O exception of some sort has
     * occurred.
     */
    @FXML
    private void menuSearchOrders(ActionEvent event) throws IOException {
        App.setRoot("SearchMenu");
    }

    /**
     * Button handler which closes menu view.
     *
     * @param event An event representing some type of action
     */
    @FXML
    private void quitApp(ActionEvent event) throws IOException {
        Stage stage = (Stage) buttonQuit.getScene().getWindow();
        stage.close();
    }

}
