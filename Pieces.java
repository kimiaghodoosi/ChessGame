
public class Pieces {

    String color;
    String type;
    String typein = "";
    int x = 0;
    int y = 0;
    boolean life;
    boolean kish;
    static int c = 0;

    public Pieces(int x, int y) {
        color = "white";
        type = ".";
        life = true;
        setPosition(x, y);
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public String getTypein() {
        return typein;
    }

    public boolean isLife() {
        return life;
    }

    public void setLife(boolean b) {
        this.life = b;

    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setKish(boolean kish) {
        this.kish = kish;
    }

    public boolean getKish() {
        return kish;
    }

    public void setTypein(String typein) {
        this.typein = typein;
    }

    public int getX() {

        return x;
    }

    public int getY() {

        return y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public boolean isvalid(int x1, int y1, int x, int y) {
        System.out.println("ddd1");
        return true;
    }

    public void move(int x1, int y1, int x2, int y2) {

        if (!Board.p[x1][y1].getColor().equals(Board.p[x2][y2].getColor())) {
            Board.p[x2][y2].setLife(false);
        }

        Board.p[x2][y2].setType(Board.p[x1][y1].getType());
        Board.p[x2][y2].setColor(Board.p[x1][y1].getColor());
        Board.p[x1][y1].setType(".");
        c++;

    }

    public int numOfmove() {

        return c;
    }

}
