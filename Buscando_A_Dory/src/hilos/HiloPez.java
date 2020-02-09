package hilos;

import interfaz.InterfazBuscandoDory;

public class HiloPez extends Thread{

	private InterfazBuscandoDory interfaz;
	
	public HiloPez(InterfazBuscandoDory interfaz){
		this.interfaz = interfaz;
	}
	
	public void run() {
		while(true){
			for(int i = 0; i < interfaz.getPeces().size(); i++){
				interfaz.getPeces().get(i).mover(interfaz.darJugador().getNivel() * 2);
				try{
					Thread.sleep(1);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				interfaz.repaint();
				if(interfaz.getPeces().get(i).getPosX() > 700) {
					interfaz.getPeces().get(i).setPosX(-1 * (60 + (int) (Math.random() * 50)));
					interfaz.getPeces().get(i).setPosY((int) (Math.random() * 250) - 20);
					interfaz.getPeces().get(i).setTipoPez((int) (Math.random() * 10));
				}
			}
		}
	}

}