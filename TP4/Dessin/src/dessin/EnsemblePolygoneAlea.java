
package dessin;

import java.util.Random;

public class EnsemblePolygoneAlea extends EnsemblePolygone
{

  public EnsemblePolygoneAlea () throws SommetNul{
    super (new Random().nextInt(101)); // nbPoly al�atoires entre 1 et 100
    String[] typesTab = {"Polygone", "Rectangle", "Quadrilat�re", "Triangle"};
    
    for (int i = 0; i < aTMax; i++) {
    	String vType = typesTab[new Random().nextInt(4)];
    	// Cr�ation Polygone
    	if (vType.equals("Polygone")) 
    		ajouterPolygone (new Polygone ((new Random().nextInt(11)) + 5)); // Entre 5 et 15 c�t�s
    	// Cr�ation Rectangle
    	if (vType.equals("Rectangle")) {
    		Point p1 = new Point ();
    		Point p2 = new Point ();
    		while (p1.getaX() == p2.getaX() && p1.getaY() == p2.getaY())
    			p2 = new Point ();
    		ajouterPolygone(new Rectangle (p1, p2));
    	}
    	// Cr�ation Quadrilat�re
    	if (vType.equals("Quadrilatere"))
    		ajouterPolygone (new Quadrilatere());
    	// Cr�ation Triangle
    	if (vType.equals("Triangle"))
    		ajouterPolygone (new Triangle (new Point(), new Point(), new Point()));
      }
    }
  }
