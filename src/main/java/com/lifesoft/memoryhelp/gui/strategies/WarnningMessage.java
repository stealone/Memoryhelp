package com.lifesoft.memoryhelp.gui.strategies;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class WarnningMessage extends AbstractMessageStrategy{
    public WarnningMessage(){
        super();
    }

    @Override
    public Optional<ButtonType> showMessage(String message) {
        dialogBox = new Alert(Alert.AlertType.WARNING);
        dialogBox.setTitle(resources.getString("applicationNameTextKey")+ resources.getString("WarnningDialogBoxTitleTextKey"));
        dialogBox.setHeaderText(null);
        dialogBox.setContentText(message);
        return dialogBox.showAndWait();
    }
}
