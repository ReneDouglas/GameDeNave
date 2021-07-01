package game;

import java.awt.Container;
import java.util.ArrayList;
import java.util.Random;


public class Gerenciador extends Thread{
	
	private Api tela;
	private ArrayList<Integer> naves;
	Container api;
	
	public Gerenciador(Api tela) {
		this.tela = tela;
		
		naves = new ArrayList<Integer>();
		naves.add(50);
		naves.add(150);
		naves.add(250);
		naves.add(350);
		
	}
	
	private void criarNave(){
		
		int x = new Random().nextInt(4);
		
		if(x == 0) tela.ini.add(new Inimigo(tela.mov, naves.get(x), 0, tela));
		else if (x == 1) tela.ini.add(new Inimigo(tela.mov, naves.get(x), 0, tela));
		else if (x == 2) tela.ini.add(new Inimigo(tela.mov, naves.get(x), 0, tela));
		else tela.ini.add(new Inimigo(tela.mov, naves.get(x), 0, tela));
		
		new Thread(tela.ini.get(tela.ini.size()-1)).start();
		Container cont = tela.cenario.lb.getParent();
		cont.add(tela.ini.get(tela.ini.size()-1));
		cont.setComponentZOrder(tela.ini.get(tela.ini.size()-1), 0);
		
	}
	
	public void run() {
		
		while (true) {
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			criarNave();
			
		}
		
	}

}
