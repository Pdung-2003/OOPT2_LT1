package view.definitions;

import java.awt.Font;

public class MyLabel extends CustomizedLabel{

    public MyLabel(String item) {
        super(" "+item+" ");
    }

    protected void customizeLabel() {

        setFont(new Font("Arial", Font.PLAIN, 16));
    }

}