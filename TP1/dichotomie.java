public class dichotomie{
    public static void main(String[] args){
        
        if (args.length != 1){
            System.out.println("Usage: <entier>");
            return;
        }

        int[] tab = {2, 4, 6, 9, 12, 13, 24, 76} ;
        int n = tab.length;
        int search = Integer.parseInt(args[0]);
        boolean finish = false;
        int start = 0;
        int mid = (n-1)/2;
        int end = n-1;
        int resultat = -1;
        
        while(!finish){
            if(search == tab[mid]){
                resultat = mid;
                finish = true;
                break;
            }
            if(start == mid || end == mid){
                finish = true;
                break;
            }

            if(search < tab[mid]){
                    end = mid;
                    mid = (start + end)/2;
            }
            else{
                start = mid;
                mid = (start + end)/2;
            }
        }
        if(resultat == -1){
            System.out.println(search+" est introuvable dans le tableau");
            return;
        }
        System.out.println(search+" est dans le tableau. Position:" + (resultat+1));
    }
}