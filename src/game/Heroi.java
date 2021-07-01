package game;

import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Heroi extends Nave implements KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container t1;
	public int pontuacao = 0;

	public Heroi(int x, int y, Api tela) {
		this.x = x;
		this.y = y;
		this.tela = tela;
		tiro = new ArrayList<Projetil>();
		carregarImagens();
		setBounds(x, y, img.getIconWidth(), img.getIconHeight());
		setIcon(img);
	}
	
	protected void carregarImagens() {
		
		img = new ImageIcon(getClass().getClassLoader().getResource("nave_6.png"));
		img2 = new ImageIcon[9];
		
		for (int j = 0; j < img2.length; j++) {
			img2[j] = new ImageIcon(getClass().getClassLoader().getResource("explosao_"+(j+1)+".png"));
		}
		
	}
	
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
				
				for (int i = 0; i < 10; i++) {
					if (this.x-1 > 0)
						this.setLocation(this.x-=1, this.getY());
						
					else break;
					
				}
				
			}else if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
				
				for (int i = 0; i < 10; i++) {
					if (this.x+1 < 600-this.img.getIconWidth())
						this.setLocation(this.x+=1, this.getY());
						
					else break;
					
				}
				
			}
			
			else if (e.getKeyCode()==KeyEvent.VK_SPACE) {
				
				tiro.add(new Projetil(this.x+(img.getIconWidth()/2)-8, this.y-30, 3, this, tela));
				t1 = this.getParent();
				t1.add(tiro.get(tiro.size()-1));
				t1.setComponentZOrder(tiro.get(tiro.size()-1), 0);
	
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
}
