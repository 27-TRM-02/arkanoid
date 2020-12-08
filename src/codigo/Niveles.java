package codigo;

import java.awt.Color;

/* AUTOR: TOMÁS RODRÍGUEZ-MATA SUÁREZ
 * 
 */
import acm.program.GraphicsProgram;

public class Niveles extends GraphicsProgram {

    private int ANCHO_LADRILLO;
    private int ALTO_LADRILLO;

    public Niveles(int _ANCHO_LADRILLO, int _ALTO_LADRILLO) {
	ANCHO_LADRILLO = _ANCHO_LADRILLO;
	ALTO_LADRILLO = _ALTO_LADRILLO;
    }

    public void creaPiramide(Arkanoid ark) {
	int numeroLadrillos = 14;
	for (int j = 0; j < numeroLadrillos; j++) {
	    for (int i = j; i < numeroLadrillos; i++) {
		Ladrillo miLadrillo = new Ladrillo(ANCHO_LADRILLO * i - ANCHO_LADRILLO / 2 * j,
			ALTO_LADRILLO * j + ALTO_LADRILLO, ANCHO_LADRILLO, ALTO_LADRILLO, Color.darkGray);
		ark.add(miLadrillo);
	    }
	}
    }

}
