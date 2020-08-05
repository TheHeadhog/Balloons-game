package baloni;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Scena extends Canvas implements Runnable, KeyListener{
	private Igra igra;
	CopyOnWriteArrayList<KruznaFigura> kruzneFigure;
	private Thread nit= new Thread(this);
	private Igrac igrac;
	
	public Scena(Igra igra) {
		super();
		this.igra = igra;
		kruzneFigure=new CopyOnWriteArrayList<>();
		addKeyListener(this);
	}

	public void pokreniScenu() {
		nit.start();
	}
	
	public void zaustaviScenu() {
		nit.interrupt();
	}


	@Override
	public void run() {
		try {
			Random rand= new Random();
			igrac = new Igrac(new Vektor(igra.getWidth()/2,igra.getHeight()-80), 30, new Vektor(-6,0), this);
			kruzneFigure.add(igrac);
			while(!nit.isInterrupted()) {
				Thread.sleep(60);
				if(rand.nextDouble()<0.1) {
					Vektor centar= new Vektor(rand.nextInt(getWidth()),1);
					Vektor brzinaKretanja=new Vektor(0,rand.nextInt(6)+1);
					Balon b=new Balon(centar, Color.RED, 20, brzinaKretanja, this);
					kruzneFigure.add(b);
				}
				synchronized (kruzneFigure) {
					for (KruznaFigura kruznaFigura : kruzneFigure) {
						kruznaFigura.obavestiVremenu(60);
					}
					for (int i=1;i<kruzneFigure.size();i++) {
						if (Krug.preklapajuSe(igrac, kruzneFigure.get(i))) {
							KruznaFigura.obavestiSudaru(igrac, kruzneFigure.get(i));
							zaustaviScenu();
						}
					}
				}
				repaint();
			}
		}
		catch (InterruptedException e) {
				
		}
		
	}
	
	@Override
	public void paint(Graphics g) {
		for (KruznaFigura kruznaFigura : kruzneFigure) {
			kruznaFigura.iscrtaj(this);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int pritisnuto = e.getKeyCode();
	    switch( pritisnuto ) { 
	        case KeyEvent.VK_LEFT:
	            if(igrac.brzinaKretanja.getX()>0) igrac.brzinaKretanja=igrac.brzinaKretanja.pomnoziSa(-1);
	            igrac.pomeri();
	            break;
	        case KeyEvent.VK_RIGHT :
	        	if(igrac.brzinaKretanja.getX()<0) igrac.brzinaKretanja=igrac.brzinaKretanja.pomnoziSa(-1);
	        	igrac.pomeri();
	            break;
	     }
	    repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
