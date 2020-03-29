module io.github.amorehead {
    requires javafx.controls;
    requires javafx.fxml;
    requires poi.ooxml;
    requires java.desktop;

    opens io.github.amorehead to javafx.fxml;
    exports io.github.amorehead;
}