package dessin;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import java.awt.Graphics;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseAdapter;
import java.io.Serializable;

public class Panneau extends JPanel implements MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;
	transient Point aP;
	transient Cercle aC;
	transient Cercle aC2;
	transient Polygone aP1;
	transient Polygone aP2;
	transient EnsembleFormeAlea ensembleF;
	transient Point pInit;
	transient Point pFin;
	double rayon;
	boolean segmentEnCours = false;
	boolean faireCercle = true;
	JLabel label = new JLabel();

	public Panneau() throws SommetNul {
		JToolBar toolBar = new JToolBar();
		setLayout(new BorderLayout());
		JButton button1 = new JButton("Arc-en-ciel");
		this.add(button1);
		JButton button2 = new JButton("Nouvelle Forme");
		this.add(button2);
		this.ensembleF = new EnsembleFormeAlea(20);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent pE) {
				ensembleF.changeCouleur();
				repaint();
			}
		});
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent pE) {
				try {
					ensembleF.ajouterFormeAlea();
				} catch (SommetNul e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				repaint();
			}
		});
		JButton button5 = new JButton("Sauvegarder");
		JButton button6 = new JButton("Restaurer");
		this.add(button5);
		this.add(button6);
		JButton button3 = new JButton("Cercle");
		JButton button4 = new JButton("Polygone");
		this.add(button3);
		this.add(button4);

		
		button3.addActionListener(new ActionListener(){
			public void actionPerformed(final ActionEvent pE){
				faireCercle = true;
			}
		});

		button4.addActionListener(new ActionListener(){
			public void actionPerformed(final ActionEvent pE){
				faireCercle = false;
			}
		});
		addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e){
				pInit = new Point(e.getX(), e.getY());
				pFin = new Point(e.getX(), e.getY());
				segmentEnCours = true;
			}

			@Override
			public void mouseReleased(MouseEvent e){
				segmentEnCours = false;
			}
		
		});
		addMouseMotionListener(new MouseAdapter(){
			@Override
			public void mouseDragged(MouseEvent e) {
				if (segmentEnCours) {
					pFin.setaX(e.getX());
					pFin.setaY(e.getY());
					repaint();
				}	
			}
		});

	toolBar.add(button1);
	toolBar.add(button2);
	toolBar.add(button3);
	toolBar.add(button4);
	toolBar.add(button5);
	toolBar.add(button6);
	this.add(toolBar, BorderLayout.NORTH);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//this.ensembleF.toutDessiner(g);
		
		this.add(label, BorderLayout.SOUTH);
		if (pInit != null){
			if (faireCercle){
				rayon = pInit.distance(pFin);
				Cercle vC = new Cercle(pInit, rayon);
				vC.seDessiner(g);
				label.setText("Dessin Cercle  " + vC.toString());
			}	
			else{
				label.setText(this.toString());
			}
		}
	}


	
	
	
	@Override
	public void mouseClicked(MouseEvent e){
		//TODO
	}
	@Override
	public void mouseEntered(MouseEvent e){
		//TODO
	}
	@Override
	public void mouseExited(MouseEvent e){
		//TODO
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}