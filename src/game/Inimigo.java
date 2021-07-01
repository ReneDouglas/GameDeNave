package game;

import java.awt.Container;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Inimigo extends Nave implements Runnable{

	private static final long serialVersionUID = 1L;
	protected Api tela;
	private Container cont;
	
	public Inimigo(Movimento mov, int x, int y, Api tela) {
		this.x = x;
		this.y = y;
		this.mov = mov;
		this.tela = tela;
		this.tiro = new ArrayList<Projetil>();
		carregarImagens();
		setBounds(x, y, img.getIconWidth(), img.getIconHeight());
		setIcon(img);
	}
	
	protected void carregarImagens(){
		
		int i = new Random().nextInt(3)+1;
		
		img = new ImageIcon(getClass().getClassLoader().getResource("inimigo_"+i+".png"));
		
		img2 = new ImageIcon[9];
		
		for (int j = 0; j < img2.length; j++) {
			img2[j] = new ImageIcon(getClass().getClassLoader().getResource("explosao_"+(j+1)+".png"));
		}
		
	}
	
	protected void atirar(){
		
		tiro.add(new ProjetilInimigo(this.x+(img.getIconWidth()/2)-8, this.y+40, 5, this, tela));
		cont = this.getParent();
		cont.add(tiro.get(tiro.size()-1));
		cont.setComponentZOrder(tiro.get(tiro.size()-1), 0);
		
	}

	@Override
	public void run() {
		int cont = 0;
		while(vivo){
			
			cont++;
			mov.mover(this);
			if(vivo && cont>1){
				atirar();
				cont = 0;
			}
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		tela.ini.remove(this);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		tela.remove(this);
		
	}
	
}
