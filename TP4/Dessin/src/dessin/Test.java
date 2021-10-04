package dessin;

public class Test {
public static void main(String[] args) throws SommetNul{
		
		// D�claration
		// Points
		Point p1 = new Point(Math.random()*300,Math.random()*300);
		Point p2 = new Point(Math.random()*300, Math.random()*300);
		Point p3 = new Point(1, 0);
		Point p4 = new Point(50, 50);
		Point p5 = new Point(80, 10);
		Point p6 = new Point(1, 0);
		Point p7 = new Point(25, 30);
		Point p8 = new Point(40, 10);
		Point p9 = new Point(10, 5);
		Point p10 = new Point(90, 50);
		Point p11 = new Point(80, 20);
		Point p12 = new Point(12, 6);
		Point p13 = new Point(3, 50);
		Point p14 = new Point(10, 10);
		Point p15 = new Point();
	
		// Polygone
		
		Polygone a1 = new Polygone(4);
				
		// Triangle
		Triangle t1 = new Triangle(p4, p5, p6);
		System.out.println("Affichage triangle");
		System.out.println(t1);
		
		// Quadrilat�re
		Quadrilatere q1 = new Quadrilatere();
		q1.changePoint(0, p7);
		q1.changePoint(1, p8);
		q1.changePoint(2, p9);
		q1.changePoint(3, p10);
		System.out.println("Surface de q1: "+q1.surface());
		
		// Rectangle
		Point pr1 = new Point(10, 50);
		Point pr2 = new Point(50, 10);
		Rectangle r1 = new Rectangle(p4, p5);
		Rectangle r2 = new Rectangle(pr1, pr2);
		System.out.println("Surface de r1: "+r1.surface());
		r1.zoom(5);
		
		// Test 
		//Point
		System.out.println(p1);
		System.out.println(p2);
		System.out.println("Distance de p1 � p2 " + p1.distance(p2));
		System.out.println("Distance de p1 � l'origine " + p1.distance());
		System.out.println("Distance de p2 � l'origine " + p2.distance());
		
		// Polygone
		
		System.out.println("P�rim�tre de a1:"+ a1.perimetre());
		a1.changePoint(0, p11);
		a1.changePoint(1, p12);
		a1.changePoint(2, p13);
		a1.changePoint(3, p14);
		System.out.println("Nouveau p�rim�tre de a1: "+ a1.perimetre());
		System.out.println(a1.dedans(p11));
		System.out.println("t1 plus grand que a1 ? "+t1.plusGrand(a1));
		a1.translater(0, 4);
		System.out.println(a1.toString());
		
		
		// Triangle
		System.out.println("P�rim�tre de t1:"+t1.perimetre());
		t1.changePoint(0, p15);
		t1.changePoint(1, p3);
		System.out.println("Surface de t1: " + t1.surface());
		Polygone t2 = new Triangle(p7, p8, p9);
		System.out.println("t2 plus grand que r1 ? "+t2.plusGrand(r1));
		
		/* Agr�gation faible: Les points sont cr��s � l'ext�rieur du polygone */
		
		
		// Polymorphisme
		System.out.println("Convexit� de t1: " + t1.estConvexe());
		System.out.println("Convexit� de r2: " + r2.estConvexe());
		
		
		
		// Ensemble Polygone
		EnsemblePolygone ensP = new EnsemblePolygone(5);
		ensP.ajouterPolygone(r1);
		ensP.ajouterPolygone(t1);
		ensP.ajouterPolygone(r2);
		ensP.ajouterPolygone(a1);
		ensP.affiche();
		
		// EnsemblePolygoneAlea
		System.out.println("Ensemble Polygone Al�atoire");
		EnsemblePolygoneAlea ensPA = new EnsemblePolygoneAlea();
		ensPA.affiche();
	
		
		
		// Cercle
		Cercle c1 = new Cercle(p1, 10);
		Cercle c2 = new Cercle(p2, 18);
		System.out.println(c1);
		System.out.println(c1.plusGrand(c2));
		System.out.println(c1.perimetre());
		System.out.println(c1.dedans(p2));
		System.out.println(c1.dedans(p1));
		c1.zoom(8);
		System.out.println(c1);


		// EnsembleFormeAleatoire
		System.out.println("Forme Aléatoire");
		EnsembleFormeAlea ensFA = new EnsembleFormeAlea(20);
		ensFA.affiche();

		// Exception
		EnsembleForme ensF = new EnsembleForme(10);
		for (int k = 0; k < 12; k++){
			ensF.ajouterForme(new Cercle(new Point(), k));
		}
		ensF.affiche();
		// Doit marcher
		ensF.accesForme(5);
		// Ne devrait pas marcher
		ensF.accesForme(12);

		Point p100 = new Point(0, 0);
		try{
			t1.changePoint(1, p100);
		}catch(SommetNul pE){
			System.out.println("Exception: "+pE);
			pE.printStackTrace();
		}
	}	
}

