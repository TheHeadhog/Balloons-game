package baloni;

import java.awt.Color;

public abstract class Krug {
	protected Vektor centar;
	protected Color boja;
	protected double precnik;
	
	public Krug(Vektor centar, Color boja, double precnik) {
		super();
		this.centar = centar;
		this.boja = boja;
		this.precnik = precnik;
	}
	
	public static boolean preklapajuSe(Krug k1,Krug k2) {
		double x=Math.abs(k1.centar.getX()-k2.centar.getX());
		double y=Math.abs(k1.centar.getY()-k2.centar.getY());
		double z=Math.sqrt(x*x+y*y);
		return z<(k1.precnik+k2.precnik)/2;
	}
	
	public abstract void iscrtaj(Scena s);
	
}
