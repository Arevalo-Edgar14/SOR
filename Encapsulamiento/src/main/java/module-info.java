module com.erev.cucei.encapsulamiento {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.erev.cucei.encapsulamiento to javafx.fxml;
    exports com.erev.cucei.encapsulamiento;
}