module com.example.livrederecettefx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.livrederecettefx to javafx.fxml;
    exports com.example.livrederecettefx;
}