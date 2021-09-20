module com.erev.cucei.tokyo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.erev.cucei.tokyo2020 to javafx.fxml;
    exports com.erev.cucei.tokyo2020;
}