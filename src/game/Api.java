package game;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Api extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	
	public Heroi heroi;
	public ArrayList<Inimigo> ini;
	public Movimento mov;
	private Gerenciador manager;
	public Cenario cenario;
	private JLabel score;
	
	public Api() {
		super("Jogo");
		setSize(600, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		
		manager = new Gerenciador(this);
		mov = new Movimento();
		heroi = new Heroi(350, 580, this);
		
		score = new JLabel("SCORE: "+heroi.pontuacao);
		score.setFont(new Font("Tahoma", Font.BOLD, 18));
		score.setForeground(Color.WHITE);
		score.setBounds(10, 620, 200, 50);
		
		add(score);		
		add(heroi);
		manager.start();
	
		ini = new ArrayList<Inimigo>();
		
		ini.add(new Inimigo(mov, 50, 0, this));
		ini.add(new Inimigo(mov, 150, 0, this));
		ini.add(new Inimigo(mov, 250, 0, this));
		ini.add(new Inimigo(mov, 350, 0, this));
		
		new Thread(ini.get(0)).start();
		new Thread(ini.get(1)).start();
		new Thread(ini.get(2)).start();
		new Thread(ini.get(3)).start();
		add(ini.get(0));
		add(ini.get(1));
		add(ini.get(2));
		add(ini.get(3));
		
		cenario = new Cenario(this);
		cenario.construirCenario();
		
		
		addKeyListener(heroi);
		
		new Thread(this).start();

		setVisible(true);
	}
	
	
	/*private synchronized void colisaoInimigo(Heroi hero, ArrayList<Inimigo> ini){
		
				for (int i = 0; i < hero.tiro.size(); i++) {	
					
					for (int j = 0; j < ini.size(); j++) {
						
						if(hero.tiro.get(i).getBounds().intersects(ini.get(j).getBounds())){	
							hero.tiro.get(i).atingiu = true;
							//ini.get(j).vivo = false;
							if(hero.tiro.get(i).isVisible() == false) this.remove(hero.tiro.get(i));
							
						}
						
					}
				
			}
			
		
	}
	
	private synchronized void colisaoHeroi(Heroi hero, ArrayList<Inimigo> ini){
		
		for (int i = 0; i < ini.size(); i++) {
			
			for (int j = 0; j < ini.get(i).tiro.size(); j++) {
				
				if(ini.get(i).tiro.get(j).getBounds().intersects(hero.getBounds())){
					
					removeKeyListener(heroi);
					hero.destruir();
										
				}
				
			}
	
			
		}
	}*/
	
	
	
	public static void main(String[] args) {
		new Api();

	}

	@Override
	public void run() {
		while(true){
			
			score.setText("SCORE: "+heroi.pontuacao);
			
			if(!heroi.vivo){
				
				try {
					Thread.sleep(1500);
					System.exit(0);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}		
			}
			//colisaoInimigo(heroi, ini);
			//colisaoHeroi(heroi, ini);
			
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	

}
