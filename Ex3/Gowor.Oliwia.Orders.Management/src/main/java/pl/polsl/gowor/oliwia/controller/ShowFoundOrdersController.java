/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.gowor.oliwia.controller;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import static pl.polsl.gowor.oliwia.controller.SearchMenuController.foundOrders;
import pl.polsl.gowor.oliwia.model.Order;
import pl.polsl.gowor.oliwia.model.Product;
import pl.polsl.gowor.oliwia.orders.management.App;

/**
 * FXML Controller class responsible for controlling the ShowFoundOrders view of
 * application which displays all orders found by criteria given by user.
 *
 * @author Oliwia Gowor
 * @version 3.0
 */
public class ShowFoundOrdersController {

    /**
     * Value represents object of the Button class
     */
    @FXML
    private Button buttonReturn;
    /**
     * Value represents object of the TreeTableView class
     */
    @FXML
    private TreeTableView<Order> ordersTable;
    /**
     * Value represents object of the TreeTableView class
     */
    @FXML
    private TreeTableColumn<Order, String> orderNumberCol;
    /**
     * Value represents object of the TreeTableView class
     */
    @FXML
    private TreeTableColumn<Order, String> buyerDataCol;
    /**
     * Value represents object of the TreeTableView class
     */
    @FXML
    private TreeTableColumn<Order, String> orderDateCol;
    /**
     * Value represents object of the TreeTableView class
     */
    @FXML
    private TreeTableColumn<Product, String> productNameCol;
    /**
     * Value represents object of the TreeTableView class
     */
    @FXML
    private TreeTableColumn<Product, Integer> quantinityCol;
    /**
     * Value represents object of the TreeTableView class
     */
    @FXML
    private TreeTableColumn<Product, String> unitCol;
    /**
     * Value represents object of the TreeTableView class
     */
    @FXML
    private TreeTableColumn<Product, Double> priceNettoCol;
    /**
     * Value represents object of the TreeTableView class
     */
    @FXML
    private TreeTableColumn<Product, Double> valueNettoCol;
    /**
     * Value represents object of the TreeTableView class
     */
    @FXML
    private TreeTableColumn<Product, Product.VatRate> vatRateCol;
    /**
     * Value represents object of the TreeTableView class
     */
    @FXML
    private TreeTableColumn<Product, Double> valueVatCol;
    /**
     * Value represents object of the TreeTableView class
     */
    @FXML
    private TreeTableColumn<Product, Double> valueBruttoCol;
    /**
     * Value represents object of the TreeTableView class
     */
    @FXML
    private TreeTableColumn<Order, String> paymentMethodCol;
    /**
     * Value represents object of the TreeTableView class
     */
    @FXML
    private TreeTableColumn<Order, Double> sumNettoCol;
    /**
     * Value represents object of the TreeTableView class
     */
    @FXML
    private TreeTableColumn<Order, Double> sumVatCol;
    /**
     * Value represents object of the TreeTableView class
     */
    @FXML
    private TreeTableColumn<Order, Double> sumBruttoCol;
    /**
     * Value represents root object of the TreeTableView class
     */
    TreeItem<Order> rootItem = new TreeItem<Order>();
    /**
     * Value represents ObservableList of orders
     */
    private ObservableList<Order> listOfOrders;
    
    /**
     * Non-parameter AddOrderController class constructor
     */
    public ShowFoundOrdersController() {
        listOfOrders = FXCollections.observableArrayList(foundOrders);
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
    @FXML
    public void initialize() {
        makeTreeItems();
        orderNumberCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("number"));
        buyerDataCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("buyer"));
        orderDateCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("orderDate"));
        productNameCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("productName"));
        quantinityCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("quantinity"));
        unitCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("unit"));
        priceNettoCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("priceNetto"));
        valueNettoCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("valueNetto"));
        vatRateCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("vatRate"));
        valueVatCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("valueVat"));
        valueBruttoCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("valueBrutto"));
        paymentMethodCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("paymentMethod"));
        sumNettoCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("sumNetto"));
        sumVatCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("sumVat"));
        sumBruttoCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("sumBrutto"));
        ordersTable.setPlaceholder(new Label("No rows to display"));

    }

    /**
     * Metod creates tree items and sets appropriate roots.
     */
    private void makeTreeItems() {
        for (Order order : listOfOrders) {
            TreeItem<Order> tmp = new TreeItem<Order>(order);
            rootItem.getChildren().add(tmp);
            for (Product product : tmp.getValue().getProducts()) {
                TreeItem tmpProd = new TreeItem<Product>(product);
                tmp.getChildren().add(tmpProd);
            }
        }
        ordersTable.setRoot(rootItem);
        rootItem.setExpanded(true);
        ordersTable.setShowRoot(false);

    }

    /**
     * Button handler which opens ShowAllOrders view.
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
