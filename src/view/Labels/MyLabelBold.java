package view.Labels;

import java.awt.Font;

import javax.swing.JLabel;

public class MyLabelBold extends CustomizedLabel{

    public MyLabelBold(String item) {
        super(item);
    }

    protected void customizeLabel() {

        setFont(new Font("Arial", Font.BOLD, 16));
    }
}