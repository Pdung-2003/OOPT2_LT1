package view.ScrollPane;

import javax.swing.*;

public abstract class CustomizedScrollPane extends JScrollPane {
    public CustomizedScrollPane() {
        super();
        customizeScrollPanel();
    }

    protected abstract void customizeScrollPanel();
}
