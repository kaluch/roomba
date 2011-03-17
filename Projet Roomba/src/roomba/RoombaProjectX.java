package roomba;

import java.awt.Color;
import java.awt.Dimension;
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
	protected int facteurEchelle;
	
	RoombaProjectX(String string,Environnement environ, Roomba roomba,int facteurEchelle){
		super(string);
		this.environ = environ;
		this.roomba = roomba;
		this.facteurEchelle = facteurEchelle;
		this.setTitle("Roomba !");
        this.setSize(500, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(RoombaX.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBackground(Color.WHITE);
        initComponents();
	}
	RoombaProjectX(String string,Environnement environ, Roomba roomba){
		super(string);
		this.environ = environ;
		this.roomba = roomba;
		facteurEchelle = 150;
		this.setTitle("Roomba !");
        // 400 px de large et 500 px de haut
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(RoombaX.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBackground(Color.ORANGE);
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
		
		Roomba roomba = new Roomba(0.34,new EvitObstacles());
		Environnement environ = new Environnement(new Arene(new Cercle(0,0,0,3.8)));
		//environ.ajouterObstacle(new Obstacle(new Cercle(1.5,0,0,1)));
		//environ.ajouterObstacle(new Obstacle(new Cercle(1,1.5,0,1)));
		environ.ajouterObstacle(new Obstacle(new Cercle(1,0.5,0,1)));
		
		RoombaProjectX fen = new RoombaProjectX("Roomba Simulation",environ,roomba);
		fen.setVisible(true);
		while(true){
			roomba.move(0.01,environ);
			// attend 0.1 sec
			try  { Thread.sleep(10); }
			catch (Exception e) {}
		fen.repaint();
		}

	}

	public class RoombaPanel extends JPanel {
		/**
		 * 
		 */
		protected int centrex;
		protected int centrey;
		
		RoombaPanel(){
			super();
			this.setSize(facteurEchelle*4,facteurEchelle*4);
			centrex = facteurEchelle*2;
			centrey = facteurEchelle*2;			
			this.setDoubleBuffered(true);
			this.setLocation(10, 10);
			this.setMaximumSize(new Dimension(facteurEchelle*4,facteurEchelle*4));
		}
		public void paint(Graphics g){
			Graphics2D g2 = (Graphics2D) g;
			refresh(g2);
		    paintEnvironnement(g2,facteurEchelle);
		    paintObstacles(g2,facteurEchelle);
		    paintTaches(g2,facteurEchelle);
		    paintCapteurs(g2,facteurEchelle);
		    paintRoomba(g2,facteurEchelle);
			g2.dispose();
			
		}
		private void paintRoomba(Graphics2D g2, int facteurEchelle){
			int x = centrex+roomba.getPosxPix(facteurEchelle);
			int y = centrey+roomba.getPosyPix(facteurEchelle);
			int d = roomba.getDiametrePix(facteurEchelle);
			g2.setColor(Color.gray);
			roomba.getForme().paint(g2,facteurEchelle,centrex,centrey);
		   // g2.fillOval(x, y,d,d);
		    g2.setColor(Color.BLACK);
		    g2.drawLine(x,y,x+(int)(d/2 *Math.cos(roomba.posture.getTheta())),y+(int)(d/2 *Math.sin(roomba.posture.getTheta())));
		}
		private void paintEnvironnement(Graphics2D g2, int facteurEchelle){
			g2.setColor(Color.GRAY);
			environ.getArene().draw(g2,facteurEchelle,centrex,centrey);
		}
		private void paintCapteurs(Graphics2D g2, int facteurEchelle){
			g2.setColor(Color.GREEN);
			for(Capteur x : roomba.getCapteurs())
				x.draw(g2,facteurEchelle,centrex,centrey);

		}
		private void refresh(Graphics2D g2){
			g2.setColor(Color.WHITE);
			g2.fillRect(0,0,pan.getWidth(),pan.getHeight());
			
		}
		
		private void paintObstacles(Graphics2D g2,int facteurEchelle){
			for(Obstacle x : environ.getObstacles())
				x.paint(g2,facteurEchelle,centrex,centrey);
		}
		
		private void paintTaches(Graphics2D g2,int facteurEchelle){
			for(Tache i : environ.getTaches())
				i.paint(g2,facteurEchelle,centrex,centrey);
		}
	}
	
}
