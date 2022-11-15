/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.gowor.oliwia.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import pl.polsl.gowor.oliwia.model.OrderNotFoundException;
import pl.polsl.gowor.oliwia.orders.management.App;
import static pl.polsl.gowor.oliwia.orders.management.App.model;

/**
 * FXML Controller class responsible for controlling the DeleteOrder view of
 * application which lets user delete existing order.
 *
 * @author Oliwia Gowor
 * @version 3.0
 */
public class DeleteOrderController {

    /**
     * Value represents object of the TextField class
     */
    @FXML
    private TextField fieldOrderNumber;
    /**
     * Value represents object of the Text class
     */
    @FXML
    private Text errorMsg;
    /**
     * Value represents object of the Button class
     */
    @FXML
    private Button buttonReturn;
    /**
     * Value represents object of the Button class
     */
    @FXML
    private Button buttonDeleteOrder;

    /**
     * Method deletes a order from list.
     *
     * @param event An event representing some type of action
     * @throws IOException Signals that an I/O exception of some sort has
     * occurred.
     */
    @FXML
    void deleteOrder(ActionEvent event) throws IOException {
        try {
            model.deleteOrder(fieldOrderNumber.getText());
            errorMsg.setText("Order " + fieldOrderNumber.getText() + " deleted successfully!");
        } catch (OrderNotFoundException ex) {
            errorMsg.setText("Order not found");
            errorMsg.setVisible(true);
        } catch (Exception ex) {
            errorMsg.setText("Uknown problem");
            errorMsg.setVisible(true);
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
