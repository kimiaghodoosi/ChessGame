
public class Board {

    static Pieces p[][] = new Pieces[8][8];

    public Board() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 1) {
                    p[i][j] = new Soldier(i, j, "white", true);
                } else if (i == 6) {
                    p[i][j] = new Soldier(i, j, "black", true);
                } else {
                    p[i][j] = new Pieces(i, j);
                }
                if (i == 0 && (j == 0 | j == 7)) {
                    p[i][j] = new Rook(i, j, "white", true);
                }
                if (i == 7 && (j == 0 | j == 7)) {
                    p[i][j] = new Rook(i, j, "black", true);
                }
                if (i == 0 && (j == 2 || j == 5)) {
                    p[i][j] = new Bishop(i, j, "white", true);
                }
                if (i == 7 && (j == 2 || j == 5)) {
                    p[i][j] = new Bishop(i, j, "black", true);
                }
                if (i == 0 && (j == 1 || j == 6)) {
                    p[i][j] = new Knight(i, j, "white", true);
                }
                if (i == 7 && (j == 1 || j == 6)) {
                    p[i][j] = new Knight(i, j, "black", true);
                }
                if (i == 0 && (j == 3)) {
                    p[i][j] = new King(i, j, "white", true);
                }
                if (i == 0 && (j == 4)) {
                    p[i][j] = new Queen(i, j, "white", true);
                }
                if (i == 7 && (j == 3)) {
                    p[i][j] = new King(i, j, "black", true);
                }
                if (i == 7 && (j == 4)) {
                    p[i][j] = new Queen(i, j, "black", true);
                }

            }
        }
    }

    public void display() {

        for (int i = 0; i < 8; i++) {
            System.out.print(i+1 + "    ");

            for (int j = 0; j < 8; j++) {
                if(p[i][j].getType().equals("."))
                    System.out.print("  "+p[i][j].getType()+"   ");
               else System.out.print("  " + p[i][j].getType() + "  ");
            }
            System.out.println("\n");
            if (i == 7) {
                System.out.println("      a     b     c     d     e     f     g     h");
            }
        }
    }

}
