package mx.unam.ciencias;

/**
 * Clase para representar
 * un tablero y solucionar
 * el problema del adoquinamiento.
 */
public class Board {

    /**
     * Tablero
     */
    private String[][] board;

    /**
     * Dimesión de la cuadricula.
     * de m * m.
     * Donde m es una potencia de 2.
     */
    private int dimetion;

    /**
     * La cordenada y
     * del adoquin por defecto
     * del tablero.
     */
    private int cat1;
    /**
     * La cordenada x
     * del adoquin por defecto
     * del tablero.
     */
    private int cat2;

    /**
     * Constructor de un tablero.
     * 
     * @param k el exponente que hay que elevear 2
     *          para obtener la dimensión del tablero.
     */
    public Board(int k) {
        this.dimetion = MathUtils.pow(2, k);
        board = new String[dimetion][dimetion];
        cat1 = MathUtils.randomNum(0, dimetion - 1);
        cat2 = MathUtils.randomNum(0, dimetion - 1);
        board[cat1][cat2] = "#";
    }

    /**
     * Adoquina el tablero
     * con bloques de L.
     */
    public void cobble() {
        auxCobble(board, dimetion/2, dimetion /2, dimetion, cat1, cat2);
    }

    /**
     * Adoquina un tablero de forma
     * recursiva, divideindo siepre el tablero
     * en 4 tableros más pequeños.
     * @param board el tablero a adoquinar.
     * @param yCenter La cordenada y del centro 
     * del tablero.
     * @param xCenter La cordenada x del centro 
     * del tablero.
     * @param dimention La domensión del tablero.
     * @param cat1 La cordenada y del adoquin
     * ya dado.
     * @param cat2 La cordenada x del adoquin
     * ya dado.
     */
    private void auxCobble(String[][] board, int yCenter, int xCenter, int dimention, int cat1, int cat2) {
        if (dimention == 1)
            return;

        if (cat1 < yCenter && cat2 < xCenter) {
            board[yCenter - 1][xCenter] = "|";
            board[yCenter][xCenter] = "|";
            board[yCenter][xCenter - 1] = "-";
            auxCobble(board, yCenter - (dimention / 4), xCenter - (dimention / 4), dimention / 2, cat1, cat2);
            auxCobble(board, yCenter - (dimention / 4), xCenter + (dimention / 4), dimention / 2, yCenter - 1, xCenter);
            auxCobble(board, yCenter + (dimention / 4), xCenter - (dimention / 4), dimention / 2, yCenter, xCenter - 1);
            auxCobble(board, yCenter + (dimention / 4), xCenter +  (dimention / 4), dimention / 2, yCenter, xCenter);

        } else if (cat1 < yCenter && cat2 >= xCenter) {
            board[yCenter - 1][xCenter - 1] = "|";
            board[yCenter][xCenter - 1] = "|";
            board[yCenter][xCenter] = "-";

            auxCobble(board, yCenter - (dimention / 4), xCenter - (dimention / 4), dimention / 2, yCenter - 1, xCenter - 1);
            auxCobble(board, yCenter - (dimention / 4), xCenter + (dimention / 4), dimention / 2, cat1, cat2);
            auxCobble(board, yCenter + (dimention / 4), xCenter - (dimention / 4), dimention / 2, yCenter, xCenter - 1);
            auxCobble(board, yCenter + (dimention / 4), xCenter +  (dimention / 4), dimention / 2, yCenter, xCenter);

        } else if (cat1 >= yCenter && cat2 < xCenter) {
            board[yCenter - 1][xCenter - 1] = "-";
            board[yCenter - 1][xCenter] = "|";
            board[yCenter][xCenter] = "|";

            auxCobble(board, yCenter - (dimention / 4), xCenter - (dimention / 4), dimention / 2, yCenter - 1, xCenter - 1);
            auxCobble(board, yCenter - (dimention / 4), xCenter + (dimention / 4), dimention / 2, yCenter - 1, xCenter);
            auxCobble(board, yCenter + (dimention / 4), xCenter - (dimention / 4), dimention / 2, cat1, cat2);
            auxCobble(board, yCenter + (dimention / 4), xCenter +  (dimention / 4), dimention / 2, yCenter, xCenter);

        } else {
            board[yCenter - 1][xCenter - 1] = "|";
            board[yCenter][xCenter - 1] = "|";
            board[yCenter - 1][xCenter] = "-";
        
            auxCobble(board, yCenter - (dimention / 4), xCenter - (dimention / 4), dimention / 2, yCenter - 1, xCenter - 1);
            auxCobble(board, yCenter - (dimention / 4), xCenter + (dimention / 4), dimention / 2, yCenter - 1, xCenter);
            auxCobble(board, yCenter + (dimention / 4), xCenter - (dimention / 4), dimention / 2, yCenter, xCenter - 1);
            auxCobble(board, yCenter + (dimention / 4), xCenter +  (dimention / 4), dimention / 2, cat1, cat2);

        }
    }

    /**
     * Imprime el contenido del tablero.
     */
    public void prinString() {
        for (int i = 0; i < dimetion; i++) {
            System.out.print("\t");
            for (int j = 0; j < dimetion; j++) {
                String chart = board[i][j];
                if (chart == null)
                    System.out.print("*");
                else if (chart.equals("#"))
                    System.out.print("#");
                else
                    System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    
}
