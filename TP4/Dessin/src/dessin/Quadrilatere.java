package dessin;

public class Quadrilatere extends Polygone{

	public int aNbQ;
	
	public Quadrilatere(Point p1, Point p2, Point p3, Point p4) throws SommetNul{
		this();
		this.changePoint(0,p1);
		this.changePoint(1,p2);
		this.changePoint(2,p3);
		this.changePoint(3,p4);
		aNbQ++;
		aNumType = aNbQ;
	}
	
	public Quadrilatere() {
		super(4);
	}

	@Override
	 public double surface () {
	    System.out.println("Calcul de la surface d'un quadrilatere");
	    return super.surface();
	  }
}
