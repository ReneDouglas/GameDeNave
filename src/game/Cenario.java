package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Cenario extends Thread{
	
	private Api tela;
	private Icon img;
	public JLabel lb;
	public JLabel lb2;
	
	public Cenario(Api tela) {
		this.tela = tela;
	}
	
	public void construirCenario(){
		
		img = new ImageIcon(getClass().getClassLoader().getResource("universo-1.jpg"));
		lb = new JLabel();
		lb2 = new JLabel();
		lb.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		lb.setIcon(img);
		lb2.setIcon(img);
		
		tela.add(lb2);
		tela.add(lb);
		
		new Thread(this).start();
		
	}
	
	private void cenarioMovimento(int i){
		
		if(lb.getY()<=610 && lb2.getY()<0){ // estado inicial
			lb.setBounds(0, 0+i, img.getIconWidth(), img.getIconHeight());
		}
		if(lb.getY()>=0){ // junta a outra img
			lb2.setBounds(0, -img.getIconHeight()+3+i, img.getIconWidth(), img.getIconHeight());
		}
		
		if(lb2.getY()>=0){ // chama novamente a inicial
			lb.setBounds(0, -img.getIconHeight()+3+i, img.getIconWidth(), img.getIconHeight());
		}
		
	}
	
	@Override
	public void run() {
		int i = 0;
		while (true) {
			
			i++;
			cenarioMovimento(i);
			if(i == img.getIconHeight()) i = 0;
			
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	

}
