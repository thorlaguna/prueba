package prueba;

import java.awt.*;
import java.applet.*;

public class Solitario extends Applet {
	public static final int NUM_CARTAS = 52;
	public static final int NUM_PALOS = 4;
	public static final int CPP = 13;
	public static final int MAZOSJUEGO = 7;
	Image imagen;
	Graphics noseve;
	String nombres[] = {"_of_clubs.png", "_of_diamonds.png", "_of_hearts.png", "_of_spades.png"};
	Image imagenes[];
	Image imgReverso;
	Rectangle reverso;
	Baraja baraja;
	MazoSecundario mSecundario;
	Carta activa = null;
	MazoPalo mPalos[];
	MazoJuego[] mazosJuego = new MazoJuego[7];
	
	public void init() {
		setSize(1000,800);
		imagen = createImage(1000, 800);
		noseve = imagen.getGraphics();
		imagenes = new Image[NUM_CARTAS];
		for(int i=0; i<4; i++) {
			for(int j=0; j<CPP; j++) {
				imagenes[(i*CPP)+j] = getImage(getCodeBase(), "Cartas/" + (j + 1) + nombres[i]);
			}
		}
		imgReverso = getImage(getCodeBase(), "Cartas/reverso.png");
		reverso = new Rectangle(20, 20, Carta.ANCHURA, Carta.ALTURA);
		
		baraja = new Baraja(imagenes);
		baraja.barajar();
		
		mSecundario = new MazoSecundario();
		
		for(int i = 0; i < MAZOSJUEGO; i++) {
			mazosJuego[i] = new MazoJuego((i*135)+20);
			
		}
		
		mPalos = new MazoPalo[NUM_PALOS];
		for(int i=0; i<NUM_PALOS; i++) {
			mPalos[i] = new MazoPalo(400 + (i*120));
		}
	}
	
	public void paint(Graphics g) {
		noseve.setColor(Color.decode("#005E00"));
		noseve.fillRect(0, 0, 1000, 800);
		for(int i=0; i<NUM_PALOS; i++) {
			mPalos[i].mostrar(noseve, this);
		}
		for(int i=0; i<MAZOSJUEGO; i++) {
			mazosJuego[i].mostrar(noseve, this);
		}
		noseve.drawImage(imgReverso, 20, 20, Carta.ANCHURA, Carta.ALTURA, this);
		mSecundario.mostrar(noseve, this);
		g.drawImage(imagen, 0, 0, this);
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	
	public boolean mouseDown(Event ev, int x, int y) {
		if(reverso.contains(x, y)) {
			if(baraja.listaVacia()) {
				/*for(int i = 0; i < mSecundario.mazoB.size(); i++) {
					baraja.mazoPrincipal.add(mSecundario.mazoB.get(i));
					mSecundario.mazoB.remove(i);
				}*/
				baraja.mazoPrincipal = mSecundario.mazoB;
				mSecundario = new MazoSecundario();
			}	
			else
				mSecundario.anadir(baraja.sacar());
			repaint();
		}
			if(mSecundario.sacar().contains(x,y)) {
			activa = mSecundario.sacar();
		}		
		return true;
	}
	
	public boolean mouseDrag(Event ev, int x, int y) {
		if(activa != null) {
			activa.setX(x - (Carta.ANCHURA/2));
			activa.setY(y - (Carta.ALTURA/2));
			repaint();
		}
		return true;
	}
	
	public boolean mouseUp(Event ev, int x, int y) {
		boolean encontrado = false;
		if(activa != null) {
			for(int i = 0; i < NUM_PALOS; i++) {
				if(mPalos[i].intersects(activa)) {
					if(mPalos[i].anadir(activa)) {
						mSecundario.eliminar();
						encontrado = true;
						break;
					}else {
						mSecundario.recolocar();
					}
				}
			}
			for(int i = 0; i > MAZOSJUEGO; i++) {
				if(mazosJuego[i].intersects(activa)) {
					if(mazosJuego[i].anadir(mSecundario.sacar())) {
						mSecundario.eliminar();
						encontrado = true;
						break;
					}
				}
			}
			if(!encontrado) mSecundario.recolocar(); 
			activa = null;
			repaint();
		}
		return true;
	}
	
}
