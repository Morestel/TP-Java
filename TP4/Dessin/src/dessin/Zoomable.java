package dessin;

public interface Zoomable {
	public Point getCentre();
	public double getRayon();
	public double perimetre();
	public double surface();
	public boolean dedans(Point p);
	public boolean plusGrand(Cercle pC);
	public void translater(double dx, double dy);
	public String toString();
	public void zoom(int zoomX);
	
	public void construire(Point p1, Point p2);
	public double hauteur();
	public double largeur();
}
