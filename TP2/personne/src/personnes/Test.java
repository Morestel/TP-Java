package personnes;

import java.util.GregorianCalendar;

public class Test {
    
    public static void main(String[] args){
        GregorianCalendar vDateP1 = new GregorianCalendar(1999,01,28);
        GregorianCalendar vDateP2 = new GregorianCalendar(2005,07,16);
        GregorianCalendar vDateP3 = new GregorianCalendar(2000, 06, 12);
        Personne p1 = new Personne('h',"Thomas","Gates",vDateP1);
        Personne p2 = new Personne('f',"Tomasinne","Gates",vDateP2, Personne.MARIE, "Polnareff");
        Personne p3 = new Personne(Personne.FEMME, "Elize", "Trucu", vDateP3, Personne.CELIBATAIRE);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1.age(2020));
        System.out.println(p2.plusJeune(p1));
        System.out.println(p3);
        p1.marier(p3);
        System.out.println(p3);

        Personne a1 = new Personne(Personne.FEMME, "Elize", "Trucu");
        Personne a2 = new Personne(Personne.HOMME, "Eric", "Trucu");
        Personne a3 = new Personne(Personne.FEMME, "Sofia", "Doule");
        Personne a4 = new Personne(Personne.HOMME, "Patrick", "Trucu", a2, a1);
        Personne a5 = new Personne(Personne.FEMME, "Abib", "Trucu", a4, a3);
        Personne a6 = new Personne(Personne.HOMME, "Denis", "Tae");
        Personne a7 = new Personne(Personne.FEMME, "Danielle", "Trucu", a6, a5);
        Personne a8 = new Personne(Personne.HOMME, "Jean", "Valj");
        Personne a9 = new Personne(Personne.FEMME, "Giselle", "Trucu", a8, a7);
        Personne a10 = new Personne(Personne.HOMME, "Rick", "Pop");
        Personne a11 = new Personne(Personne.FEMME, "Lise", "Tzd");
        Personne a12 = new Personne(Personne.HOMME, "Louis", "Trucu", a10, a9);
        Personne a13 = new Personne(Personne.FEMME, "Jeanne", "Trucu", a12, a11);
        Personne a14 = new Personne(Personne.HOMME, "Marin", "Pup");
        Personne a15 = new Personne(Personne.HOMME, "Hugo", "Rous", a14, a13);
    
        System.out.println(p1.estAncetre(a15));
        System.out.println(a15.estAncetre(a1));
        System.out.println(a1.estAncetre(a15));
        a15.arbreGenealogique();
    }
}
