package view;

import javax.swing.JScrollPane;

public class MyScrollPanel extends JScrollPane {
	
	public MyScrollPanel() {
        super();
        customizeMyScrollPanel();
    }

    private void customizeMyScrollPanel() {
        setBackground(Colors.Trang);
    }
    
}
