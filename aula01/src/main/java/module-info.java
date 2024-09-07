module br.com.etec.aula01 {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.com.etec.aula01 to javafx.fxml;
    exports br.com.etec.aula01;
}