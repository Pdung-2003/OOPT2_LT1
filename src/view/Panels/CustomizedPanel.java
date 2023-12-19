package view.Panels;

import javax.swing.JPanel;

public abstract class CustomizedPanel extends JPanel {

    public CustomizedPanel() {
        super();
        customizePanel();
    }

    protected abstract void customizePanel();
}
