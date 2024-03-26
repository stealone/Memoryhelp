package com.lifesoft.memoryhelp.gui.components;

import com.lifesoft.memoryhelp.gui.strategies.AbstractMessageStrategy;

import java.util.Optional;

public class MHDialogBox {
    private AbstractMessageStrategy dialogBox;
    private static final MHDialogBox instance;

    static {
        instance = new MHDialogBox();
    }

    private MHDialogBox() {
        super();
    }

    public static MHDialogBox getInstance() {
        return instance;
    }

    public MHDialogBox setMessageType(AbstractMessageStrategy dialogBox) {
        this.dialogBox = dialogBox;
        return instance;
    }

    public Optional<? extends Object> showMessage(String message){
        if(dialogBox != null){
            return dialogBox.showMessage(message);
        }
        return Optional.empty();
    }
}
