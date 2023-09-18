package mx.unam.ciencias;

public class Main {
    public static void main(String[] args) {     
        
        if (args.length != 1)
            use();

        int k = 0;
        try {
            k = Integer.parseInt(args[0]); 
        } catch (NumberFormatException e) {
            use();
        }
    
        if (k < 0)
            use();
        
        Board board = new Board(k);
        board.cobble();
        board.prinString();
    }

    private static void use() {
        System.out.println("---Uso---");
        System.out.println("java -jar tar target/programa1.jar [k]");
        System.out.println("Donde: [k] es un núemro entero positivo.");
        System.exit(1);
    }
}