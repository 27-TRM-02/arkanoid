package codigo;

import java.awt.Color;

import acm.graphics.GRect;

/* AUTOR: TOMÁS RODRÍGUEZ-MATA SUÁREZ
 * 
 */

public class Ladrillo extends GRect {

    public int hits = 0;

    public Ladrillo(double posX, double posY, double width, double height, Color miColor) {
	super(posX, posY, width, height);
	setFilled(true);
	setFillColor(miColor);
    }
}
