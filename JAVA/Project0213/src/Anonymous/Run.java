package Anonymous;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Run {

	public static void main(String[] args) {
		 Button b = new Button();
		 b.addActionListener(new Listener());
	}

}

class Listener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Performed Action");
	}
	
}
