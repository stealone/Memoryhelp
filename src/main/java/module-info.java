module com.lifesoft.memoryhelp {
    requires java.base;
    requires java.sql;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.media;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires annotations;

    opens com.lifesoft.memoryhelp.application to javafx.fxml;
    exports com.lifesoft.memoryhelp.controls;
    opens com.lifesoft.memoryhelp.controls to javafx.fxml;
    exports com.lifesoft.memoryhelp.application;
}