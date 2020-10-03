

import java.util.GregorianCalendar;

    
public class Personne {
    
        private GregorianCalendar aDate;
        private String aNom;
        private String aPrenom;
        private char aSexe;
        private char aSituation;
        public static char CELIBATAIRE = 'C';
        public static char MARIE = 'M';
        public static char HOMME = 'H';
        public static char FEMME = 'F';
        public String aNomJF;
        private Personne aConjoint;
        private int aNUM_PERSONNE;
        private static int attribution = 1;
        private Personne aPere;
        private Personne aMere;
        private int i = 1;

        private Personne(final String pNom,final String pPrenom){
            this.aNUM_PERSONNE = attribution;
            attribution ++;
            this.aMere = null;
            this.aPere = null;
            this.aNom = pNom;
            this.aPrenom = pPrenom;
        }

        public Personne(final char pSexe, final String pPrenom, final String pNom){
            this.aNUM_PERSONNE = attribution;
            attribution ++;
            this.aNom = pNom;
            this.aPrenom = pPrenom;
            this.aSexe = pSexe;
        }

        public Personne(final char pSexe, final String pPrenom,final String pNom, final Personne pPere, final Personne pMere){
            this.aNUM_PERSONNE = attribution;
            attribution ++;
            this.aNom = pNom;
            this.aPrenom = pPrenom;
            this.aMere = pMere;
            this.aPere = pPere;
            this.aSexe = pSexe;
        }

        private Personne(final GregorianCalendar pDate, final String pNom,final String pPrenom){
            this.aNUM_PERSONNE = attribution;
            attribution ++;
            this.aMere = null;
            this.aPere = null;
            this.aPrenom = pPrenom;
            this.aNom = pNom;
            this.aDate = pDate;
        }

        public Personne(final char pSexe, final String pPrenom,final String pNom, final GregorianCalendar pDate){
            this.aNUM_PERSONNE = attribution;
            attribution ++;
            this.aMere = null;
            this.aPere = null;
            this.aPrenom = pPrenom;
            this.aNom = pNom;
            this.aDate = pDate;
            this.aSexe = pSexe;
        }

        public Personne(final char pSexe, final String pPrenom, final String pNom, final GregorianCalendar pDate, final char pSituation){
            this.aNUM_PERSONNE = attribution;
            attribution ++;
            this.aMere = null;
            this.aPere = null;
            this.aPrenom = pPrenom;
            this.aNom = pNom;
            this.aDate = pDate;
            this.aSexe = pSexe;
            this.aSituation = pSituation;
        }

        public Personne(final char pSexe, final String pPrenom, final String pNom, final GregorianCalendar pDate, final char pSituation, final String pNomJF){
            this.aNUM_PERSONNE = attribution;
            attribution ++;
            this.aMere = null;
            this.aPere = null;
            this.aPrenom = pPrenom;
            this.aNom = pNom;
            this.aDate = pDate;
            this.aSexe = pSexe;
            this.aSituation = pSituation;
            this.aNomJF = pNomJF;
        }
        public String getNom(){
            return this.aNom;
        }

        public void setNom(final String pNom){
            this.aNom = pNom;
        }

        public String getAPrenom() {
            return this.aPrenom;
        }

        public void setAPrenom(String aPrenom) {
            this.aPrenom = aPrenom;
        }

        public char getASexe() {
            return this.aSexe;
        }

        public void setASexe(char aSexe) {
            this.aSexe = aSexe;
        }

        public GregorianCalendar getADate() {
            return this.aDate;
        }
    
        public void setADate(GregorianCalendar aDate) {
            this.aDate = aDate;
        }

        public void setSituation(char aSituation){
            this.aSituation = aSituation;
        }

        public char getSituation(){
            return this.aSituation;
        }

        public void setNomJF(String aNomJF){
            this.aNomJF = aNomJF;
        }

        public String getNomJF(){
            return this.aNomJF;
        }

        public void setConjoint(Personne aConjoint){
            this.aConjoint = aConjoint;
        }

        public Personne getConjoint(){
            return this.aConjoint;
        }

        public void setNUM_PERSONNE(int aNUM_PERSONNE){
            this.aNUM_PERSONNE = aNUM_PERSONNE;
        }

        public int getNUM_PERSONNE(){
            return this.aNUM_PERSONNE;
        }

        public void setPere(Personne aPere){
            this.aPere = aPere;
        }

        public Personne getPere(){
            return this.aPere;
        }

        public void setMere(Personne aMere){
            this.aMere = aMere;
        }

        public Personne getMere(){
            return this.aMere;
        }

        public String toString(){
            String vResultString = "";
            if(this.aSexe == 'h') 
                vResultString += "Monsieur "  + this.aPrenom + " " + this.aNom + " née en " + this.aDate.getWeekYear();
            else{ 
                if(this.aSituation == 'M')
                     vResultString += "Madame " + this.aPrenom + " " + this.aNom + " (née " +this.aNomJF + "), " + " née en " + this.aDate.getWeekYear() + ", mariée";
                else
                    vResultString += "Madame "  + this.aPrenom + " " + this.aNom + " née en " + this.aDate.getWeekYear();
            }
            return vResultString;
        }
        public int age(int AnneeCourante) {
            return AnneeCourante - this.aDate.getWeekYear();
        }
        public boolean plusJeune(Personne p) {
            if (this.aDate.getWeekYear() > p.aDate.getWeekYear())
                return true;
            else 
                return false;
            
        }
        public void marier(Personne p){
            if (this.aSituation != MARIE && p.aSituation != MARIE){
                this.aSituation = MARIE;
                p.aSituation = MARIE;
                this.aConjoint = p;
                p.aConjoint = this;
                if (this.aSexe == FEMME){
                    this.aNomJF = this.aNom;
                    this.aNom = p.aNom;
                }
                else{
                    p.aNomJF = p.aNom;
                    p.aNom = this.aNom;
                }
           }
        }
        
        public boolean estAncetre(Personne p){              
            if (p != null){
                if (p.getPere() != null){
                    if (this == p.getPere() || estAncetre(p.getPere()))
                        return true;
                }
                if (p.getMere() != null){
                    if (this == p.getMere() || estAncetre(p.getMere()))
                        return true;
                }
            }
            return false;
            
        }
     
        public void afficheBlanc(int i){
            System.out.printf(" ");
        }

        public void arbreGenealogique(){
            System.out.println(this.aPrenom +" "+this.aNom);
            afficheBlanc(i);
            i +=1;
            if (this.getPere() != null)
                getPere().arbreGenealogique();
            if (this.getMere() != null)
                getMere().arbreGenealogique();

        }
            
}