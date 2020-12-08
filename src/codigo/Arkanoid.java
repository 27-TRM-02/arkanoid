package codigo;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class Arkanoid extends GraphicsProgram {
    // Constantes
    static final int ANCHO_PANTALLA = 600;
    static final int ALTO_PANTALLA = 600;
    static final int ANCHO_LADRILLO = 30;
    static final int ALTO_LADRILLO = 15;
    static final int ANCHO_CURSOR = 60;
    static final int ALTO_CURSOR = 10;
    // Inicialización bola inicial
    Bola inicial = new Bola(15, 15, Color.GREEN);
    // Inicialización del cursor
    Cursor miCursor = new Cursor(0, 450, ANCHO_CURSOR, ALTO_CURSOR, Color.WHITE);
    // Declaramos fondo inicial
    GImage fondoInicial;
    GImage intro;
    // Declaración de ladrillos del primer nivel
    Niveles nivel1 = new Niveles(ANCHO_LADRILLO, ALTO_LADRILLO);

    public void init() {
	addMouseListeners();
	// Pantalla de intro
	setSize(700, 750);
	intro = new GImage("imagenes/intro.jpg");
	add(intro);
	waitForClick();
	remove(intro);
	// Damos tamaño a la pantalla a jugar
	setSize(ANCHO_PANTALLA, ALTO_PANTALLA);
	// Añadimos fondo inicial
	fondoInicial = new GImage("imagenes/lava.jpg");
	add(fondoInicial);
	// Añade bola inicial al mapa
	add(inicial, 50, 100);
	// Añadimos el cursor
	add(miCursor);
	nivel1.creaPiramide(this);
    }

    public void run() {
	while (true) {
	    inicial.move(this);
	    pause(5);
	}
    }

    // Método para que cursor se mueva con el ratón
    public void mouseMoved(MouseEvent evento) {
	miCursor.setLocation(evento.getX(), miCursor.getY());
    }

}
