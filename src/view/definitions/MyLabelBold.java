package view.definitions;

import java.awt.Font;

public class MyLabelBold extends CustomizedLabel{

    public MyLabelBold(String item) {
        super(item);
    }

    protected void customizeLabel() {

        setFont(new Font("Arial", Font.BOLD, 16));
    }
}