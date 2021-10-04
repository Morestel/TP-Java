package dessin;

import java.awt.Graphics;
import java.awt.Color;

public class Cercle extends FormeSurface implements Dessinable{
  
  public static final double PI = 3.14;
  public Point aCentre;
  public double aRayon;
  public static int aNbC = 0;
  public Color aCouleur = Dessinable.COULEUR;


  public Cercle(Point p, double pRayon) {
    this.aRayon = pRayon;
    aCentre = new Point();
    aCentre = p;
    aNbC++;
    aNumType = aNbC;
  }

 
  public Point getCentre() {
    return this.aCentre;
  }
  
  public double getRayon() {
    return this.aRayon;
  }

  public double perimetre() {
    return 2 * PI * aRayon;
  }
  
  public double surface() {
    return PI * aRayon * aRayon;
  }
  
  public boolean dedans(Point p) {
    return aRayon >= p.distance(aCentre);
  }
  
  public boolean plusGrand(Cercle pC) {
	  return this.surface() > pC.surface();
  }
  
  public void translater(double dx, double dy) {
    this.aCentre.setaX(aCentre.getaX() + dx);
    this.aCentre.setaY(aCentre.getaY() + dy);
  }
  
  public String toString() {
    return ("Point central =  " + aCentre + ", Rayon = " + aRayon + ", Surface = " + surface());
  }
  
  public void zoom(int zoomX) {
	  this.aRayon = this.aRayon * zoomX;
  }

  public void seDessiner(Graphics g) {
	  g.setColor(this.aCouleur);
	  g.drawOval((int)(aCentre.getaX() - aRayon), (int)(aCentre.getaY() - aRayon), (int)aRayon * 2, (int)aRayon * 2);
    g.setColor(Color.BLACK);
   // g.drawString(this.toString(),(int)aCentre.getaX(),(int)aCentre.getaY()); 
  }

  public Color getACouleur() {
    return this.aCouleur;
  }

  public void setACouleur(Color aCouleur) {
    this.aCouleur = aCouleur;
  }

}