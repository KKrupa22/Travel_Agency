module kamil.krupa.cw2_final {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires lombok;

    opens Controller to javafx.fxml;
    
    exports kamil.krupa.cw2_final;
    exports Model;
    exports Controller;
}
