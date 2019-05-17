package prueba;

import java.awt.*;
import java.applet.*;

public class MazoPalo extends Rectangle { //Podría no serlo, pero sería más difícil de dibujar
	java.util.List<Carta> mazo;
	int palo;
	
	public MazoPalo(int posx) {
		super(posx, 20, Carta.ANCHURA, Carta.ALTURA);
		mazo = new java.util.ArrayList();
	}
	
	public boolean anadir(Carta c) {
		if(mazo.size() == 0) {
			if(c.getValor() == 1) {
				mazo.add(c);
				recolocar();
				palo = c.getPalo();
				return true;
			}
		}else {
			if(palo  == c.getPalo()) {
				if(mazo.get(mazo.size()-1).getValor() == c.getValor()-1) {
					mazo.add(c);
					recolocar();
					return true;
				}
			}
		}
		return false;
	}
	
	public Carta sacar() {
		return mazo.get(mazo.size()-1);
	}
	
	public void eliminar() {
		mazo.remove(mazo.size()-1);
	}
	
	public void mostrar(Graphics g, Applet a) {
		g.setColor(Color.white);
		g.drawRect(x, y, width+2, height+2);
		for(int i=0; i < mazo.size(); i++) {
			mazo.get(i).dibujar(g, a);
		}
	}
	
	public void recolocar() {
		mazo.get(mazo.size()-1).setX(x);
		mazo.get(mazo.size()-1).setY(y);
	}
}
