package codigo;

import java.awt.Color;

import acm.graphics.GObject;
import acm.graphics.GOval;

public class Bola extends GOval {
	int desplazamientoX = 1; // velocidad en el eje X
	int desplazamientoY = 1; // velocidad en el eje Y

	/**
	 * Constructor de Bola
	 * 
	 * @param width
	 * @param height
	 * @param miColor
	 */
	public Bola(double width, double height, Color miColor) {
		super(width, height);
		setFilled(true);
		setFillColor(miColor);
	}

	// Movilidad de Bola
	public void move(Arkanoid ark) {
		// rebota en el techo y en el suelo
		if (getY() > ark.getHeight() || getY() < 0) {
			this.invertMovement("y"); // Invierto el valor de desplazamiento
		}
		// Rebota en la pared dcha. o en la pared izda.
		if (getX() > ark.getWidth() - 15 || getX() < 0) {
			this.invertMovement("x");
		}
		// Si choca en el suelo desaparece bola
		if (this.getY() > ark.getHeight()) {
			ark.remove(this);
			this.stopMovement();
		}
		// rebotes de la bola con el cursor
		GObject auxiliar;
		auxiliar = ark.getElementAt(getX(), getY() + getHeight());
		// rebotes del cursor con bola
		if (auxiliar == ark.miCursor) {
			this.invertMovement("y");
		}

		// chequeo del rebote de la bola con los ladrillos
		if (chequeaColision(this.getX(), this.getY(), ark)) {
			if (chequeaColision(this.getX() + this.getWidth(), this.getY(), ark)) {
				if (chequeaColision(this.getX() + this.getWidth(), this.getY() + this.getHeight(), ark)) {
					if (chequeaColision(this.getX(), this.getY() + this.getHeight(), ark)) {

					}
				}
			}
		}

		// reposiciona la bola con los nuevos valores de despl.X y despl.Y
		move(desplazamientoX, desplazamientoY);
	}

	private boolean chequeaColision(double posX, double posY, Arkanoid ark) {

		boolean noHaChocado = true;

		GObject auxiliar;
		auxiliar = ark.getElementAt(posX, posY);
		// check si rebota con ladrillo
		if (auxiliar instanceof Ladrillo) {
			if (auxiliar.getY() == posY || auxiliar.getY() + auxiliar.getHeight() == posY) {
				this.invertMovement("y");
			} else if (auxiliar.getX() == posX || auxiliar.getX() + auxiliar.getWidth() == posX) {
				this.invertMovement("x");
			}
			ark.remove(auxiliar);
			noHaChocado = false;
		}
		// Chequeo rebote cursor
		else if (auxiliar instanceof Cursor) {
			desplazamientoY *= -1;
		}
		return noHaChocado;
	}

	private void stopMovement() {
		this.desplazamientoX = 0;
		this.desplazamientoY = 0;
	}

	private void invertMovement(String axis) {
		if (axis.equalsIgnoreCase("x")) {
			this.desplazamientoX *= -1;
		} else if (axis.equalsIgnoreCase("y")) {
			this.desplazamientoY *= -1;
		}
	}

}
