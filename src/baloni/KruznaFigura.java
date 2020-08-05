package baloni;

import java.awt.Color;
import java.awt.Graphics;

public abstract class KruznaFigura extends Krug {
	protected Vektor brzinaKretanja;
	protected Scena scena;
	protected KruznaFigura sudar=null;
	
	public void setSudar(KruznaFigura sudar) {
		this.sudar = sudar;
	}

	public KruznaFigura(Vektor centar, Color boja, double precnik, Vektor brzinaKretanja, Scena scena) {
		super(centar, boja, precnik);
		this.brzinaKretanja = brzinaKretanja;
		this.scena = scena;
	}

	public synchronized void obavestiVremenu(long ms) {
		centar.saberiSa(brzinaKretanja.pomnoziSa((double)ms/60.0));
		if(centar.getX()<=0||centar.getY()<=0||centar.getX()>=scena.getWidth()-1||centar.getY()>=scena.getHeight()-1)
			scena.kruzneFigure.remove(this);
	}
	public static void obavestiSudaru(KruznaFigura k1,KruznaFigura k2) {
		k1.setSudar(k2); k2.setSudar(k1);
	}
	
	@Override
	public void iscrtaj(Scena s) {
		Graphics g=scena.getGraphics();
		g.setColor(boja);
		g.fillOval((int)(centar.getX()-precnik/2),(int)( centar.getY()- precnik/2),(int) precnik, (int)precnik);
	}

}
