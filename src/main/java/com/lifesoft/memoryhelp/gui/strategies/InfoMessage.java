package com.lifesoft.memoryhelp.gui.strategies;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class InfoMessage extends AbstractMessageStrategy{
    public InfoMessage() {
        super();
    }

    @Override
    public Optional<ButtonType> showMessage(String message) {
        dialogBox = new Alert(Alert.AlertType.INFORMATION);
        dialogBox.setTitle(resources.getString("applicationNameTextKey")+ resources.getString("InformationDialogBoxTitleTextKey"));
        dialogBox.setHeaderText(null);
        dialogBox.setContentText(message);
        return dialogBox.showAndWait();
    }
}
