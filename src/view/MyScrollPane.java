package view;

import javax.swing.JScrollPane;

public class MyScrollPane extends JScrollPane {
	
	public MyScrollPane() {
        super();
        customizeMyScrollPanel();
    }

    private void customizeMyScrollPanel() {
        setBackground(Colors.Trang);
    }
    
}
