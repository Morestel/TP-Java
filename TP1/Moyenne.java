public class Moyenne{
    public static void main(String[] args){
        if (args.length < 2){
            System.out.println("Il faut au moins 2 arguments\n");
        }
        int nbDeNotes = args.length;
        int[] tabNote = new int[nbDeNotes];
        int totalNote = 0;

        for(int i = 0; i < nbDeNotes; i++)
            tabNote[i] = Integer.parseInt(args[i]);

        for(int i = 0; i < nbDeNotes; i++){
            if(!(tabNote[i] >= 0 && tabNote[i] <= 20)){
                System.out.println("Note entre 0 et 20");
                return;
            }
            totalNote += tabNote[i];
        }
        double moyenne = (double) totalNote/nbDeNotes;
        System.out.println("Moyenne des " + nbDeNotes + " notes : " + moyenne);
    }
}