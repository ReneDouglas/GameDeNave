package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Projetil extends JLabel implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int x;
	public int y;
	public int velocidade;
	public boolean atingiu = false;
	protected Icon img;
	private Heroi nave;
	protected Api tela;
	
	public Projetil(int x, int y, int velocidade, Nave nave, Api tela) {
		
		this.x = x;
		this.y = y;
		this.tela = tela;
		this.nave = (Heroi) nave;
		this.velocidade = velocidade;
		carregarSprite();
		new Thread(this).start();
		
		
	}
	
	public Projetil() {
		// TODO Auto-generated constructor stub
	}
	
	public void verificarColisao(){
		
		for (int i = 0; i < tela.ini.size(); i++) {
			if(tela.ini.get(i).vivo){
				if(this.getBounds().intersects(tela.ini.get(i).getBounds())){
					this.atingiu = true;
					this.setVisible(false);
					this.nave.pontuacao += 50;
					tela.ini.get(i).destruir();
					break;
				
				}
			}
		}
		
	}
	
	private void mover(){
		
		setBounds(this.x, this.y-=1, this.img.getIconWidth(), this.img.getIconHeight());
		setIcon(img);
		
	}
	
	private void carregarSprite(){
		
		img = new ImageIcon(getClass().getClassLoader().getResource("tiro.png"));
		
	}

	@Override
	public void run() {
		
		while(!atingiu && this.y >= 0){
			
			mover();
			verificarColisao();
			
			try {
				Thread.sleep(velocidade);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		tela.remove(this);
		nave.tiro.remove(this);
		
		
		
	}

}
