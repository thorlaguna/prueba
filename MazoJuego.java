package prueba;

import java.awt.*;
import java.applet.*;

public class MazoJuego extends Rectangle {
	java.util.List<Carta> mazo;
	
	public MazoJuego(int posx) {
		super(posx, 250, Carta.ANCHURA, Carta.ALTURA);
		mazo = new java.util.ArrayList();
	}
	
	public boolean anadir(Carta c) {
		if(mazo.size() == 0) {
			if(c.getValor() == 13) {
				recolocar(c);
				mazo.add(c);
				return true;
			}
		}
		
		return false;
	}
	
	public Carta sacar() {
		if(mazo.size() != 0) {
			return mazo.get(mazo.size()-1);
		}
		return null;
	}
	
	public void eliminar() {
		mazo.remove(mazo.size()-1);
	}
	
	public void mostrar(Graphics g, Applet a) {
		g.setColor(Color.white);
		g.drawRect(x-2, y-2, width+4, height+4);
		for(int i=0; i < mazo.size(); i++) {
			mazo.get(i).dibujar(g, a);
		}
	}
	
	public void recolocar(Carta c) {
		if(mazo.size() == 0) {
			c.setY(y);
		}
		else {
			c.setY(mazo.size() * 30);
		}
		c.setX(x);
	}
}
