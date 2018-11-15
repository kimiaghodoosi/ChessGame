
public class Soldier extends Pieces {

    int x = 0, y = 0;

    public Soldier(int x, int y, String color, boolean b) {
        super(x, y);
        this.x = x;
        this.y = y;
        super.setColor(color);
        this.setLife(true);
        this.typein = "s";
        if (this.getColor().equals("white")) {
            this.type = "\u2659";
        } else {
            this.type = "\u265F";
        }
    }

    @Override
    public boolean isvalid(int x1, int y1, int x, int y) {

        if (((x1- x == -1 && y1== y) || (x1 - x == -2 && y1 == y)) && this.getColor().equals("white") && super.numOfmove() == 0) {
            if (Board.p[x][y].getType().equals(".") && (Board.p[x1 + 1][y1].getType().equals("."))) {
                return true;
            }
        }
        if (((x1 - x == -1 && y1 == y)) && this.getColor().equals("white")) {

            if (Board.p[x][y].getType().equals(".")) {

                return true;
            }
        }
            if (((x1 - x == -1 && (y1 - y == -1 || y1- y == 1))) && this.getColor().equals("white") && Board.p[x][y].getColor().equals("black")) {

                return true;
            }
        
        if (((x1 - x == 1 && y1 == y) || (x1 - x == 2 && y1 == y)) && this.getColor().equals("black") && super.numOfmove() == 0) {

            if (Board.p[x][y].getType().equals(".")) {

                return true;
            }
        }
        if (((x1 - x == 1 && y1 == y)) && this.getColor().equals("black")) {

            if (Board.p[x][y].getType().equals(".")) {

                return true;
            }
        
        }
            if (((x1 - x == 1 && (y1 - y == -1 | y1 - y == 1))) && this.getColor().equals("black") && Board.p[x][y].getColor().equals("white")) {

                return true;
            }
        
        return false;
    }

}
