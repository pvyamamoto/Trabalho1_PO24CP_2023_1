import java.util.Random;

public class Veiculo {
    private static int id = 0; // variavel statica pra poder aumentar +1 no ID toda vez q criar um obj novo
    private String desenho;
    private int distanciaPercorrida;
    private Roda[] rodas;
    private int quantidadeRodas;
    private boolean ipva;

    private double combustivel;

    public Veiculo(){
        Random rd = new Random(); // gerar ipva aleatorio

        this.setId(this.nextId()); //gera o prox ID
        this.setDistanciaPercorrida(0);
        this.setQuantidadeRodas(4);
        this.setIpva(rd.nextBoolean()); // gerar ipva aleatorio
        this.setRodas(this.rodas);
        this.setCombustivel(2.5); // combustivel base tem q ser 2.5
    }

    public int nextId(){
         return id+1;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getDistanciaPercorrida(){
        return distanciaPercorrida;
    }

    public void setDistanciaPercorrida(int distanciaPercorrida){
        this.distanciaPercorrida = distanciaPercorrida;
    }

    public Roda[] getRodas(){
        return rodas;
    }

    public void setRodas(Roda[] rodas){  // mudei o 4 pela variavel qntRodas pq se nao nao faz sentido ter a variavel
        for(int i=0;i<this.getQuantidadeRodas();i++){
            this.rodas[i] = new Roda();
        }
    }

    public int getQuantidadeRodas(){
        return this.quantidadeRodas;
    }

    public void setQuantidadeRodas(int quantidadeRodas){
        this.quantidadeRodas = quantidadeRodas;
    }

    public boolean isIpva(){
        return ipva;
    }

    public void setIpva(boolean ipva){
        this.ipva = ipva;
    }

    public double getCombustivel(){
        return combustivel;
    }

    public void setCombustivel(double combustivel){
        this.combustivel = combustivel;
    }
}
