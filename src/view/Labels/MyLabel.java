package view.Labels;

import java.awt.Font;

import javax.swing.JLabel;

public class MyLabel extends CustomizedLabel{

    public MyLabel(String item) {
        super(" "+item+" ");
    }

    protected void customizeLabel() {

        setFont(new Font("Arial", Font.PLAIN, 16));
    }

}