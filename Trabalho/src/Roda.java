import java.io.Serializable;
import java.util.Random;

public class Roda implements Serializable{

    private boolean calibragemPneu;

    public Roda(){
        Random rd = new Random();
        this.setCalibragemPneu(rd.nextBoolean());
    }

    public String toString(){
        if(this.isCalibragemPneu()){
            return "O pneu esta calibrado";
        }else{
            return "O pneu nao esta calibrado";
        }
    }

    public boolean isCalibragemPneu() {
        return this.calibragemPneu;
    }

    public void setCalibragemPneu(boolean calibragemPneu) {
        this.calibragemPneu = calibragemPneu;
    }
}
