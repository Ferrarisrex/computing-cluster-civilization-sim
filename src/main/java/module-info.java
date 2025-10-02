module com.ferra {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.ferra to javafx.fxml;
    exports com.ferra;
}
