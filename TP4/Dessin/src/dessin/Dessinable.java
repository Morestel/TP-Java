package dessin;

import java.awt.Color;
import java.awt.Graphics;

public interface Dessinable {
	public final int H_MAX = 1000;
	public final int L_MAX = 800;

	public final Color COULEUR = Color.RED;
	public void seDessiner(Graphics g);
}
	
