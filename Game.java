
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    Player p1 = new Player();
    Player p2 = new Player();

    int x = 0, y = 0;
    int x_kingw;
    int y_kingb;
    int x_kingb;
    int y_kingw;
    boolean c_kh = false, c_q = false, c_b = false, c_r = false, c_s =false;

    public void start() {
        ArrayList listX = new ArrayList();
        ArrayList listY = new ArrayList();
        p1.setTurn(true);
        Board b = new Board();
        Scanner input = new Scanner(System.in);
        System.out.println("enter your names please");
        String name1 = input.nextLine();
        p1.setName(name1);
        String name2 = input.nextLine();
        p2.setName(name2);
        while (true) {
             
            System.out.println("enter one of the number:");
            System.out.println("1.move \n 2.back \n 3.exit");
            int n = input.nextInt();
            System.out.println("\n");
            //..............................................................................
            if (n == 1) {
                b.display();
              
                if (p1.getTurn()) {
                    System.out.println("\n" + p1.getName() + "   enter1");
                } else {
                    System.out.println("\n" + p2.getName() + "   enter1");
                }
                
                int x1 = this.x(input.nextInt());
                int y1 = this.y(input.next());
                System.out.println(y1);
               Pieces p = new Pieces(x1, y1);

                System.out.println(" enter 2");
                int x2 = this.x(input.nextInt());
                int y2 = this.y(input.next());
                   /////////////////////////////////////////
                if(Board.p[0][2].getType().equals(".")||Board.p[0][4].getType().equals(".")||Board.p[1][4].getType().equals(".")||Board.p[1][2].getType().equals(".")||Board.p[1][3].getType().equals(".")){
                  this.king();
                while(this.kish(x_kingw, y_kingw)){
                    System.out.println("sssssss");
                    System.out.println(x_kingw+" "+y_kingw);
                    if(this.mat(x_kingw, y_kingw)){
                        System.out.println("mat");
                        System.exit(0);
                    }
                    System.out.println("kish enter correct number");
                 x1 = this.x(input.nextInt());
                y1 = this.y(input.next());
               
                 x2 = this.x(input.nextInt());
                 y2 = this.y(input.next());
             if(Board.p[x1][y1].isvalid(x1, y1, x2, y2)){
             
                 p.move(x1, y1, x2, y2);
                 if(this.kish(x_kingw, y_kingb)){
                     System.out.println("your answer is wrong!!");
                     p.move(x2, y2, x1, y1);
                 }
                 this.king();
             }
               }
                }
                ///////////////////////////////////////////////////////////////////////////
                  if(Board.p[7][2].getType().equals(".")||Board.p[7][4].getType().equals(".")||Board.p[7][4].getType().equals(".")||Board.p[6][2].getType().equals(".")||Board.p[6][3].getType().equals(".")){
                  this.king();
                while(this.kish(x_kingw, y_kingw)){
                    System.out.println("sssssss");
                    System.out.println(x_kingw+" "+y_kingw);
                    if(this.mat(x_kingw, y_kingw)){
                        System.out.println("mat");
                        System.exit(0);
                    }
                    System.out.println("kish enter correct number");
                x1 = this.x(input.nextInt());
                 y1 = this.y(input.next());
               
                x2 = this.x(input.nextInt());
                 y2 = this.y(input.next());
             if(Board.p[x1][y1].isvalid(x1, y1, x2, y2)){
             
                 p.move(x1, y1, x2, y2);
                 if(this.kish(x_kingw, y_kingb)){
                     System.out.println("your answer is wrong!!");
                     p.move(x2, y2, x1, y1);
                 }
                 this.king();
             }
               }
                }
                  //....................................................
              while(!Board.p[x1][y1].isvalid(x1, y1, x2, y2)) {
                    System.out.println("pls enter correct numbers");
                 x1 = this.x(input.nextInt());
                 y1 = this.y(input.next());
                    System.out.println("enter2");
                x2 = this.x(input.nextInt());
                 y2 = this.y(input.next());
                }
                    p.move(x1, y1, x2, y2);
                    this.change();
                    listX.clear();
                    listY.clear();
                    listX.add(x1);
                    listX.add(x2);
                    listY.add(y1);
                    listY.add(y2);
               
                //////////////////////////////////////////////////////////////////////
                b.display();
                if (this.winner()) {
                    break;
                }
            }
            //.......................................................................................
            if (n == 2) {
                if (listX.isEmpty() && listY.isEmpty()) {
                    break;
                }
                Pieces p = new Pieces(Integer.parseInt(listX.get(1).toString()), Integer.parseInt(listY.get(1).toString()));
              
                p.move(Integer.parseInt(listX.get(1).toString()), Integer.parseInt(listY.get(1).toString()), Integer.parseInt(listX.get(0).toString()), Integer.parseInt(listY.get(0).toString()));
                listX.clear();
                listY.clear();
               
                b.display();
                this.change();
            }
            //..........................................................................................
            if (n == 3) {
               System.exit(0);
            }
        }
    }

    public void change() {

        if (p1.getTurn() == true) {

            p1.setTurn(false);
            p2.setTurn(true);
        }
        else {

            p2.setTurn(false);
            p1.setTurn(true);
        }
    }

    public boolean winner() {
        int c = 0;
        String s = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!Board.p[i][j].isLife()) {
                    c++;
                    System.out.println(c );
                } else {
                    s = Board.p[i][j].getColor();
                }
            }
        }
        if (c == 31) {
            if (s.equals("white")) {
                System.out.println(p1.getName() + " is winner");
                return true;
            }
           
             if(s.equals("black")){
            System.out.println(p2.getName() + " is winner");
            return true;
        }
}
        return false;
    }

    public void king() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Board.p[i][j].getTypein().equals("k") && Board.p[i][j].getColor().equals("white")) {

                    x_kingw = i;
                    y_kingw = j;
                    break;
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Board.p[i][j].getTypein().equals("k") && Board.p[i][j].getColor().equals("black")) {

                    x_kingb = i;
                    y_kingb = j;
                    break;
                }
            }
        }

    }

    public boolean kish(int x_king, int y_king) {

        int x_queen = 0, y_queen = 0, x_knight = 0, y_knght = 0, x_bishop = 0, y_bishop = 0, x_rook = 0, y_rook = 0, x_soldier = 0, y_soldier = 0;
        int x_queenb = 0, y_queenb = 0, x_knightb = 0, y_knghtb = 0, x_bishopb = 0, y_bishopb = 0, x_rookb = 0, y_rookb = 0, x_soldierb = 0, y_soldierb = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (Board.p[i][j].getTypein().equals("s")) {

                    if(i<=3){
                    x_soldier = i;
                    y_soldier = j;
                    }
                    else
                    { x_soldierb=i;
                        y_soldierb=j;
                    }
                }
                if (Board.p[i][j].getTypein().equals("b")) {
                    if(i<=3){
                    x_bishop = i;
                    y_bishop = j;
                    }
                    else
                    {
                    x_bishopb = i;
                    y_bishopb = j;
                    }
                }
                if (Board.p[i][j].getTypein().equals("q")) {
                     if(i<=3){
                    x_queen = i;
                    y_queen = j;
                     }
                     else{
                     x_queenb = i;
                    y_queenb= j;
                     }
                }
                if (Board.p[i][j].getTypein().equals("r")) {
                     if(i<=3){
                    x_rook = i;
                    y_rook = j;
                     }
                     else{
                      x_rookb = i;
                    y_rookb = j;
                     }
                }
                if (Board.p[i][j].getTypein().equals("kn")) {
                      if(i<=3){
                    x_knight = i;
                    y_knght = j;
                      }
                      else{
                       x_knight = i;
                       y_knght = j;
                      }
                }
            }

        }
        System.out.println(x_queen+"   "+y_queen);
        if (((x_soldierb - x_king == -1 && (y_soldierb - y_king == -1 || y_soldierb - y_king == 1))) && Board.p[x_king][y_king].getColor().equals("white") ) {

            System.out.println("1");
            return true;

        }
        if (((x_soldier - x_king == 1 && (y_soldier - y_king == 1 || y_soldier - y_king == -1))) && Board.p[x_king][y_king].getColor().equals("black") ) {

            System.out.println("2");
            return true;

        }
        if ((!Board.p[x_king][y_king].getColor().equals("black"))) {

            if ((Math.abs(x_knight - x_king) == 1 && Math.abs(y_knght - y_king) == 2) || (Math.abs(x_knight - x_king) == 2 && Math.abs(y_knght - y_king) == 1)) {
                

                System.out.println("3");
                return true;
            }

        }
         if ((!Board.p[x_king][y_king].getColor().equals("white"))) {

            if ((Math.abs(x_knightb - x_king) == 1 && Math.abs(y_knghtb - y_king) == 2) || (Math.abs(x_knightb - x_king) == 2 && Math.abs(y_knghtb - y_king) == 1)) {
                

                System.out.println("3");
                return true;
            }

        }
        //........................................................................
        if ((!Board.p[x_king][y_king].getColor().equals("black"))) {
            int i=0;
            if (x_rook == x_king) {

                for ( i = Math.min(y_king, y_rook) + 1; i < Math.max(y_king, y_rook ); i++) {
                    if (!Board.p[x_king][i].getType().equals(".")) {
                        c_r = false;
                        System.out.println("5");
                        break;
                       
                    }
                    
                }
                if(i==Math.max(y_king, y_rook )){
                    c_r=true;
                 
                }

            }
           else if (y_rook == y_king) {

                for ( i = Math.min(x_king, x_rook) + 1; i < Math.max(x_king, x_rook); i++) {
                    if (!Board.p[x_king][i].getType().equals(".")) {
                        c_r = false;
                        System.out.println("6");
                        break;
                    }
                }
                   if(i==Math.max(y_king, y_rook )){
                    c_r=true;
                      
                   }


            }
 System.out.println(c_r +" c_r");
        }
         if ((!Board.p[x_king][y_king].getColor().equals("white"))) {
             int i=0;
            if (x_rookb == x_king) {

                for ( i = Math.min(y_king, y_rookb) + 1; i < Math.max(y_king, y_rookb ); i++) {
                    if (!Board.p[x_king][i].getType().equals(".")) {
                        c_r = false;
                        System.out.println("5");
                        break;
                       
                    }
                }
                    if(i==Math.max(y_king, y_rook )){
                    c_r=true;
                        
                    }
            }
           else if (y_rookb == y_king) {

                for ( i = Math.min(x_king, x_rookb) + 1; i < Math.max(x_king, x_rookb); i++) {
                    if (!Board.p[x_king][i].getType().equals(".")) {
                        c_r = false;
                        System.out.println("6");
                        break;
                    }
                }
                if(i==Math.max(y_king, y_rook )){
                    c_r=true;
     
                }
            }
             System.out.println(c_r +" c_r");
        }
        //..................................................
        if (((Board.p[x_king][y_king].getColor().equals("black")) && Math.abs(x_bishop - x_king) == Math.abs(y_bishop - y_king))) {

                int i ;
                    int j;
                if((x_bishop<x_king && y_bishop<y_king)|(x_bishop>x_king && y_bishop>y_king)){
                    
                 i = Math.min(x_bishop, x_king) + 1;
                  j=Math.min(y_bishop, y_king) + 1;
                 while( j<Math.max(y_bishop, y_king)){
                    if(!Board.p[i++][j++].getType().equals("."))
                    {
                        c_b=false;
                        break;
                    }
                }  
                 if(j==Math.max(y_bishop, y_king))
                     c_b=true;
                }
               else if((x_bishop<x_king && y_bishop>y_king)|(x_bishop>x_king && y_bishop<y_king)){
                i = Math.max(x_bishop, x_king) - 1;
                   j=Math.min(y_bishop, y_king) + 1;
                  while( j<Math.max(x_bishop, x_king)){
                    if(!Board.p[i--][j++].getType().equals("."))
                    {
                        c_b=false;
                        break;
                    }
                }  
                 if(j==Math.max(y_bishop, y_king))
                     c_b=true;
                }

        }
           
            //-----------------------------
            if ((Board.p[x_king][y_king].getColor().equals("white")) && Math.abs(x_bishopb - x_king) == Math.abs(y_bishopb - y_king)) {

                
                int i ;
                    int j;
                
                if((x_bishopb<x_king && y_bishopb<y_king)|(x_bishopb>x_king && y_bishopb>y_king)){
                     i = Math.min(x_bishopb, x_king) + 1;
                    j=Math.min(y_bishopb, y_king) + 1;
                 while( j<Math.max(y_bishopb, y_king)){
                    if(!Board.p[i++][j++].getType().equals("."))
                    {System.out.println(c_b);
                        c_b=false;
                        break;
                    }
                }  
                 if(j==Math.max(x_bishopb, x_king))
                     c_b=true;
                    
                }
                else  if((x_bishopb<x_king && y_bishopb>y_king)|(x_bishopb>x_king && y_bishopb<y_king)){
                
                   i = Math.max(x_bishopb, x_king) - 1;
                   j=Math.min(y_bishopb, y_king) + 1;
                  while( j<Math.max(x_bishopb, x_king)){
                    if(!Board.p[i--][j++].getType().equals("."))
                    {
                        c_b=false;
                        break;
                    }
                }  
                 if(j==Math.max(x_bishopb, x_king))
                     c_b=true;
               System.out.println("cheraaaaaaaa");
                }

        }

        
        //............................................................................            

        if ((Board.p[x_king][y_king].getColor().equals("black"))) {
          
            System.out.println(x_queen+" "+y_queen);
            System.out.println(x_king+" king  "+y_king);
            
           
            if (x_queen == x_king) {
                  int i;
                  System.out.println(x_queen+" "+y_queen+" "+x_king+" "+y_king);
                for ( i = Math.min(y_king, y_queen) + 1; i < Math.max(y_king, y_queen ); i++) {
                    if (!Board.p[x_king][i].getType().equals(".")) {
                        System.out.println(Board.p[x_king][i].getTypein());
                        c_q = false;
                        System.out.println("5");
                        break;
                       
                    }
                    
                }
                if(i==Math.max(y_king, y_queen )){
                    c_q=true;
                    System.out.println("c1");
                }
            }
           else if (y_queen== y_king) {
                   int i;
                for ( i = Math.min(x_king, x_queen) + 1; i < Math.max(x_king, x_queen); i++) {
                    if (!Board.p[x_king][i].getType().equals(".")) {
                        c_q = false;
                        System.out.println("6");
                        break;
                    }
                }
                   if(i==Math.max(y_king, y_queen )){
                    c_q=true;
                    System.out.println("c2");
                   }

            }
            if (( Math.abs(x_queen - x_king) == Math.abs(y_queen - y_king))) {

                int i = Math.min(x_queen, x_king) + 1;
                    int j=Math.min(y_queen, y_king) + 1;
                if((x_queen<x_king && y_queen<y_king)|(x_queen>x_king && y_queen>y_king)){
                    
                 
                 while( j<Math.max(y_queen, y_king)){
                    if(!Board.p[i++][j++].getType().equals("."))
                    {
                        c_q=false;
                        break;
                    }
                }  
                 if(j==Math.max(y_queen, y_king)){
                     c_q=true;
                 System.out.println("c3");
                 }
                }
               else if((x_queen<x_king && y_queen>y_king)|(x_queen>x_king && y_queen<y_king)){
                 
                 while( j<Math.max(y_queen, y_king)){
                    if(!Board.p[i++][j++].getType().equals("."))
                    {
                        c_q=false;
                        break;
                    }
                }  
                 if(j==Math.max(y_queen, y_king)){
                     c_q=true;
                     System.out.println("c4");
                 
                 }
                }

        }


        
        }
        //--------------------------
         
  if ((Board.p[x_king][y_king].getColor().equals("white"))) {
            System.out.println(x_queenb+" queenb "+y_queenb);
            System.out.println(x_king+" king  "+y_king);
            
           
            if (x_queenb == x_king) {
                  int i;
                for ( i = Math.min(y_king, y_queenb) + 1; i < Math.max(y_king, y_queenb ); i++) {
                    if (!Board.p[x_king][i].getType().equals(".")) {
                        c_q = false;
                        System.out.println("5");
                        break;
                       
                    }
                    
                }
                if(i==Math.max(y_king, y_queenb ))
                    c_q=true;

            }
           else if (y_queenb== y_king) {
                   int i=0;
                for ( i = Math.min(x_king, x_queenb) + 1; i < Math.max(x_king, x_queenb); i++) {
                    if (!Board.p[x_king][i].getType().equals(".")) {
                        c_q = false;
                        System.out.println("6");
                        break;
                    }
                }
                   if(i==Math.max(y_king, y_queenb ))
                    c_q=true;


            }
            if (( Math.abs(x_queenb - x_king) == Math.abs(y_queenb - y_king))) {

                int i = Math.min(x_queenb, x_king) + 1;
                    int j=Math.min(y_queenb, y_king) + 1;
                if((x_queenb<x_king && y_queenb<y_king)|(x_queenb>x_king && y_queenb>y_king)){
                    
                 
                 while( j<Math.max(y_queenb, y_king)){
                    if(!Board.p[i++][j++].getType().equals("."))
                    {
                        c_q=false;
                        break;
                    }
                }  
                 if(j==Math.max(y_queenb, y_king))
                     c_q=true;
                }
               else if((x_queenb<x_king && y_queenb>y_king)|(x_queenb>x_king && y_queenb<y_king)){
                 
                 while( j<Math.max(y_queenb, y_king)){
                    if(!Board.p[i++][j++].getType().equals("."))
                    {
                        c_q=false;
                        break;
                    }
                }  
                 if(j==Math.max(y_queenb, y_king))
                     c_q=true;
                }

        }


        
        }
        //.............................................................................
        System.out.println(c_s);
        System.out.println(c_kh);
        System.out.println(c_b);
        System.out.println(c_r);
        System.out.println(c_q);
        if (c_s || c_kh || c_b || c_r || c_q) {
            return true;
        }
        return false;
    }

    public boolean mat(int x, int y) {

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (x - 1 < 0) {
                    i = 0;
                }
                if (y - 1 < 0) {
                    j = 0;
                }
                if (x + 1 > 7) {
                    i = 7;
                }
                if (y + 1 > 7) {
                    j = 7;
                }
                if (!this.kish(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    public int x(int x){
    
        return x-1;
    }
    public int y(String y){
    
        switch (y) {
            case "a":
                return 0;
            case "b":
                return 1;
            case "c":
                return 2;
            case "d":
                return 3;
            case "e":
                return 4;
            case "f":
                return 5;
            case "g":
                return 6;
            default:
                return 7;
        }
        
    
    }
    
}

////queen kissh , mot monde 
/// dar zemn check konam bebinam doroste??????????????????????????????
