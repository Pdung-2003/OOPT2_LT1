package view.definitions;

import javax.swing.*;

public abstract class CustomizedComboBox extends JComboBox<String> {
    public CustomizedComboBox(String[] items) {
    super(items);
    customizeComboBox();
}

    protected abstract void customizeComboBox();
}