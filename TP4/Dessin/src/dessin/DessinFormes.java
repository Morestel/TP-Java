package dessin;
import javax.swing.JFrame;
import java.awt.Color;
public class DessinFormes {
	public static void main(String[] args) throws SommetNul{
		JFrame fenetre = new JFrame("Dessin de formes géométriques");
		fenetre.setSize(1000, 800);
		fenetre.setLocation(100, 100);
		fenetre.setBackground(Color.GRAY);
		Panneau vPanneau = new Panneau();
		fenetre.add(vPanneau);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);			
	}	
}
