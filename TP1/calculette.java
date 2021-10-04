public class calculette{
    public static void main(String[] args){
        if (args.length != 3){
            System.out.println("3 arguments nécessaires: <entie1r> <op> <entier2>\n");
        }
        int entier1 = Integer.parseInt(args[0]);
        String op1 = args[1];
        char op= op1.charAt(0);
        int entier2 = Integer.parseInt(args[2]);
        switch(op){
        case '+':
            System.out.printf("%d + %d = %d\n", entier1, entier2, entier1 + entier2);
            break;
        case '-':
            System.out.printf("%d - %d = %d\n", entier1, entier2, entier1 - entier2);
            break;
        case 'x':
            System.out.printf("%d * %d = %d\n", entier1, entier2, entier1 * entier2);
            break;
        case '/':
            if (entier2 == 0)  System.out.println("Division par 0 interdite\n");
            else
            System.out.printf("%d / %d = %d\n", entier1, entier2, entier1 / entier2);
            break;
        default:
            System.out.println("Opération inconnue au bataillon\n");
            break;
            
        }


    }
}