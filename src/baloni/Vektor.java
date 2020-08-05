package baloni;

public class Vektor implements Cloneable {
	private double x,y;

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public Vektor(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	protected Vektor clone() {
		try {
			Vektor v=(Vektor)super.clone();
			v.x=x;
			v.y=y;
			return v;
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	public Vektor pomnoziSa(double d) { return new Vektor(x*d, y*d);}
	
	public void saberiSa(Vektor v) { x+=v.x; y+=v.y;}
}
