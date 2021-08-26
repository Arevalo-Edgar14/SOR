module com.erev.cucei.ventana {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.erev.cucei.ventana to javafx.fxml;
    exports com.erev.cucei.ventana;
}