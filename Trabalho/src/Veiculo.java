import java.util.Random;

public class Veiculo {
    private static int id = 0; // variavel statica pra poder aumentar +1 no ID toda vez q criar um obj novo
    private String[] desenho;
    private int distanciaPercorrida;
    private final int quantidadeRodas = 4;
    private Roda[] rodas = new Roda[getQuantidadeRodas()];
    private boolean ipva;
    private double combustivel;

    public Veiculo(){
        Random rd = new Random(); // gerar ipva aleatorio

        this.setId(this.nextId()); //gera o prox ID
        this.setDistanciaPercorrida(0);
        this.setIpva(rd.nextBoolean()); // gerar ipva aleatorio
        this.setRodas();
        this.setCombustivel(2.5); // combustivel base tem q ser 2.5
        this.setDesenho(); // desenho do carro
    }
    public String[] mover(){
        if((this.getCombustivel() > 0) && (this.isIpva())){
            for(int i = 0; i<this.getQuantidadeRodas(); i++){
                if(!this.getRodas()[i].isCalibragemPneu())
                    return desenho;
            }
            for(int i = 0; i<this.desenho.length; i++){
                this.desenho[i] = "     "+this.desenho[i];
            }
            this.setCombustivel(this.getCombustivel() - 0.55);
            this.setDistanciaPercorrida(this.getDistanciaPercorrida() + 5);

            return desenho;
        }else
            return desenho;
    }
    public String toString(){
        return ("Id: "+this.getId()+"\nQuantidade de rodas: "+this.getQuantidadeRodas()+
                ((this.isIpva()) ? "\nIpva esta pago" : "\nIpva nao esta pago")+"\nCombustivel no tanque: "
                +this.getCombustivel()+"L"+ "\nDistancia percorrida: "+this.distanciaPercorrida+" blocos");
    }
    public int nextId(){
         return id+=1;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        Veiculo.id = id;
    }

    public int getDistanciaPercorrida(){
        return distanciaPercorrida;
    }

    public void setDistanciaPercorrida(int distanciaPercorrida){
        this.distanciaPercorrida = distanciaPercorrida;
    }

    public Roda[] getRodas() {
        return rodas;
    }



    public int getQuantidadeRodas() {
        return this.quantidadeRodas;
    }


    public boolean isIpva(){
        return ipva;
    }

    public void setIpva(boolean ipva) {
        this.ipva = ipva;
    }

    public double getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(double combustivel) {
        this.combustivel = combustivel;
    }
    public String[] getDesenho() {
        return desenho;
    }
    public void setDesenho(){
        this.desenho[0] = "    ____\n";
        this.desenho[1] = " __/  |_ \\_\n";
        this.desenho[2] = "|  _     _``-.\n";
        this.desenho[3] = "'-(_)---(_)--'\n\n\n";
    }

    public void setRodas(){
        for(int i=0;i<this.getQuantidadeRodas();i++){
            this.rodas[i] = new Roda();
        }
    }
}