import java.io.Serializable;

public class Simulador implements Serializable{

    private Veiculo[] veiculos = new Veiculo[this.getMaxVeiculos()];
    private static int qtidVeiculos;
    private int id = 0;
    private final int maxVeiculos = 20;

    public Simulador(){
        Simulador.setQtidVeiculos(0);
    }

    public int nextId(){
        return id+=1;
    }

    public void incluirVeiculo(){
        Veiculo v = new Veiculo(nextId());
        this.setVeiculos(v, Simulador.getQtidVeiculos()); // inicializa um veiculo no espaço do do vetor
        Simulador.setQtidVeiculos(Simulador.getQtidVeiculos() + 1);// adiciona 1 no set
    }

    public void pagaIPVA(int id){
        if(id == -1){
            System.out.println("Veiculo inexistente! Tente novamente\n");
        }else{
            this.getVeiculos()[this.getVeiculoPos(id)].setIpva(true);
            System.out.println("\nO veiculo com o id: " + id + " esta com o IPVA pago!\n");
        }
    }

    public void pagaIPVA(){
        for(int i =0;i<Simulador.getQtidVeiculos();i++){
            this.getVeiculos()[i].setIpva(true);
        }
    }

    public void removerVeiculo(int id){
        if(id == -1){
            System.out.println("Veiculo inexistente! Tente novamente\n");
        }else{
            this.getVeiculos()[id] = null;
            for(int i = id; i<Simulador.getQtidVeiculos()-1; i++)
                this.setVeiculos(this.getVeiculos()[i+1],i);
            Simulador.setQtidVeiculos(Simulador.getQtidVeiculos() - 1);

            System.out.println("Veiculo removido!\n");
        }
    }

    public void abastecer(int id, double quant){
        if(id == -1){
            System.out.println("Veiculo inexistente! Tente novamente\n");
        }else{
            this.getVeiculos()[id].setCombustivel(this.getVeiculos()[id].getCombustivel() + quant);// setando o combustivel com oq tem + o adicionado
            System.out.println("\nO veiculo com o id: " + id + " esta com " + this.getVeiculos()[id].getCombustivel() + " de combustivel no tanque\n");

        }
    }

    public void mover(int id){
        if(id == -1){
            System.out.println("Veiculo inexistente! Tente novamente\n");

        }else{
            this.getVeiculos()[id].mover();
            System.out.println("\nO veiculo com o id: " + id + " se moveu\n");
        }
    }

    public void mover(){
        for(int i=0;i<Simulador.getQtidVeiculos(); i++){
            this.getVeiculos()[i].mover();
        }

    }

    public void imprimirPista(){
        for(int i = 0;i<Simulador.getQtidVeiculos();i++){
            System.out.println("Veiculo "+this.getVeiculos()[i].getId()+":");
            this.getVeiculos()[i].geraDesenho();
        }
    }

    public String getPista(){
        String pista = null;

        for(int i = 0;i<Simulador.getQtidVeiculos();i++){
            pista += "Veiculo "+this.getVeiculos()[i].getId()+":";
            pista += this.getVeiculos()[i].getDesenho();
        }
        return pista;
    }

    public String toString(int id){
        if(id == -1){
            return "Veiculo inexistente! Tente novament\n";
        }else{
            return this.getVeiculos()[id].toString();
        }

    }

    public static int getQtidVeiculos() {
        return Simulador.qtidVeiculos;
    }

    public int getQtidVeiculosArq(){
        int qnt = 0;
        for(int i = 0; (i<this.getMaxVeiculos()) && (this.getVeiculos()[i] == null); i++)
            qnt++;

        return qnt;
    }

    public static void setQtidVeiculos(int qtidVeiculos) {
        if(Simulador.getQtidVeiculos()>=20){
            System.out.println("Impossivel completar operacao, o vetor esta cheio\n");
        }else{
            Simulador.qtidVeiculos = qtidVeiculos;
        }
    }

    public Veiculo[] getVeiculos(){
        return veiculos;
    }
    public void setVeiculos(Veiculo[] veiculos){
        this.veiculos = veiculos;
    }
    public void setVeiculos(Veiculo veiculo, int pos){
        this.veiculos[pos] = veiculo;
    }

    public int getMaxVeiculos(){
        return maxVeiculos;
    }

    public int getVeiculoPos(int id){
        for(int i = 0; i<Simulador.getQtidVeiculos(); i++) {
            if(getVeiculos()[i].getId() == id)
                return i;
        }

        return -1;
    }
}