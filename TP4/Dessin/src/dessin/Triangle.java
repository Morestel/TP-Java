package dessin;

public class Triangle extends Polygone{

	public int aNbT;
	
	public Triangle() {
		super(3);
		aNbT++;
		aNumType = aNbT;
	}
	
	public Triangle(Point p1, Point p2, Point p3) throws SommetNul{
		this();
		this.changePoint(0, p1);
		this.changePoint(1, p2);
		this.changePoint(2, p3);
		aNbT++;
		aNumType = aNbT;
	}
	
	@Override
	 public double surface () {
	    System.out.println("Calcul de la surface d'un triangle");
	    return super.surface();
	  }
}
