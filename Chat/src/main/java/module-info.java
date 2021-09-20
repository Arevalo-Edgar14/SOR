module com.erev.cucei.chat {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.erev.cucei.chat to javafx.fxml;
    exports com.erev.cucei.chat;
}