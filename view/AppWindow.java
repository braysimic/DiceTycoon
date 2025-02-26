package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
// import javax.swing.border.Border;

public class AppWindow extends JFrame{
	
	public void init() {

		// setTitle("Betting Dice Roll Game");

		var cp = getContentPane();

		var canvas = new AppCanvas();
		cp.add(canvas, BorderLayout.CENTER);
	}
}
