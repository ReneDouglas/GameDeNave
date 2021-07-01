package game;

import javax.swing.ImageIcon;

public class ProjetilInimigo extends Projetil{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Inimigo ini;
	
	
	public ProjetilInimigo(int x, int y, int velocidade, Nave nave, Api tela) {
		this.x = x;
		this.y = y;
		this.tela = tela;
		this.ini = (Inimigo) nave;
		this.velocidade = velocidade;
		carregarSprite();
		new Thread(this).start();
	}
	
	
	private void mover(){
		
		setBounds(this.x, this.y+=1, this.img.getIconWidth(), this.img.getIconHeight());
		setIcon(img);
		
	}
	
	public void verificarColisao(){
		
		if(tela.heroi.vivo){
			if(this.getBounds().intersects(tela.heroi.getBounds())){
				tela.removeKeyListener(tela.heroi);
				this.atingiu = true;
				this.setVisible(false);
				tela.heroi.destruir();
			}
		}
		
	}
	
	private void carregarSprite(){
		
		img = new ImageIcon(getClass().getClassLoader().getResource("tiro_2.png"));
		
	}
	
	@Override
	public void run() {
		
		while(!atingiu && this.y <= 640){
					
			mover();
			verificarColisao();
			
			try {
				Thread.sleep(velocidade);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		this.setVisible(false);
		ini.tiro.remove(this);
		
		
		
	}
	
	

}
