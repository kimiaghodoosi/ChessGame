
public class Queen extends Pieces {

    int x = 0, y = 0;

    public Queen(int x, int y, String color, boolean b) {
        super(x, y);
        this.x = x;
        this.y = y;
        super.setColor(color);
        this.typein = "q";
        this.setLife(true);
        if (this.getColor().equals("white")) {
            this.type = "\u2655";
        } else {
            this.type = "\u265B";
        }
    }

    @Override
    public boolean isvalid(int x1, int y1, int x, int y) {

        if ((!Board.p[x][y].getColor().equals(Board.p[x1][y1].getColor())) || (Board.p[x][y].getType().equals("."))) {
            if (x1 == x) {

                for (int i = Math.min(y, y1) + 1; i < Math.max(y, y1 ); i++) {
                    if (!Board.p[x][i].getType().equals(".")) {
                        return false;
                    }
                }
                return true;
            }
            if (y1 == y) {

                for (int i = Math.min(x, x1) + 1; i < Math.max(x, x1); i++) {
                    if (!Board.p[x][i].getType().equals(".")) {
                        return false;
                    }
                }
                return true;
            }

        }
       if (((!Board.p[x1][y1].getColor().equals(Board.p[x][y].getColor())) && Math.abs(x1 - x) == Math.abs(y1 - y))) {

                int i = Math.min(x1, x) + 1;
                    int j=Math.min(y1, y) + 1;
                if((x1<x && y1<y)|(x1>x&& y1>y)){
                    
                 
                 while( j<Math.max(y1, y)){
                    if(!Board.p[i++][j++].getType().equals("."))
                    {
                        return false;
                    }
                }  
                }
               else if((x1<x && y1>y)|(x1>x && y1<y)){
                 
                 while( j<Math.max(y1, y)){
                    if(!Board.p[i++][j++].getType().equals("."))
                    {
                       return false;
                    }
                }  
                 

        }
                
}
       return true;
      
    }
}
