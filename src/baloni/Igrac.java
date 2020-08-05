package baloni;

import java.awt.Color;
import java.awt.Graphics;

public class Igrac extends KruznaFigura {

	public Igrac(Vektor centar, double precnik, Vektor brzinaKretanja, Scena scena) {
		super(centar, Color.GREEN, precnik, new Vektor(brzinaKretanja.getX(),0), scena);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void iscrtaj(Scena s) {
		super.iscrtaj(s);
		Graphics g = s.getGraphics();
		g.setColor(Color.BLUE);
		g.fillOval((int)(centar.getX()-precnik/4),(int)( centar.getY()- precnik/4),(int) precnik/2, (int)precnik/2);
	}
	
	@Override
	public void obavestiVremenu(long ms) {}

	public void pomeri() {
		Vektor pom=centar.clone();
		pom.saberiSa(brzinaKretanja);
		try {
			if (pom.getX()<0) throw new WallHitException();
			else if(pom.getX()>scena.getWidth()) throw new WallHitException();
			else centar.saberiSa(brzinaKretanja);
		}
		catch (WallHitException e) {}
	}
}

@SuppressWarnings("serial")
class WallHitException extends Exception{
	
}