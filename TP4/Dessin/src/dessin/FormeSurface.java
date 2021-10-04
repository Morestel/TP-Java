package dessin;

public abstract class FormeSurface implements Forme, Comparable{

	public static int nbrForme = 0; 
	private final int aNumForme;
	protected int aNumType;

	protected FormeSurface() {
		nbrForme++;
		aNumForme = nbrForme;
	}
		  
	public boolean plusGrand(Forme pC) {
		return this.surface() > pC.surface();
	}

	  public String toString() {
			  return "Forme (n� " + aNumForme + "), " + this.getClass().getName() + "(n� " + aNumType + ") : ";
	  }	
	  
	  public int compareTo(Object o) {
		  FormeSurface f = (FormeSurface)o;
		  double vSurface = this.surface() - f.surface();
		  if (vSurface < 0)
			  return -1;
		  else if (vSurface == 0)
			  return 0;
		  else
			  return 1;
	  }

}
