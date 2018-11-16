
public class Bishop extends  Pieces{
   
     int x=0;
     int y=0;
    public Bishop(int x, int y, String color, boolean b){
        super(x, y);
        this.x = x;
        this.y =y;
        super.setColor(color);
        this.setLife(true);
        this.typein = "b";
        if(this.getColor().equals("white")){
            this.type = "\u2657";    
    }
        else{
            this.type = "\u265D";
            
        }
        
}
    @Override
    public boolean isvalid(int x1, int y1, int x, int y){
       if(((!Board.p[x1][y1].getColor().equals(Board.p[x][y].getColor())
           || (Board.p[x][y].getType().equals("."))) && Math.abs(x1-x)==
               Math.abs(y1-y))){
                 int i = Math.min(x1, x) +1;
                 int j = Math.min(y1, y) +1;
               if((x1 < x && y1<y) | (x1>x && y1>y)){
                   while(j<Math.max(y1, y)){
                       if(!Board.p[i++][j++].getType().equals(".")){
                           return false;
                       }
                   }
               }
               else if((x1<x && y1>y) | (x1>x && y1<y)){
                    i = Math.max(x1, x) -1;
                    j = Math.max(y1, y) +1;
                    while(j<Math.max(y1, y)){
                        if(!Board.p[i--][j++].getType().equals(".")){
                            return false;
                        }
                    }
               }
}
       return true;
}
}