package dessin;
import java.awt.Graphics;
import java.awt.Color;

public class Polygone extends FormeSurface implements Dessinable{
	public final int aCotes;
	public Point[] aSommets;
	public int aNbP;
	public Color aCouleur = Dessinable.COULEUR;
	
	public Polygone(int pCotes) {
		if(pCotes < 3) throw new InternalError("Un polygone a minimum 3 côtés");
		else
			this.aCotes = pCotes;
		this.aSommets = new Point[this.aCotes];
		for(int i = 0 ; i < this.aCotes ; i++)
			this.aSommets[i] = new Point();
		aNbP++;
		aNumType = aNbP;
	}
		
	public int nbrCotes() {
		return this.aCotes;
	}
	
	public Point getPoint(int n) {
		return this.aSommets[n];
	}
	
	public void changePoint(int n, Point pP) throws SommetNul {
		if (pP.getaX() == 0 && pP.getaY() == 0){
			throw new SommetNul("Sommet Nul");
		}
		else{
			this.aSommets[n] = pP;
		}
	}
	
	public double perimetre() {
		int i;
		int n = this.aCotes;
		double resultat = 0;
		for (i = 0; i < n-1; i++) {
			resultat += getPoint(i).distance(getPoint(i+1));
		}
		resultat += getPoint(n-1).distance(getPoint(0));
		return resultat;
	}
	
	public double surface() {
		double s;
		double surface = 0;
		for(int i = 2 ; i < aCotes ; i++) {
			s = ( getPoint(0).distance(getPoint(i-1)) + getPoint(i-1).distance(getPoint(i)) + getPoint(0).distance(getPoint(i)) )/2;
			surface += Math.sqrt( s * (s - getPoint(0).distance(getPoint(i-1))) * (s - getPoint(i-1).distance(getPoint(i))) * (s - getPoint(0).distance(getPoint(i))) );
		}
		if (!(this.estConvexe()))
			surface = -1;
		return surface;
	}
	
	@Override
	public String toString() {
		int i;
		String str = "<"+ getClass().getSimpleName() +">: ";
		for (i = 0; i < nbrCotes()-1; i++)
			str += new StringBuilder(getPoint(i).toString() + ", ");
		str += getPoint(i).toString();
		//str += "\nSurface : ";
		//str += this.surface();
		return str;
	 }	
	
	public boolean estConvexe() {
		int i;
		int n = this.nbrCotes();
		boolean vrai = true;
		if (n == 3) return true; // Un triangle est toujours convexe
		int vAvant;
		int vApres;
		for (i = 0; i < n; i++) {
			vAvant = (i - 1) % n;
			vApres = (i + 1) % n;
			if (i == 0) vAvant = n - 1; // Le point avant le premier est le dernier du tableau
			
			if (getPoint(i).signeAngle(getPoint(vAvant), getPoint(vApres)) != Point.SIAM) vrai = false;
		}
		return vrai;
	}
	
	 public boolean dedans(Point pP) {
	   boolean dedans = false;
	   if (this.estConvexe()) {
		   for (int i = 0; i < this.nbrCotes(); i++) {
			   if (getPoint(i) == pP)
				   dedans = true;
		   }
	   }
	    return dedans;
	  }
	 
	 public boolean plusGrand(Polygone pPoly) {
		if (this.surface() > pPoly.surface()) return true; // Plus grand on retourne vrai
		else return false; // Plus petit ou �gal on retourne faux
	 }
	 
	 public void translater(double dx, double dy) throws SommetNul{
	    for (int i = 0; i < nbrCotes(); i++){
	    	Point vP1 = new Point(getPoint(i).getaX() + dx, getPoint(i).getaY() + dy);
	    	changePoint(i, vP1);
	    }
	 }

	 @Override
	 public void seDessiner(Graphics g){
		int j;
		int n = this.nbrCotes();
		g.setColor(this.aCouleur);
		for (int i = 0; i < n; i++){
			if (i+1 >= n)
				j = 0;
			else
				j = i + 1;
			g.drawLine((int)getPoint(i).getaX(), (int)getPoint(i).getaY(), (int)getPoint(j).getaX(), (int)getPoint(j).getaY());
			 
		}
		 g.setColor(Color.BLACK);
		 g.drawString(this.toString(),(int)this.aSommets[0].getaX(),(int)this.aSommets[0].getaY()); 
	 }

	 @Override
	 public void zoom(int pZoomx) throws SommetNul{
		for(int i = 0; i < this.aSommets.length;i++){
			this.aSommets[i].setaX(this.aSommets[i].getaX()*pZoomx);
			this.aSommets[i].setaY(this.aSommets[i].getaY()*pZoomx);
		}
	 }

	 public Color getACouleur() {
		return this.aCouleur;
	  }
	
	  public void setACouleur(Color aCouleur) {
		this.aCouleur = aCouleur;
	  }
}

