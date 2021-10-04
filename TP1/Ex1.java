public class Ex1{
    public static void main(String[] args){
    	if (args.length != 3){
            System.out.println("Il faut 3 arguments\n");
        }
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        System.out.printf("%d + %d + %d = %d\n", a, b, c, a+b+c);
    }
}