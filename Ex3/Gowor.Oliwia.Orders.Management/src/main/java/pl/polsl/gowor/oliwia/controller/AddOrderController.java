/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pl.polsl.gowor.oliwia.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import static pl.polsl.gowor.oliwia.orders.management.App.model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import pl.polsl.gowor.oliwia.model.Buyer;
import pl.polsl.gowor.oliwia.model.Date;
import pl.polsl.gowor.oliwia.model.Order;
import pl.polsl.gowor.oliwia.model.Product;
import pl.polsl.gowor.oliwia.model.Product.VatRate;
import pl.polsl.gowor.oliwia.orders.management.App;

/**
 * FXML Controller class responsible for controlling the AddOrder view of
 * application which lets user add new order.
 *
 * @author Oliwia Gowor
 * @version 3.0
 */
public class AddOrderController implements Initializable {

    /**
     * Value represents object of the TextField class
     */
    @FXML
    private TextField fieldOrderNumber;
    /**
     * Value represents object of the TextField class
     */
    @FXML
    private TextField fieldBuyerName;
    /**
     * Value represents object of the TextField class
     */
    @FXML
    private TextField fieldBuyerSurname;
    /**
     * Value represents object of the TextField class
     */
    @FXML
    private TextField fieldBuyerAddress;
    /**
     * Value represents object of the DatePicker class
     */
    @FXML
    private DatePicker datePicker;
    /**
     * Value represents object of the TextField class
     */
    @FXML
    private TextField fieldPaymentMethod;
    /**
     * Value represents object of the Text class
     */
    @FXML
    private Text errorMsgProduct;
    /**
     * Value represents object of the Text class
     */
    @FXML
    private Text errorMsgOrder;
    /**
     * Value represents object of the Label class
     */
    @FXML
    private Label textAddedProducts;
    /**
     * Value represents object of the TextField class
     */
    @FXML
    private TextField fieldProductName;
    /**
     * Value represents object of the TextField class
     */
    @FXML
    private TextField fieldPriceNetto;
    /**
     * Value represents object of the TextField class
     */
    @FXML
    private TextField fieldUnit;
    /**
     * Value represents object of the Button class
     */
    @FXML
    private Button buttonFinish;
    /**
     * Value represents object of the Button class
     */
    @FXML
    private Button buttonReturn;
    /**
     * Value represents object of the Button class
     */
    @FXML
    private Button buttonAddNextProduct;
    /**
     * Value represents object of the Button class
     */
    @FXML
    private Button buttonDeleteProduct;
    /**
     * Value represents object of the ChoiceBox class
     */
    @FXML
    private ChoiceBox<Product.VatRate> inputVatRate;
    /**
     * Value represents object of the TextField class
     */
    @FXML
    private TextField fieldQuantinity;
    /**
     * Value represents object of the TableView class
     */
    @FXML
    private TableView<Product> productsTable;
    /**
     * Value represents object of the TableView class
     */
    @FXML
    private TableColumn<Product, String> nameCol;
    /**
     * Value represents object of the TableView class
     */
    @FXML
    private TableColumn<Product, Double> priceNettoCol;
    /**
     * Value represents object of the TableColumn class
     */
    @FXML
    private TableColumn<Product, Product.VatRate> vatRateCol;
    /**
     * Value represents object of the TableColumn class
     */
    @FXML
    private TableColumn<Product, Integer> quantinityCol;
    /**
     * Value represents object of the TableColumn class
     */
    @FXML
    private TableColumn<Product, String> unitCol;
    /**
     * Value represents list of the products in order
     */
    private List<Product> products;
    /**
     * Value represents counter of the products in order
     */
    private int counter;
    /**
     * Value represents ObservableList of products in the order
     */
    private ObservableList<Product> data;

    /**
     * Non-parameter AddOrderController class constructor
     */
    public AddOrderController() {
        products = new ArrayList();
        data = FXCollections.observableArrayList(products);
        data.addListener(new ListChangeListener<Product>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Product> change) {
                while (change.next()) {
                    if (change.wasPermutated()) {
                        for (int i = change.getFrom(); i < change.getTo(); ++i) {
                            System.out.println("zamiana");
                        }
                    } else if (change.wasUpdated()) {
                        System.out.println("uaktualnienie");
                    } else {
                        for (var remitem : change.getRemoved()) {
                            products.remove(remitem);
                        }
                        for (var additem : change.getAddedSubList()) {
                            products.add(additem);
                        }
                    }
                }
            }
        });
    }

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param url The location used to resolve relative paths for the root
     * object, or null if the location is not known.
     * @param rb The resources used to localize the root object, or null if the
     * root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inputVatRate.setItems(FXCollections.observableArrayList(Product.VatRate.ZERO, Product.VatRate.FIVE, Product.VatRate.EIGHT, Product.VatRate.TWENTYTHREE));
        counter = 0;
        productsTable.setItems(data);
        nameCol.setCellValueFactory(new PropertyValueFactory<Product, String>("productName"));
        priceNettoCol.setCellValueFactory(new PropertyValueFactory<Product, Double>("priceNetto"));
        vatRateCol.setCellValueFactory(new PropertyValueFactory<Product, Product.VatRate>("vatRate"));
        quantinityCol.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantinity"));
        unitCol.setCellValueFactory(new PropertyValueFactory<Product, String>("unit"));

        productsTable.setEditable(true);
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());

        nameCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Product, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Product, String> t) {
                ((Product) t.getTableView().getItems().get(t.getTablePosition().getRow())).setProductName(t.getNewValue());
            }
        });

    }

    /**
     * Button handler which deletes product from list.
     *
     * @param event An event representing some type of action
     * @throws IOException Signals that an I/O exception of some sort has
     * occurred.
     */
    @FXML
    private void remove(ActionEvent event) {
        int index = productsTable.getSelectionModel().getSelectedIndex();
        if (index != -1) {
            data.remove(index);
            counter--;
            textAddedProducts.setText("Currently added products: " + counter);
        }
    }

    /**
     * DatePicker handler which reacts to date being chosen by user.
     *
     * @return chosen day by user
     */
    @FXML
    Date pickDate() {
        if (datePicker.getValue() != null) {
            Date date = new Date(datePicker.getValue().getYear(), datePicker.getValue().getMonthValue(), datePicker.getValue().getDayOfMonth());
            return date;
        } else {
            Date date = new Date(0, 0, 0);
            return date;
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

    /**
     * Method adds new product to the list.
     *
     * @param event An event representing some type of action
     * @throws IOException Signals that an I/O exception of some sort has
     * occurred.
     */
    @FXML
    void addProduct(ActionEvent event) throws IOException {
        errorMsgProduct.setText("");
        String productName = fieldProductName.getText();
        String unit = fieldUnit.getText();
        if (productName.isEmpty() || unit.isEmpty()) {
            errorMsgProduct.setText("Empty required fields!");
            return;
        }
        try {
            Double priceNetto = Double.parseDouble(fieldPriceNetto.getText());
            VatRate vatRate = inputVatRate.getValue();
            int quantinity = Integer.parseInt(fieldQuantinity.getText());
            Product product = new Product(productName, priceNetto, vatRate, quantinity, unit);
            data.add(product);
            counter++;
            textAddedProducts.setText("Currently added products: " + counter);
        } catch (Exception ex) {
            errorMsgProduct.setText("Error");
        }
    }

    /**
     * Method adds new order to the list.
     *
     * @param event An event representing some type of action
     * @throws IOException Signals that an I/O exception of some sort has
     * occurred.
     */
    @FXML
    void addToList(ActionEvent event) throws IOException {
        String orderNumber = fieldOrderNumber.getText();
        String paymentMethod = fieldPaymentMethod.getText();
        Date date = pickDate();
        if (orderNumber.isEmpty() || paymentMethod.isEmpty() || date.getDay() == 0 || date.getMonth() == 0 || date.getYear() == 0 || fieldBuyerName.getText().isEmpty()
                || fieldBuyerSurname.getText().isEmpty() || fieldBuyerAddress.getText().isEmpty()) {
            errorMsgOrder.setText("Empty required fields!");
            return;
        }
        try {
            Buyer buyer = new Buyer(fieldBuyerName.getText(), fieldBuyerSurname.getText(), fieldBuyerAddress.getText());
            if (!products.isEmpty()) {
                Order newOrder = new Order(orderNumber, date, buyer, products, paymentMethod);
                model.addOrder(newOrder);
            } else {
                errorMsgOrder.setText("There must be at least one product!");
                return;
            }
        } catch (Exception ex) {
            errorMsgOrder.setText("Unknown error");
            return;
        }
        App.setRoot("MainMenu");
    }

}
