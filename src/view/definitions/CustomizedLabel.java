package view.definitions;

import javax.swing.*;

public abstract class CustomizedLabel extends JLabel {
    public CustomizedLabel(String item) {
        super("   "+item+" ");
        customizeLabel();
    }

   protected abstract void customizeLabel();
}
