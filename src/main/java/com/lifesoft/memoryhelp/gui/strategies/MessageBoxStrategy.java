package com.lifesoft.memoryhelp.gui.strategies;

import java.util.Optional;

public interface MessageBoxStrategy {
    public Optional<? extends Object> showMessage(String message);
}
