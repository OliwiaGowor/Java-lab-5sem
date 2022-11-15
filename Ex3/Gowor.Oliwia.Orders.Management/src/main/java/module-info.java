module pl.polsl.gowor.oliwia.orders.management {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    
    opens pl.polsl.gowor.oliwia.orders.management to javafx.fxml;
    exports pl.polsl.gowor.oliwia.orders.management;
    
    opens pl.polsl.gowor.oliwia.model to javafx.base;
    exports pl.polsl.gowor.oliwia.model;
    
    opens pl.polsl.gowor.oliwia.controller to javafx.fxml;
    exports pl.polsl.gowor.oliwia.controller;
    
    opens pl.polsl.gowor.oliwia.console to javafx.fxml;
    exports pl.polsl.gowor.oliwia.console;
}
