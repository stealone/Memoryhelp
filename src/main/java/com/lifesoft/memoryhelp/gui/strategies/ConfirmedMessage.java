package com.lifesoft.memoryhelp.gui.strategies;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class ConfirmedMessage extends AbstractMessageStrategy {

    public ConfirmedMessage() {
        super();
    }

    @Override
    public Optional<ButtonType> showMessage(String message) {
        dialogBox = new Alert(Alert.AlertType.CONFIRMATION);
        dialogBox.setTitle(resources.getString("applicationNameTextKey") + resources.getString("ConfirmationDialogBoxTitleTextKey"));
        dialogBox.setHeaderText(null);
        dialogBox.setContentText(message);
        dialogBox.getButtonTypes().remove(ButtonType.OK);
        dialogBox.getButtonTypes().remove(ButtonType.CANCEL);
        dialogBox.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
        return dialogBox.showAndWait();
    }

}
