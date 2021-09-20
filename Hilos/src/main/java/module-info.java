module com.erev.cucei.hilos {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.erev.cucei.hilos to javafx.fxml;
    exports com.erev.cucei.hilos;
}