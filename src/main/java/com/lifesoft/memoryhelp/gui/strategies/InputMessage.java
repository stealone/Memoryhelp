package com.lifesoft.memoryhelp.gui.strategies;

import javafx.scene.control.ChoiceDialog;

import java.util.Optional;

public class InputMessage<T extends Object> extends AbstractMessageStrategy {
    private final T[] options;

    public InputMessage(T[] options){
        super();
        this.options = options;
    }

    @Override
    public Optional<T> showMessage(String message) {
        ChoiceDialog<T> optionDialog = new ChoiceDialog<>(null, options);
        optionDialog.setTitle(resources.getString("applicationNameTextKey")+ resources.getString("QueryDialogBoxTitleTextKey"));
        optionDialog.setHeaderText(null);
        optionDialog.setContentText(message);
        return optionDialog.showAndWait();
    }
}
