package dessin;
import java.awt.Graphics;
import java.awt.Color;

public interface Forme{
	public abstract double perimetre();
	public abstract double surface();
	public abstract boolean dedans(Point pP);
	public abstract boolean plusGrand(Forme cP);
	public abstract void translater(double dx, double dy) throws SommetNul;
	public abstract void zoom(int pZoomx) throws SommetNul;
	public abstract void seDessiner(Graphics g);
	public abstract void setACouleur(Color aCouleur);
}