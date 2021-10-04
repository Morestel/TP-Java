package wargame;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class BoutonMenu{

	public BoutonMenu(int hauteurBouton, int largeurBouton, int posX, int posY, float fontSize, String texte, boolean fontPerso) {
		JLabel bouton = new JLabel();
		Font boutonFont = null;
		Border border = BorderFactory.createLineBorder(Color.GREEN, 2, true);
		
		if (fontPerso == true) {
			//Police personnalise	
			String urlFont = "/resources/Font/aniron.ttf";
			try (InputStream isFont = this.getClass().getResourceAsStream(urlFont);){
				boutonFont = Font.createFont(Font.TRUETYPE_FONT, isFont);
				GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
				ge.registerFont(boutonFont);
				boutonFont = boutonFont.deriveFont(fontSize);
			} catch (IOException | FontFormatException e) {
				e.printStackTrace();
			}
		} else {
			 boutonFont = new Font("Verdana", Font.PLAIN, (int)fontSize);
		}
		
		//Texte
		bouton.setText(texte);
		bouton.setHorizontalTextPosition(SwingConstants.CENTER); //Centrage du texte dans le JLabel
		bouton.setFont(boutonFont);
		
		
		//Dimension
		bouton.setBounds((posX-(largeurBouton/2)) , (posY-(hauteurBouton/2)), largeurBouton, hauteurBouton);
		
		//Test Couleur
		bouton.setForeground(Color.WHITE);
		bouton.setBorder(border);
		
		//Evenement souris (modification couleurs)
		//A venir
	}
}