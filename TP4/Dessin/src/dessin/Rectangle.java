package dessin;

public class Rectangle extends Quadrilatere{

	public int aNbR;
	
	public Rectangle(Point p1, Point p2) throws SommetNul{
		this.construire(p1, p2);
		aNbR++;
		aNumType = aNbR;
	}
	
	public void construire(Point p1, Point p2) throws SommetNul{
		this.changePoint(0, p1);
		this.changePoint(2, p2);

		this.aSommets[1].aX = this.aSommets[2].aX;
		this.aSommets[1].aY = this.aSommets[0].aY;
		this.aSommets[3].aX = this.aSommets[0].aX;
		this.aSommets[3].aY = this.aSommets[1].aY;
	}
	
	public double hauteur() {
		return this.aSommets[0].distance(this.aSommets[3]);
	}
	
	public double largeur() {
		return this.aSommets[0].distance(this.aSommets[1]);
	}

	@Override
	public double surface() {
		System.out.println("Calcul de la surface d'un rectangle");
		return this.hauteur() * this.largeur();
	}
	
	@Override
	public void zoom(int zoomX) throws SommetNul{
		Point vP1 = new Point(getPoint(0).getaX() * zoomX, getPoint(0).getaY());
		Point vP2 = new Point(getPoint(1).getaX() * zoomX, getPoint(1).getaY());
		Point vP3 = new Point(getPoint(2).getaX(), getPoint(2).getaY() * zoomX);
		Point vP4 = new Point(getPoint(3).getaX(), getPoint(3).getaY() * zoomX);
		changePoint(0, vP1);
		changePoint(1, vP2);
		changePoint(2, vP3);
		changePoint(3, vP4);
	  }
}
