module org.example.projectavaliacao {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.projectavaliacao to javafx.fxml;
    exports org.example.projectavaliacao;
}