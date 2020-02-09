package modelo;
/**
 * 
 *	@author <b>Kevin Zarama-kz</b>
 *	@version 1.0z - 28/10/2017
 *
 */
public class Pez {
	/**
	 *	atributos de la clase Pez
	 */
	int posX, posY, tipoPez;
	/**
	 *	constructor de la clase Pez
	 */
	public Pez() {
		this.posX = -1 * (int) (Math.random() * 700);
		this.posY = (int) (Math.random() * 340);
		this.tipoPez = (int) (Math.random() * 10);
	}
	/**
	 *	getPosX
	 *	@return posX
	 */
	public int getPosX() {
		return posX;
	}
	/**
	 *	setPosX
	 *	@param posX
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}
	/**
	 *	getPosY
	 *	@return posY
	 */
	public int getPosY() {
		return posY;
	}
	/**
	 *	setPosY
	 *	@param posY
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}
	/**
	 *	getTipoPez
	 *	@return tipoPez
	 */
	public int getTipoPez() {
		return tipoPez;
	}
	/**
	 *	setTipoPez
	 *	@param tipoPez
	 */
	public void setTipoPez(int tipoPez) {
		this.tipoPez = tipoPez;
	}
	/**
	 *	mover
	 *	@param dis
	 */
	public void mover(int dis){
		this.posX += dis;
	}
	
}