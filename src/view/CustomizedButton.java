package view;

import javax.swing.*;

public abstract class CustomizedButton extends JButton {

    public CustomizedButton(String text){
        super(text);
        customizedButton();
    }

    protected abstract void customizedButton();
}
