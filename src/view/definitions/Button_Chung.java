package view.definitions;

import java.awt.Font;

import javax.swing.SwingConstants;

public class Button_Chung extends CustomizedButton {

    public Button_Chung(String text) {
        super(text);
    }

    protected void customizeButton() {
        setBackground(Colors.Vang);
        setForeground(Colors.Den);
        setFont(new Font("Arial", Font.BOLD, 16));
        setHorizontalAlignment(SwingConstants.CENTER);
    }

}
