package wargame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.net.URL;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Accueil extends JPanel implements IConfig {
	
	private static final long serialVersionUID = 1L;
	private transient Image accueilBackground;
	private transient int lancer = 0;
	private transient PanneauJeu aGame;
	private transient JFrame aWindow;
	
	public JPanel menu() {
		JPanel menu = new JPanel();
		JLabel titre = new JLabel("Wargame",SwingConstants.CENTER);
		JLabel game = new JLabel("Jouer",SwingConstants.CENTER);
		JLabel quit = new JLabel("Quitter",SwingConstants.CENTER);
		Border border = BorderFactory.createLineBorder(Color.GREEN, 2, true);
		
		menu.setOpaque(false);
		menu.setPreferredSize(new Dimension(LARGEUR_FENETRE, HAUTEUR_FENETRE));
		
		//Police et taille
		titre.setFont(new Font("Verdana", Font.PLAIN, 80));
		game.setFont(new Font("Verdana", Font.PLAIN, 50));
		quit.setFont(new Font("Verdana", Font.PLAIN, 50));
		
		//Couleur
		titre.setForeground(Color.RED);
		game.setForeground(Color.BLUE);
		quit.setForeground(Color.BLUE);
		
		//Bordure
		game.setBorder(border);
		quit.setBorder(border);
		
		//Position
		Dimension size_t = titre.getPreferredSize();
		Dimension size_g = game.getPreferredSize();
		Dimension size_q = quit.getPreferredSize();
		titre.setBounds(((LARGEUR_FENETRE/2)-(size_t.width/2)), 25, size_t.width, size_t.height);
		game.setBounds(((LARGEUR_FENETRE/2)-(size_g.width/2)-(250/2)), 225, (size_g.width+250), size_g.height);
		quit.setBounds(((LARGEUR_FENETRE/2)-(size_q.width/2)-(250/2)), 425, (size_q.width+250), size_q.height);
		menu.setLayout(null);
		
		menu.add(titre);
		menu.add(game);
		menu.add(quit);

		Accueil vTemp = this;
		this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

				if(game.getBounds().contains(e.getPoint())){
					aWindow.remove(vTemp);
					aWindow.add(aGame);
					aWindow.repaint();
					aWindow.pack();
				}
				if(quit.getBounds().contains(e.getPoint())){
					System.exit(0);
				}
			}

		});
		return menu;		
	}
	
	public Accueil(PanneauJeu pGame,JFrame pWindow) {
		this.aGame = pGame;
		this.aWindow = pWindow;
		try {
			URL url = this.getClass().getResource("/resources/accueil_background.jpg");
			accueilBackground = ImageIO.read(url);
			accueilBackground = accueilBackground.getScaledInstance(LARGEUR_FENETRE, HAUTEUR_FENETRE, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();			
		}
		setLayout(new BorderLayout());
		this.add(menu());
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(accueilBackground,0,0,this);
	}

	public int getLancer(){
		return this.lancer;
	}

	public void setLancer(int pLancer){
		this.lancer = pLancer;
	}

}