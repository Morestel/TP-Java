public class tableau{
    /**
       26/09/2020
       Ce programme permet de connaître si un nombre (donné en paramètre) est dans un tableau prédéfini.
       @param String[] args 
       Le paramètre est un nombre, le programme vérifiera s'il est dans le tableau ou non
       @return Si le nombre est dans le tableau
       @author MORESTEL Thomas
     */
    public static void main(String[] args){

        if (args.length != 1){
            System.out.println("Usage: <entier>");
            return;
        }

        int[] tab = {2, 4, 6, 9, 12, 13, 24, 76} ;
        int n = tab.length;
        int search = Integer.parseInt(args[0]);
        
        for(int i = 0; i < n; i++){
            if(search == tab[i]){
                System.out.println(search+" est dans le tableau. Position:" + (i+1));
                return;
            }
        }
        System.out.println(search+" est introuvable dans le tableau");
    }
}