package dessin;

public class EnsemblePolygone{
  protected int aTMax;
  protected int aPlace; // place restante dans l'ensemble
  protected Polygone[] aPolygones;
  
  public EnsemblePolygone (int pTMax) {
  if (pTMax < 0) {
    throw new InternalError("La taille ne peut pas �tre n�gative");
  }
  else{
    aTMax = pTMax;
    aPolygones = new Polygone[pTMax];
    aPlace = pTMax;
  }
  }
  
  public void ajouterPolygone (Polygone pol) {
    if (aPlace > 0) {
      this.aPolygones[aTMax - aPlace] = pol;
      aPlace --;
    }
    else
      System.out.println("Plus de place");
  }

  public double  sommePerimetres () {
    double somme = 0.0d;
    for (int i = 0; i < aTMax; i++)
      somme += aPolygones[i].perimetre();   
    return somme;
  }

  public void affiche () {
	System.out.println("Affichage ensemble des polygones");
    for (int i = 0; i < this.aPolygones.length; i++)
    	System.out.println(aPolygones[i]);
  }


  public double sommeSurface () {
	  double somme = 0.0;
	  for (int i = 0; i < aTMax; i++)
		  if (aPolygones[i].estConvexe())
	  		somme += aPolygones[i].surface();
	  return somme;
}
}