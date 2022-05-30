module fr.unilim.iut.latice_ {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;

    opens fr.unilim.iut.latice_.Application to javafx.fxml;
    opens fr.unilim.iut.latice_.controller to javafx.fxml;

    exports fr.unilim.iut.latice_.Application;
    exports fr.unilim.iut.latice_.controller;
}
