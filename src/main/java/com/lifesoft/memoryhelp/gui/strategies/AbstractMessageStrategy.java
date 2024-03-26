package com.lifesoft.memoryhelp.gui.strategies;

import com.lifesoft.memoryhelp.application.MemoryHelp;
import javafx.scene.control.Alert;

import java.util.Optional;
import java.util.ResourceBundle;

public abstract class AbstractMessageStrategy implements MessageBoxStrategy{
    protected Alert dialogBox;
    protected ResourceBundle resources;

    public AbstractMessageStrategy(){
        super();
        resources = ResourceBundle.getBundle("com.lifesoft.memoryhelp.i18n.MHDialog", MemoryHelp.getLocale());
    }
}
