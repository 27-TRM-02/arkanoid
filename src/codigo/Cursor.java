package codigo;

import java.awt.Color;

import acm.graphics.GRect;

public class Cursor extends GRect {

    /**
     * Constructor del Cursor
     * 
     * @param posX
     * @param posY
     * @param width
     * @param height
     * @param miColor
     */
    public Cursor(double posX, double posY, double width, double height, Color miColor) {
	super(posX, posY, width, height);
	setFilled(true);
	setFillColor(miColor);
    }

}
