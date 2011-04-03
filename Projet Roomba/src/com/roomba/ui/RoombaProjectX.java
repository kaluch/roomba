package com.roomba.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.roomba.comportement.*;
import com.roomba.environnement.*;
import com.roomba.robot.*;
import com.roomba.roombautil.*;
import com.roomba.shape.*;
import com.roomba.ui.Click;
import com.roomba.ui.ClickForme;

enum Click {
	OBSTACLE, TACHE, VAL
};

enum ClickForme {
	CERCLE, CARRE, RECTANGLE
};

@SuppressWarnings("serial")
public class RoombaProjectX extends JFrame implements WindowListener {


	RoombaPanel jPanel1;
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.ButtonGroup buttonGroup2;
	private javax.swing.ButtonGroup buttonGroup3;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JRadioButton jRadioButton1;
	private javax.swing.JRadioButton jRadioButton2;
	private javax.swing.JRadioButton jRadioButton3;
	private javax.swing.JRadioButton jRadioButton4;
	private javax.swing.JRadioButton jRadioButton5;
	private javax.swing.JRadioButton jRadioButton6;
	private javax.swing.JRadioButton jRadioButton7;
	private javax.swing.JRadioButton jRadioButton8;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JSeparator jSeparator3;
	private javax.swing.JSeparator jSeparator4;
	protected volatile Environnement environ;
	protected Environnement environSave;
	protected Comportement comportementTest;
	protected Comportement comportementSave;
	protected Roomba roomba;
	protected ArrayList<Vecteur> parcour;
	protected int facteurEchelle;
	protected boolean animated = false;
	protected boolean drawParcour = false;
	protected boolean closed = false;
	Click click = Click.OBSTACLE;
	ClickForme clickForme = ClickForme.CERCLE;

	public RoombaProjectX(String string, Comportement comportementTest,
			int facteurEchelle, Roomba roomba) {
		super(string);
		this.environ = new Environnement(new Arene(new Carre(0, 0, 0, 4)));
		try {
			this.environSave = (Environnement) environ.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		this.comportementTest = comportementTest;
		this.comportementSave = (Comportement) comportementTest.clone();
		this.roomba = roomba;
		this.parcour = new ArrayList<Vecteur>();
		this.facteurEchelle = facteurEchelle;
		this.setTitle("Roomba !");
		this.setSize(500, 700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setBackground(Color.WHITE);
		initComponents();
	}

	RoombaProjectX(String string, Comportement comportementTest, Roomba roomba) {
		super(string);
		this.environ = new Environnement(new Arene(new Carre(0, 0, 0, 4)));
		try {
			this.environSave = (Environnement) environ.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		this.comportementTest = comportementTest;
		this.comportementSave = (Comportement) comportementTest.clone();
		this.parcour = new ArrayList<Vecteur>();
		this.roomba = roomba;
		facteurEchelle = 150;
		this.setTitle("Roomba !");
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setBackground(Color.ORANGE);
		initComponents();
	}

	private void initComponents() {
		jPanel1 = new RoombaPanel();
		buttonGroup1 = new javax.swing.ButtonGroup();
		buttonGroup2 = new javax.swing.ButtonGroup();
		buttonGroup3 = new javax.swing.ButtonGroup();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jRadioButton1 = new javax.swing.JRadioButton();
		jRadioButton2 = new javax.swing.JRadioButton();
		jRadioButton3 = new javax.swing.JRadioButton();
		jRadioButton4 = new javax.swing.JRadioButton();
		jRadioButton5 = new javax.swing.JRadioButton();
		jRadioButton6 = new javax.swing.JRadioButton();
		jRadioButton7 = new javax.swing.JRadioButton();
		jRadioButton8 = new javax.swing.JRadioButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel() {
			public void paint(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				if (roomba.getCapteurs().get(0).lecture() == 1)
					g2.setColor(Color.RED);
				else
					g2.setColor(Color.GREEN);
				g2.fillRect(0, 0, 15, 15);
			}
		};
		jPanel3 = new javax.swing.JPanel() {
			public void paint(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				if (roomba.getCapteurs().get(1).lecture() == 1)
					g2.setColor(Color.RED);
				else
					g2.setColor(Color.GREEN);
				g2.fillRect(0, 0, 15, 15);
			}
		};
		jPanel4 = new javax.swing.JPanel() {
			public void paint(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				if (roomba.getCapteurs().get(2).lecture() == 1)
					g2.setColor(Color.RED);
				else
					g2.setColor(Color.GREEN);
				g2.fillRect(0, 0, 15, 15);
			}
		};
		jSeparator1 = new javax.swing.JSeparator();
		jSeparator2 = new javax.swing.JSeparator();
		jSeparator3 = new javax.swing.JSeparator();
		jSeparator4 = new javax.swing.JSeparator();
		jLabel6 = new javax.swing.JLabel();
		this.getContentPane().add(jPanel1);
		this.getContentPane().add(jPanel2);
		this.getContentPane().add(jPanel3);
		this.getContentPane().add(jPanel4);

		// here

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new java.awt.Dimension(800, 600));

		jPanel1.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		jPanel1.setMaximumSize(new java.awt.Dimension(600, 600));
		jPanel1.setMinimumSize(new java.awt.Dimension(600, 600));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 598,
				Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 598,
				Short.MAX_VALUE));

		jButton1.setFont(new java.awt.Font("Tahoma", 1, 18));
		jButton1.setText("START");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setFont(new java.awt.Font("Tahoma", 1, 11));
		jButton2.setText("Stop");
		jButton2.setEnabled(false);
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setText("Init");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		buttonGroup1.add(jRadioButton1);
		jRadioButton1.setSelected(true);
		jRadioButton1.setText("Obstacle");
		jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton1ActionPerformed(evt);
			}
		});

		buttonGroup1.add(jRadioButton2);
		jRadioButton2.setText("Tache");
		jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton2ActionPerformed(evt);
			}
		});

		buttonGroup2.add(jRadioButton3);
		jRadioButton3.setText("Carre");
		jRadioButton3.setBorderPainted(true);
		jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton3ActionPerformed(evt);
			}
		});

		buttonGroup2.add(jRadioButton4);
		jRadioButton4.setSelected(true);
		jRadioButton4.setText("Cercle");
		jRadioButton4.setBorderPainted(true);
		jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton4ActionPerformed(evt);
			}
		});

		buttonGroup2.add(jRadioButton5);
		jRadioButton5.setText("Rectangle");
		jRadioButton5.setBorderPainted(true);
		jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton5ActionPerformed(evt);
			}
		});

		jLabel1.setText("Roue droite      :");

		jLabel2.setText("Roue gauche   :");

		jButton4.setText("Save");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		jButton5.setText("Load");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		buttonGroup3.add(jRadioButton6);
		jRadioButton6.setSelected(true);
		jRadioButton6.setText("Arene carree");
		jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton6ActionPerformed(evt);
			}
		});

		buttonGroup3.add(jRadioButton7);
		jRadioButton7.setText("Arene Circulaire");
		jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton7ActionPerformed(evt);
			}
		});

		jLabel3.setText("Bumper 0");

		jLabel4.setText("Bumper 1");

		jLabel5.setText("Bumper 2");

		jPanel2.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 13,
				Short.MAX_VALUE));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 13,
				Short.MAX_VALUE));

		jPanel3.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 13,
				Short.MAX_VALUE));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 13,
				Short.MAX_VALUE));

		jPanel4.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(
				jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 13,
				Short.MAX_VALUE));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 13,
				Short.MAX_VALUE));

		jLabel6.setText("Capteurs supplementaires : ");

		jRadioButton8.setText("Trace");
		jRadioButton8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton8ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jButton4,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		89,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jRadioButton1)
																.addGap(219,
																		219,
																		219))
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						jSeparator2,
																						javax.swing.GroupLayout.Alignment.LEADING,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						268,
																						Short.MAX_VALUE)
																				.addComponent(
																						jSeparator4,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						268,
																						Short.MAX_VALUE)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jRadioButton6)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																										76,
																										Short.MAX_VALUE)
																								.addComponent(
																										jRadioButton7))
																				.addComponent(
																						jSeparator1,
																						javax.swing.GroupLayout.Alignment.LEADING,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						268,
																						Short.MAX_VALUE)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jButton1,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										203,
																										Short.MAX_VALUE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING,
																												false)
																												.addComponent(
																														jButton3,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														Short.MAX_VALUE)
																												.addComponent(
																														jButton2,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														Short.MAX_VALUE)))
																				.addComponent(
																						jButton5,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						88,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jSeparator3,
																						javax.swing.GroupLayout.Alignment.LEADING,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						268,
																						Short.MAX_VALUE)
																				.addComponent(
																						jRadioButton8,
																						javax.swing.GroupLayout.Alignment.LEADING,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						81,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGroup(
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																								.addComponent(
																										jRadioButton2)
																								.addComponent(
																										jRadioButton4,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										95,
																										javax.swing.GroupLayout.PREFERRED_SIZE)))
																.addGap(18, 18,
																		18))
												.addGroup(
														layout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																false)
																.addComponent(
																		jRadioButton3,
																		javax.swing.GroupLayout.Alignment.LEADING,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(
																		jRadioButton5,
																		javax.swing.GroupLayout.Alignment.LEADING,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel2,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		282,
																		Short.MAX_VALUE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		4,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(
														jLabel1,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														286, Short.MAX_VALUE)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																				.addComponent(
																						jLabel4,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						jLabel5,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						jLabel3))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jPanel4,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jPanel3,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jPanel2,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED))
												.addComponent(
														jLabel6,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														269,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanel1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addContainerGap()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																				.addComponent(
																						jButton1,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						52,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jButton2)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addComponent(
																										jButton3,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										23,
																										javax.swing.GroupLayout.PREFERRED_SIZE)))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						jButton5)
																				.addComponent(
																						jButton4))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jSeparator1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						jRadioButton6)
																				.addComponent(
																						jRadioButton7))
																.addGap(4, 4, 4)
																.addComponent(
																		jSeparator4,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(5, 5, 5)
																.addComponent(
																		jRadioButton8,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		15,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jSeparator2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		2,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						jRadioButton1)
																				.addComponent(
																						jRadioButton2))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						jRadioButton3)
																				.addComponent(
																						jRadioButton4))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jRadioButton5)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		jSeparator3,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		2,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		jLabel2)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jLabel1)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jLabel3)
																								.addGap(7,
																										7,
																										7)
																								.addComponent(
																										jLabel4)
																								.addGap(7,
																										7,
																										7)
																								.addComponent(
																										jLabel5))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jPanel2,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										jPanel3,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										jPanel4,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE)))
																.addGap(26, 26,
																		26)
																.addComponent(
																		jLabel6,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		166,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(
														jPanel1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));

		pack();
		setIcon();
	}

	public void repaint() {
		jPanel1.repaint();
		jPanel2.repaint();
		jPanel3.repaint();
		jPanel4.repaint();

	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		jButton1.setEnabled(false);
		jButton2.setEnabled(true);
		animated = true;
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		jButton1.setEnabled(true);
		jButton2.setEnabled(false);
		animated = false;
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		roomba.setPosture(0, 0, 0);
		jButton1.setEnabled(true);
		jButton2.setEnabled(false);
		animated = false;
		parcour.clear();
		try {
			environ = new Environnement((Arene) environ.getArene().clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		roomba.setComportement((Comportement) comportementSave.clone());
		roomba.move(0.000000000000001, environ);
		repaint();
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			environSave = (Environnement) environ.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

	}

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			environ = (Environnement) environSave.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		jButton2ActionPerformed(evt);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		jButton1ActionPerformed(evt);

	}

	private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		click = Click.OBSTACLE;
	}

	private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		click = Click.TACHE;
	}

	private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		clickForme = ClickForme.CARRE;
		setIcon();
	}

	private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		clickForme = ClickForme.CERCLE;
		setIcon();
	}

	private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		clickForme = ClickForme.RECTANGLE;
		setIcon();
	}

	private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {
		environ.setArene(new Arene(new Carre(0, 0, 0, 4)));
		repaint();
	}

	private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {
		environ.setArene(new Arene(new Cercle(0, 0, 0, 4)));
		repaint();
	}

	private void jRadioButton8ActionPerformed(java.awt.event.ActionEvent evt) {
		drawParcour = !drawParcour;
		repaint();
	}

	public void mAJ() {
		if (this.animated) {
			String tmp = new String();
			String rc = new String("<br>");
			repaint();
			jLabel1.setText("Roue droite      : "
					+ roomba.getRoues().get(1).toString() + "  " + "m/s");
			jLabel2.setText("Roue gauche   : "
					+ roomba.getRoues().get(1).toString() + "  " + "m/s");
			for (int i = 3; i < roomba.getCapteurs().size(); ++i)
				tmp += i + 1 + " " + roomba.getCapteurs().get(i).toString()
						+ rc;
			jLabel6.setText("<html>" + tmp + "</html>");
			environ.nettoyerTache();
			if (drawParcour)
				parcour.add(roomba.getPosture().getPosition());

		}

	}

	public boolean getAnimated() {
		return animated;
	}

	public class RoombaPanel extends JPanel implements MouseListener,
			MouseMotionListener {
		/**
		 * 
		 */
		protected int centrex;
		protected int centrey;
		protected boolean clicked = false;
		protected boolean cursorOn = false;
		protected int sizeOn = 0;
		protected boolean mooving = false;
		protected boolean sizing = false;
		protected int clickedX;
		protected int clickedY;
		protected Forme newForme = new Cercle(0, 0, 0, 0);
		protected Forme formeOn = null;
		protected Obstacle obstacleOn = null;
		protected Thread threadForme;

		RoombaPanel() {
			super();
			this.setSize(facteurEchelle * 4, facteurEchelle * 4);
			centrex = facteurEchelle * 2;
			centrey = facteurEchelle * 2;
			this.setDoubleBuffered(true);
			this.setLocation(10, 10);
			this.setMaximumSize(new Dimension(facteurEchelle * 4,
					facteurEchelle * 4));
			setBorder(javax.swing.BorderFactory
					.createLineBorder(new java.awt.Color(0, 0, 0)));
			this.addMouseListener(this);
			this.addMouseMotionListener(this);
		}

		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			refresh(g2);
			paintEnvironnement(g2, facteurEchelle);
			paintTaches(g2, facteurEchelle);
			if (drawParcour)
				paintParcour(g2, facteurEchelle);
			paintObstacles(g2, facteurEchelle);
			paintCapteurs(g2, facteurEchelle);
			paintRoomba(g2, facteurEchelle);
			if (clicked || mooving || sizing)
				paintNewForme(g2, 1);
			g2.dispose();
		}

		private void paintRoomba(Graphics2D g2, int facteurEchelle) {
			int x = centrex + roomba.getPosxPix(facteurEchelle);
			int y = centrey + roomba.getPosyPix(facteurEchelle);
			int d = roomba.getDiametrePix(facteurEchelle);
			g2.setColor(Color.gray);
			roomba.getForme().paint(g2, facteurEchelle, centrex, centrey);
			g2.setColor(Color.BLACK);
			g2.drawLine(
					x,
					y,
					x
							+ (int) (d / 2 * Math.cos(roomba.getPosture()
									.getTheta())),
					y
							+ (int) (d / 2 * Math.sin(roomba.getPosture()
									.getTheta())));
		}

		private void paintEnvironnement(Graphics2D g2, int facteurEchelle) {
			g2.setColor(Color.LIGHT_GRAY);
			environ.getArene().draw(g2, facteurEchelle, centrex, centrey);
		}

		private void paintParcour(Graphics2D g2, int facteurEchelle) {
			g2.setColor(Color.BLACK);
			for (int i = 0; i < parcour.size() - 1; ++i)
				g2.drawLine(
						(int) ((parcour.get(i).getX() * facteurEchelle + centrex)),
						(int) ((parcour.get(i).getY()) * facteurEchelle + centrey),
						(int) ((parcour.get(i + 1).getX()) * facteurEchelle + centrex),
						(int) ((parcour.get(i + 1).getY()) * facteurEchelle + centrey));
		}

		private void paintCapteurs(Graphics2D g2, int facteurEchelle) {
			for (Capteur x : roomba.getCapteurs()) {
				g2.setColor(Color.GREEN);
				x.draw(g2, facteurEchelle, centrex, centrey);
			}
		}

		private void paintNewForme(Graphics2D g2, int facteurEchelle) {
			g2.setColor(Color.cyan);
			newForme.paint(g2, facteurEchelle, centrex, centrey);
		}

		private void refresh(Graphics2D g2) {
			g2.setColor(Color.WHITE);
			g2.fillRect(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
		}

		private void paintObstacles(Graphics2D g2, int facteurEchelle) {
			for (Obstacle x : environ.getObstacles())
				x.paint(g2, facteurEchelle, centrex, centrey);
		}

		private void paintTaches(Graphics2D g2, int facteurEchelle) {
			for (Tache i : environ.getTaches())
				i.paint(g2, facteurEchelle, centrex, centrey);
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// Nothing to do
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
		}

		@Override
		public void mouseExited(MouseEvent arg0) {

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			clicked = true;
			clickedX = (arg0.getX() - centrex);
			clickedY = (arg0.getY() - centrey);

		}

		@Override
		public synchronized void mouseReleased(MouseEvent arg0) {
			if (mooving) {
				if (!formeOn(newForme))
					environ.ajouterObstacle(new Obstacle(newForme
							.normalize(facteurEchelle)));
			} else if (sizing) {
				if (!formeOn(newForme))
					environ.ajouterObstacle(new Obstacle(newForme
							.normalize(facteurEchelle)));
			} else if (!formeOn(newForme)) {
				if (click == Click.TACHE)
					environ.ajouterTache(new Tache(newForme
							.normalize(facteurEchelle)));
				else if (click == Click.OBSTACLE)
					environ.ajouterObstacle(new Obstacle(newForme
							.normalize(facteurEchelle)));
			}
			clicked = false;
			mooving = false;
			sizing = false;
			repaint();
		}

		private boolean formeOn(Forme forme) {
			boolean retour = false;
			for (Obstacle o : environ.getObstacles())
				retour = retour || forme.collisionExterne(o.getForme());
			for (Tache o : environ.getTaches())
				retour = retour || forme.collisionExterne(o.getForme());
			return retour;

		}

		@Override
		public void mouseDragged(MouseEvent arg0) {
			if (cursorOn && sizeOn == 0) {
				if (!mooving) {
					mooving = true;
					try {
						formeOn.iso(facteurEchelle);
						newForme = (Forme) formeOn.clone();
						environ.enleverObstacle(obstacleOn);
					} catch (CloneNotSupportedException e) {
						e.printStackTrace();
					}

				} else {
					newForme.getPosture().setX(
							formeOn.getPosture().getX() * facteurEchelle
									- centrex
									+ ((double) (-clickedX + arg0.getX())));
					newForme.getPosture().setY(
							formeOn.getPosture().getY() * facteurEchelle
									- centrey
									+ ((double) (-clickedY + arg0.getY())));
					repaint();
				}
			} else if (sizeOn != 0) {
				if (!sizing) {
					sizing = true;
					try {
						formeOn.iso(facteurEchelle);
						newForme = (Forme) formeOn.clone();
						environ.enleverObstacle(obstacleOn);
					} catch (CloneNotSupportedException e) {
						e.printStackTrace();
					}
				} else {
					if (formeOn instanceof Cercle)
						newForme = new Cercle(formeOn.getPosture().getX()
								* facteurEchelle, formeOn.getPosture().getY()
								* facteurEchelle, 0, 2 * Math.sqrt(Math.pow(
								formeOn.getPosture().getX() * facteurEchelle
										+ centrex - arg0.getX(), 2)
								+ Math.pow(+centrey
										+ formeOn.getPosture().getY()
										* facteurEchelle - arg0.getY(), 2)));
					if (formeOn instanceof Carre)
						newForme = new Carre(formeOn.getPosture().getX()
								* facteurEchelle, formeOn.getPosture().getY()
								* facteurEchelle, 0, 2 * Math.sqrt(Math.pow(
								formeOn.getPosture().getX() * facteurEchelle
										+ centrex - arg0.getX(), 2)
								+ Math.pow(+centrey
										+ formeOn.getPosture().getY()
										* facteurEchelle - arg0.getY(), 2)));
					if (formeOn instanceof Rectangle)
						newForme = new Rectangle(formeOn.getPosture().getX()
								* facteurEchelle, formeOn.getPosture().getY()
								* facteurEchelle, 0, 4 * Math.abs(formeOn
								.getPosture().getX()
								* facteurEchelle
								+ centrex
								- arg0.getX()) / 2, 4 * Math.abs(formeOn
								.getPosture().getY()
								* facteurEchelle
								+ centrey
								- arg0.getY()) / 2);
				}
				repaint();
			} else {
				threadForme = new Thread(new PaintNewForme(arg0, this));
				threadForme.start();
				repaint();
			}

		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			selectForme(arg0.getX(), arg0.getY());
			selectSize(arg0.getX(), arg0.getY());
			if (cursorOn && sizeOn == 0)
				setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
			else if (sizeOn != 0) {
				if (sizeOn == 1)
					setCursor(Cursor
							.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
				if (sizeOn == 2)
					setCursor(Cursor
							.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
				if (sizeOn == 3)
					setCursor(Cursor
							.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));
				if (sizeOn == 4)
					setCursor(Cursor
							.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));
			} else
				setCursor(Cursor.getDefaultCursor());

		}

		protected boolean selectForme(double x, double y) {
			boolean retour = false;
			for (Obstacle w : environ.getObstacles()) {
				if (w.getForme().collisionPoint(
						((double) (x - centrex)) / facteurEchelle,
						((double) (y - centrey)) / facteurEchelle)) {
					retour = true;
					formeOn = w.getForme();
					obstacleOn = w;
				}
			}
			if (retour)
				cursorOn = true;
			else
				cursorOn = false;
			return retour;
		}

		protected boolean selectSize(double x, double y) {
			boolean retour = false;
			for (Obstacle w : environ.getObstacles()) {
				sizeOn = w.getForme().tangeantPoint(
						((double) (x - centrex)) / facteurEchelle,
						((double) (y - centrey)) / facteurEchelle);
				if (sizeOn != 0) {
					retour = true;
					formeOn = w.getForme();
					obstacleOn = w;
				}
			}
			return retour;
		}
	}

	class PaintNewForme implements Runnable {

		private MouseEvent mouseEvent;
		private RoombaPanel component;

		PaintNewForme(MouseEvent mouseEvent, RoombaPanel component) {
			this.mouseEvent = mouseEvent;
			this.component = component;
		}

		@Override
		public void run() {
			if (component.clicked) {
				double actualX = (mouseEvent.getX() - component.centrex);
				double actualY = (mouseEvent.getY() - component.centrey);
				switch (clickForme) {
				case CERCLE:
					component.newForme = new Cercle(
							component.clickedX,
							component.clickedY,
							0,
							2 * Math.sqrt(Math.pow(
									component.clickedX - actualX, 2)
									+ Math.pow(component.clickedY - actualY, 2)));
					break;
				case CARRE:
					component.newForme = new Carre(
							component.clickedX,
							component.clickedY,
							0,
							2 * Math.sqrt(Math.pow(
									component.clickedX - actualX, 2)
									+ Math.pow(component.clickedY - actualY, 2)));
					break;
				case RECTANGLE:
					component.newForme = new Rectangle(component.clickedX,
							component.clickedY, 0,
							4 * Math.abs(component.clickedX - actualX) / 2,
							4 * Math.abs(component.clickedY - actualY) / 2);
					break;
				default:
					component.newForme = new Cercle(
							component.clickedX,
							component.clickedY,
							0,
							2 * Math.sqrt(Math.pow(
									component.clickedX - actualX, 2)
									+ Math.pow(component.clickedX - actualX, 2)));
				}
			}
		}

	}

	private void setIcon() {
		jRadioButton3.setIcon(new javax.swing.JLabel() {
			public javax.swing.Icon getIcon() {
				try {
					if (clickForme == ClickForme.CARRE)
						return new javax.swing.ImageIcon(new java.net.URL(
								"file:resources/carreChosen.jpg"));
					else
						return new javax.swing.ImageIcon(new java.net.URL(
								"file:resources/carre.jpg"));
				} catch (java.net.MalformedURLException e) {
				}
				return null;
			}
		}.getIcon());
		jRadioButton4.setIcon(new javax.swing.JLabel() {
			public javax.swing.Icon getIcon() {
				try {
					if (clickForme == ClickForme.CERCLE)
						return new javax.swing.ImageIcon(new java.net.URL(
								"file:resources/cercleChosen.jpg"));
					else
						return new javax.swing.ImageIcon(new java.net.URL(
								"file:resources/cercle.jpg"));
				} catch (java.net.MalformedURLException e) {
				}
				return null;
			}
		}.getIcon());
		jRadioButton5.setIcon(new javax.swing.JLabel() {
			public javax.swing.Icon getIcon() {
				try {
					if (clickForme == ClickForme.RECTANGLE)
						return new javax.swing.ImageIcon(new java.net.URL(
								"file:resources/rectangleChosen.jpg"));
					else
						return new javax.swing.ImageIcon(new java.net.URL(
								"file:resources/rectangle.jpg"));
				} catch (java.net.MalformedURLException e) {
				}
				return null;
			}
		}.getIcon());

	}

	public Environnement getEnviron() {
		return environ;

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowClosed(WindowEvent e) {
		closed = true;
	}

	@Override
	public void windowClosing(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	public boolean getClosed() {
		return closed;
	}

}
