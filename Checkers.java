public class Checkers {
    public static Piece[][] game;
    public static void main(String[] args) {
        game = new Piece[10][10];
//        Checkers checkers = new Checkers();
        setupKing();
        setupMan();
        setupEmpty();
        printArray();
    }
    public static void setupKing()
    {
        setUp(0, 3, "king");
    }

    public static void setupMan()
    {
        setUp(6, 9, "man");
    }
    public static void setupEmpty()
    {
        setUp(3, 6, "empty");
    }
    public static void setUp(int startRow, int endRow, String typeOf){
        for (int i = startRow; i<endRow ; i++){
            for (int j = 0; j<9; j++){
                if (isItGameTable(i, j)) {
                    try {
                        if (typeOf == "man") {
                            game[i][j] = new Man();
                        } else if (typeOf == "king") {
                            game[i][j] = new King();
                        } else if (typeOf == "empty") {
                            game[i][j] = new Empty();
                        }
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                }
            }
        }
    }
    public static void printArray() {
        for (int i = 0; i<9 ; i++){
            System.out.print(i + "|");
            for (int j = 0; j<9; j++){
                if (isItGameTable(i, j)) {
                    try {
                        System.out.print("\t" + game[i][j].getName());
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                } else {
                    System.out.print("\t-");
                }
            }
            System.out.print("\n");
        }
    }
    public static boolean isItGameTable (int i, int j)
    {
        if ((i%2 == 0 && j%2 != 0) || (i%2 != 0 && j%2 == 0)) return true;
        else return false;
    }
}
