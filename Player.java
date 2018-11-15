
public class Player {

    private String name;
    private boolean isturn;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }
     public void setTurn(boolean b) {
        this.isturn=b;
    }

    public boolean getTurn() {

        return this.isturn;
    }
}

