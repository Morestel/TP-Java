public class Factorielle{
    public static void main(String[] args){
        if (args.length != 1){
            System.out.println("Usage: <entier>");
            return;
        }

        int facto = Integer.parseInt(args[0]);
        int resultat = 1;
        for(int i = 1; i <= facto; i++)
            resultat = resultat * i;

        System.out.println("Factorielle de "+args[0]+" = "+resultat);
    }
}