package game;

import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class Nave extends JLabel{
	
	private static final long serialVersionUID = 1L;
	protected int x,y;
	protected Icon img, img2[];
	protected Movimento mov = null;
	protected boolean vivo = true;
	protected ArrayList<Projetil> tiro;
	protected Api tela;
	
	
	protected abstract void carregarImagens();
	
	protected void destruir(){
		
		this.vivo = false;
		
		for (int i = 0; i < img2.length; i++) {
			
			setBounds(x, y, img2[i].getIconWidth(), img2[i].getIconHeight());
			setIcon(img2[i]);
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
		
		setVisible(false);
		
	}

}
