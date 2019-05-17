package prueba;

import java.awt.*;
import java.applet.*;

public class MazoSecundario {
	java.util.List<Carta> mazoB;
	
	public MazoSecundario() {
		mazoB = new java.util.ArrayList();
	}
	
	public void anadir(Carta c) {
		mazoB.add(c);
		recolocar();
	}
	
	public Carta sacar() {
		if(mazoB.size() != 0)
			return mazoB.get(mazoB.size()-1);
		else return null;
	}
	
	public void eliminar() {
		mazoB.remove(mazoB.size()-1);
	}
	
	public void mostrar(Graphics g, Applet a) {
		for(int i=0; i < mazoB.size(); i++) {
			mazoB.get(i).dibujar(g, a);
		}
	}
	
	public void recolocar() {
		mazoB.get(mazoB.size()-1).setX(150);
		mazoB.get(mazoB.size()-1).setY(20);
	}
}
