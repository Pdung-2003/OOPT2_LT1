package view.ScrollPane;

import view.Colors;

import javax.swing.JScrollPane;

public class MyScrollPane extends CustomizedScrollPane {

    public MyScrollPane() {
        super();
    }

    protected void customizeScrollPanel() {
        setBackground(Colors.Trang);
    }

}