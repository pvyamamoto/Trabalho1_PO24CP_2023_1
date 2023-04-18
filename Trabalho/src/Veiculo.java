import java.util.Random;

public class Veiculo {
    private int id;
    private String desenho;
    private int distanciaPercorrida;
    private Roda[] rodas;
    private int quantidadeRodas;
    private boolean ipva;

    public Veiculo(){
        this.setId(0);
        this.setDistanciaPercorrida(0);
        this.setQuantidadeRodas(0);
        this.isIpva();
        this.setRodas(null);
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

    public void setRodas(Roda[] rodas) {
        this.rodas = rodas;
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
}
