
public class King extends Pieces {

    int x = 0, y = 0;

    public King(int x, int y, String color, boolean b) {
        super(x, y);
        this.x = x;
        this.y = y;
        super.setColor(color);
       this.setLife(true);
        this.typein = "k";
        if (this.getColor().equals("white")) {
            this.type = "\u2654";
        } else {
            this.type = "\u265A";
        }
    }

    @Override
    public boolean isvalid(int x1, int y1, int x, int y) {

        if ((!Board.p[x][y].getColor().equals(Board.p[this.x][this.y].getColor()) || (Board.p[x][y].getType().equals(".")))) {

            if (Math.abs(this.x - x) == 1 || Math.abs(this.y - y) == 1) {

                return true;
            }
        }
        return false;
    }
}
