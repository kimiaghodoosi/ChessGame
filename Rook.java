
public class Rook extends Pieces {
    int x=0, y=0;
    public Rook(int x, int y, String color, boolean b){
        super(x,y);
        this.x = x;
        this.y = y;
        this.typein ="r";
        super.setColor(color);
        this.setLife(true);
        if(this.getColor().equals("white")){
            this.type ="\u2656";
        }
        else{
            this.type = "\u265C";
    }  
}
    @Override
    public boolean isvalid(int x1,int y1, int x, int y){
        if(!Board.p[x][y].getColor().equals(Board.p[x1][y1].getColor()))
         || (Board.p[x][y].getType().equals("."))){
        if(x1 == x){
            for(int i=Math.min(y, y1)+1;i<Math.max(y, y1);i++){
                if(!Board.p[x][i].getType().equals(".")){
                    return false;
                }
        }
            return true;
    }
        if(y1 == y){
            for(int i=Math.min(x, x1)+1 ; i<Math.max(x, x1);i++){
                if(!Board.p[x][i].getType().equals(".")){
                    return false;
                }
            }
            return true;
        }
    }
         return false;
    }
}