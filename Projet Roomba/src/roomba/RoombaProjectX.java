package roomba;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class RoombaProjectX extends JFrame {

	/**
	 * 
	 */

	/**
	 * @param args
	 */
	RoombaPanel pan;
	protected Environnement environ;
	protected Roomba roomba;
	
	RoombaProjectX(String string,Environnement environ, Roomba roomba){
		super(string);
		this.environ = environ;
		this.roomba = roomba;
		this.setTitle("Roomba !");
        // 400 px de large et 500 px de haut
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(RoombaX.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBackground(Color.WHITE);
        initComponents();
	}
	
	private void initComponents(){
		pan = new RoombaPanel();
		this.getContentPane().add(pan);
	}
	public void repaint(){
		pan.repaint();
	}
	public static void main(String[] args) {
		
		Roomba roomba = new Roomba(0.34);
		RoombaProjectX fen = new RoombaProjectX("Roomba Simulation",new Environnement(),roomba);
		fen.setVisible(true);
		while(true){
			roomba.calculVitesseRoue(new IdiotVillage());
			roomba.move(0.1);
			// attend 0.1 sec
			try  { Thread.sleep(100); }
			catch (Exception e) {}
		fen.repaint();
		}

	}

	public class RoombaPanel extends JPanel {
		/**
		 * 
		 */
		
		
		RoombaPanel(){
			super();
			
		}
		public void paint(Graphics g){
			Graphics2D g2 = (Graphics2D) g;
			refresh(g2);
		    paintEnvironnement(g2);
		    paintRoomba(g2);
		    paintCapteurs(g2);
			g2.dispose();
			
		}
		private void paintRoomba(Graphics2D g2){
			int x = pan.getWidth()/2+roomba.getPosxPix();
			int y = pan.getHeight()/2+roomba.getPosyPix();
			int d = roomba.getDiametrePix();
			g2.setColor(Color.red);
		    g2.fillOval(x, y,d,d);
		    g2.setColor(Color.BLACK);
		    g2.drawLine(x+d/2,y+d/2,x+d/2+(int)(d/2 *Math.cos(roomba.posture.getTheta())),y+d/2+(int)(d/2 *Math.sin(roomba.posture.getTheta())));
		}
		private void paintEnvironnement(Graphics2D g2){
			g2.setColor(Color.GRAY);
		    //environ.getArene().paint(g2);
		}
		private void paintCapteurs(Graphics2D g2){
			for(Capteur x : roomba.getCapteurs())
				x.paint(g2,pan,roomba.getDiametrePix());
				
		}
		private void refresh(Graphics2D g2){
			g2.setColor(Color.WHITE);
			g2.fillRect(0,0,pan.getWidth(),pan.getHeight());
			
		}
	}
	
}
