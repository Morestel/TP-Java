package dessin;
import java.util.Random;

public class EnsembleFormeAlea extends EnsembleForme{
	
	 public EnsembleFormeAlea () throws SommetNul{
		this(new Random().nextInt(101));
	}
			  
	public EnsembleFormeAlea (int n) throws SommetNul{
			super (n); // nbPoly al�atoires entre 1 et n
			String[] typesTab = {"Polygone", "Rectangle", "Quadrilatere", "Triangle", "Cercle"};
				
			for (int i = 0; i < n; i++) {
				String vType = typesTab[new Random().nextInt(5)];
					// Cr�ation Polygone
				if (vType.equals("Polygone")){ 
					ajouterForme((new Polygone ((new Random().nextInt(11)) + 5))); // Entre 5 et 15 c�t�s
				}
					// Cr�ation Rectangle
				if (vType.equals("Rectangle")) {
					Point p1 = new Point ();
					Point p2 = new Point ();
					ajouterForme(new Rectangle (p1, p2));
				}
						// Cr�ation Quadrilat�re
				if (vType.equals("Quadrilatere"))					
					ajouterForme(new Quadrilatere());
					
					// Cr�ation Triangle
				if (vType.equals("Triangle"))
					ajouterForme(new Triangle (new Point(), new Point(), new Point()));
					
					// Cr�ation Cercle
				if (vType.equals("Cercle"))
					ajouterForme(new Cercle(new Point(), new Random().nextInt(101)));
			}//end for
	}

	public void ajouterFormeAlea() throws SommetNul{
		String[] typesTab = {"Polygone", "Rectangle", "Quadrilatere", "Triangle", "Cercle"};
		String vType = typesTab[new Random().nextInt(5)];
				// Cr�ation Polygone
		if (vType.equals("Polygone")){ 
			ajouterForme((new Polygone ((new Random().nextInt(11)) + 5))); // Entre 5 et 15 c�t�s
		}
					// Cr�ation Rectangle
		if (vType.equals("Rectangle")) {
			Point p1 = new Point ();
			Point p2 = new Point ();
			ajouterForme(new Rectangle (p1, p2));
		}
										// Cr�ation Quadrilat�re
		if (vType.equals("Quadrilatere"))					
			ajouterForme(new Quadrilatere());
					
					// Cr�ation Triangle
		if (vType.equals("Triangle"))
			ajouterForme(new Triangle (new Point(), new Point(), new Point()));
					
					// Cr�ation Cercle	
		if (vType.equals("Cercle"))
			ajouterForme(new Cercle(new Point(), new Random().nextInt(101)));
					
	}
}
