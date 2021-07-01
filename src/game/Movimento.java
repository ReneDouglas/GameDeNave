package game;

import java.util.Random;

public class Movimento{
	int direcao;

	public Movimento() {
		
	}
	
	public synchronized void mover(Inimigo ini){
		direcao=new Random().nextInt(3);
		
		for (int i = 0; i < 50; i++) {
			
			if (direcao==0) {//vai para baixo
				
				ini.setBounds(ini.x, ini.y+=1, ini.img.getIconWidth(), ini.img.getIconHeight());
				
			}else if (direcao==1) {//vai para esquerda
				
				if (ini.x-1>0)
					ini.setBounds(ini.x-=1, ini.y, ini.img.getIconWidth(), ini.img.getIconHeight());
					
				else break;
				
			}else if (direcao==2) {//vai para direita
				
				if (ini.x+1<600-ini.img.getIconWidth())
					ini.setBounds(ini.x+=1, ini.y, ini.img.getIconWidth(), ini.img.getIconHeight());
				
				else break;
			}
			
			try {
				Thread.sleep(8);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
	}
	
}
