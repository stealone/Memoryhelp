package com.lifesoft.memoryhelp.gui.strategies;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class ErrorMessage extends AbstractMessageStrategy {


    public ErrorMessage(){
        super();
    }

    @Override
    public Optional<ButtonType> showMessage(String message) {
        dialogBox = new Alert(Alert.AlertType.ERROR);
        dialogBox.setTitle(resources.getString("applicationNameTextKey")+ resources.getString("ErrorDialogBoxTitleTextKey"));
        dialogBox.setHeaderText(null);
        dialogBox.setContentText(message);
        return dialogBox.showAndWait();
    }

}
