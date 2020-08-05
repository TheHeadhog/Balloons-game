package baloni;

import java.awt.Color;

public class Balon extends KruznaFigura {

	public Balon(Vektor centar, Color boja, double precnik,Vektor brzinaKretanja, Scena scena) {
		super(centar, boja, precnik, brzinaKretanja, scena);
	}

	@Override
	public void iscrtaj(Scena s) {
		super.iscrtaj(s);
	}

}
