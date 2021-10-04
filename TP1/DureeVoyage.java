public class DureeVoyage{
    public static void main(String[] args){
        if (args.length != 4){
            System.out.println("Il faut 4 arguments\n");
        }
        int heure1 = Integer.parseInt(args[0]);
        int minute1 = Integer.parseInt(args[1]);
        int heure2 = Integer.parseInt(args[2]);
        int minute2 = Integer.parseInt(args[3]);
        if ((heure1 < 0 || heure1 >= 24) || (heure2 < 0 || heure2 >= 24) || (minute1 < 0 || minute1 >= 60) || (minute2 < 0 || minute2 >= 60)){
                System.out.println("Horaires non valables\n");
            }
        else{
            int heure_t = 0;
            int minute_t = 0;
            if (minute2 >= minute1){
                heure_t = (heure2 - heure1)%24;
                minute_t = (minute2 - minute1)%60;
            }
            else{
                heure_t = (heure2 - heure1 - 1)%24;
                minute_t = (minute2 + 60 - minute1)%60;
            }
            System.out.println("Durée du voyage: "+heure_t+"h"+minute_t+" (De " +heure1+ "h"+minute1+" à "+heure2+"h"+minute2+")\n");
        }

    }
}