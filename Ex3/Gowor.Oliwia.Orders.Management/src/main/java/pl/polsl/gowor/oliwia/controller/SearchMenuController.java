/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pl.polsl.gowor.oliwia.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import pl.polsl.gowor.oliwia.model.Date;
import pl.polsl.gowor.oliwia.model.Order;
import pl.polsl.gowor.oliwia.model.OrderNotFoundException;
import pl.polsl.gowor.oliwia.orders.management.App;
import static pl.polsl.gowor.oliwia.orders.management.App.model;

/**
 * FXML Controller class responsible for controlling the SearchMenu view of
 * application which lets user search orders by number or date.
 *
 * @author Oliwia Gowor
 * @version 3.0
 */
public class SearchMenuController {

    /**
     * Value represents object of the Button class
     */
    @FXML
    private Button buttonQuit;
    /**
     * Value represents object of the Button class
     */
    @FXML
    private Button buttonSearchByNumber;
    /**
     * Value represents object of the Button class
     */
    @FXML
    private Button buttonSearchByDate;
    /**
     * Value represents object of the Button class
     */
    @FXML
    private Button buttonReturn;
    /**
     * Value represents object of the TextField class
     */
    @FXML
    private TextField fieldOrderNumber;
    /**
     * Value represents object of the DatePicker class
     */
    @FXML
    private DatePicker fieldOrderDate;
    /**
     * Value represents object of the Text class
     */
    @FXML
    private Text errorMsgNumber;
    /**
     * Value represents object of the Text class
     */
    @FXML
    private Text errorMsgDate;
    /**
     * Value represents list of found orders
     */
    public static List<Order> foundOrders;

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     */
    @FXML
    public void initialize() {
        foundOrders = new ArrayList();
    }

    /**
     * DatePicker handler which reacts to date being chosen by user.
     *
     * @return chosen day by user
     */
    @FXML
    Date pickDate() {
        if (fieldOrderDate.getValue() != null) {
            Date date = new Date(fieldOrderDate.getValue().getYear(), fieldOrderDate.getValue().getMonthValue(), fieldOrderDate.getValue().getDayOfMonth());
            return date;
        } else {
            Date date = new Date(0, 0, 0);
            return date;
        }
    }

    /**
     * Button handler which allows to search order by number.
     *
     * @param event An event representing some type of action
     * @throws IOException Signals that an I/O exception of some sort has
     * occurred.
     */
    @FXML
    private void searchByNumber(ActionEvent event) throws IOException {
        try {
            foundOrders = model.searchOrderByNumber(fieldOrderNumber.getText());
            App.setRoot("ShowFoundOrders");
        } catch (OrderNotFoundException ex) {
            errorMsgNumber.setText("Couldn't find order with such number!");
        }

    }

    /**
     * Button handler which allows to search order by number.
     *
     * @param event An event representing some type of action
     * @throws IOException Signals that an I/O exception of some sort has
     * occurred.
     */
    @FXML
    private void searchByDate(ActionEvent event) throws IOException {
        try {
            foundOrders = model.searchOrderByDate(pickDate());
            App.setRoot("ShowFoundOrders");
        } catch (OrderNotFoundException ex) {
            errorMsgDate.setText("Couldn't find order with such date!");
        }
    }

    /**
     * Button handler which opens MainMenu view.
     *
     * @param event An event representing some type of action
     * @throws IOException Signals that an I/O exception of some sort has
     * occurred.
     */
    @FXML
    private void returnToMainMenu(ActionEvent event) throws IOException {
        App.setRoot("MainMenu");
    }

}
