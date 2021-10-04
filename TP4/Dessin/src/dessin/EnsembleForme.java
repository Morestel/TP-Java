package dessin;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;


public class EnsembleForme{
	protected int aTMax;
	protected int aPlace; // place restante dans l'ensemble
	protected Forme[] aForme;
	  
	public EnsembleForme(int pTMax) {
		if (pTMax < 0)
			throw new InternalError("Valeur négative non autorisée");
		else{
	    	aTMax = pTMax;
	    	aForme = new Forme[pTMax];
			aPlace = pTMax;
		}	
	}
	public void ajouterForme(Forme pF) {
		if (aPlace > 0) {
		  this.aForme[aTMax - aPlace] = pF;
		  aPlace --;
		}
		else{
			int i = new Random().nextInt(aTMax);
			this.aForme[i] = pF;
		}
	}
	
	public double sommePerimetres () {
	    double somme = 0.0d;
	    for (int i = 0; i < aTMax; i++)
	      somme += aForme[i].perimetre();   
	    return somme;
	  }
	
	public void affiche () {
		System.out.println("Affichage ensemble des formes");
	    for (int i = 0; i < this.aForme.length; i++)
	    	System.out.println(aForme[i]);
	  }
	
	public double sommeSurface () {
		  double somme = 0.0;
		  for (int i = 0; i < aTMax; i++)
			  if (((Polygone) aForme[i]).estConvexe())
			  		somme += aForme[i].surface();
		  return somme;
	}
	
	public void zoomZoomable(int zoomX) throws SommetNul{
		int placeDroit = this.aTMax - this.aPlace; 
		for (int i = 0; i < placeDroit; i++) {
			this.aForme[i].zoom(zoomX);
		}
	}

	public void toutDessiner(Graphics g){
		for (int i = 0; i < aForme.length; i++){
			aForme[i].seDessiner(g);
		}
	}

	public void changeCouleur(){
		Color[] vColors = {Color.BLUE,Color.CYAN,Color.RED,Color.GREEN,Color.MAGENTA,Color.ORANGE,Color.YELLOW};
		int i = 0;
		for(Forme vForme : this.aForme){
			if(i == 7)i=0;
			vForme.setACouleur(vColors[i]);
			i++;
		}
	}

	public void accesForme(int i){
		try{
			System.out.println(this.aForme[i]);
		} catch(IndexOutOfBoundsException e){
			System.out.println("Index hors du tableau");
		}
	}
}
