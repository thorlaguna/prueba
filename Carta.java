package prueba;

import java.awt.*;
import java.applet.*;

public class Carta extends Rectangle {
	public static final int ANCHURA = 110;
	public static final int ALTURA = 165;
	public static final int ROJO = 1;
	public static final int NEGRO = 2;
	public static final int PICAS = 0;
	public static final int ROMBOS = 1;
	public static final int CORAZONES = 2;
	public static final int TREBOLES = 3;
	
	private int color;
	private Image imagen;
	private int valor;
	private int palo;

	public Carta(Image img, int v, int c, int p) {
		super(-200, -200, ANCHURA, ALTURA);
		imagen = img;
		color = c;
		valor = v;
		palo = p;
		
	}
	
	public void dibujar(Graphics gg, Applet a) {
		gg.drawImage(imagen, x, y, width, height, a);
	}
	
	public Image getImagen() {
		return imagen;
	}

	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getPalo() {
		return palo;
	}

	public void setPalo(int palo) {
		this.palo = palo;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}