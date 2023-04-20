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
         return id+1; // aumenta o ID (pode dat BO pq nao tenho ctz se é assim que a variavel static funciona)
        // se pa tem q iniciar ele como zero e add + 1, se pa mexe com a posi na memoria, vo muda pra + 1
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public void setDistanciaPercorrida(int distanciaPercorrida) {
        this.distanciaPercorrida = distanciaPercorrida;
    }

    public Roda[] getRodas() {
        return rodas;
    }

    public void setRodas(Roda[] rodas) {  // setando as 4 rodas com instancias novas para gerar os booleans aleatorios dos construtores
        for(int i=0;i<4;i++){
            this.rodas[i] = new Roda();
        }
    }

    public int getQuantidadeRodas() {
        return quantidadeRodas;
    }

    public void setQuantidadeRodas(int quantidadeRodas) {
        this.quantidadeRodas = quantidadeRodas;
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
}
