package baloni;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Igra extends Frame{

	public Scena scena;
	
	public Igra() throws HeadlessException {
		super("baloni");
		setSize(800,600);
		setResizable(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) { scena.zaustaviScenu();dispose();}
		});
		scena = new Scena(this);
		add(scena,BorderLayout.CENTER);
		scena.pokreniScenu();
		setVisible(true);
		scena.requestFocus();
	}

	public static void main(String[] args) {
		new Igra();
	}

}

//.(abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ
