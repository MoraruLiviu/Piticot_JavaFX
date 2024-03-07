module com.project.piticotfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.project.piticotfx to javafx.fxml;
    exports com.project.piticotfx;
}