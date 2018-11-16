public class Knight extends Pieces{
     int x=0;
     int y=0;
    public Knight(int x, int y, String color, boolean b){
        super(x, y);
        this.x = x;
        this.y =y;
        super.setColor(color);
        this.setLife(true);
        this.typein = "kn";
        if(this.getColor().equals("white")){
            this.type = "\u2658";    
    }
        else{
            this.type = "\u265E";
            
        }
        
}
    @Override
    public boolean isvalid(int x1, int y1, int x, int y){
            if ((!Board.p[x][y].getColor().equals(Board.p[x1][y1].getColor())) || (Board.p[x][y].getType().equals("."))) {

                    
            if ((Math.abs(x1 - x) == 1 && Math.abs(y1 - y) == 2) || (Math.abs(x1- x) == 2 && Math.abs(y1- y) == 1)) {
             
                return true;
            }
        }
            return false;
    }
    }

