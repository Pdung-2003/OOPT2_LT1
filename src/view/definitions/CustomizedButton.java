package view.definitions;

import javax.swing.*;

public abstract class CustomizedButton extends JButton {

    public CustomizedButton(String text){
        super(text);
        customizeButton();
    }

    protected abstract void customizeButton();
}
