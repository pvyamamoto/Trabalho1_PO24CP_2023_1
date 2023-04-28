import java.io.Serializable;

public class Simulador implements Serializable{

    private Veiculo[] veiculos = new Veiculo[this.getMaxVeiculos()];
    private int qtidVeiculos;
    private int id = 0;
    private final int maxVeiculos = 20;

    public Simulador(){
        this.setQtidVeiculos(0);
    }

    public int nextId(){
        return id+=1;
    }

    public void incluirVeiculo(){
        Veiculo v = new Veiculo(nextId());
        this.setVeiculos(v, this.getQtidVeiculos()); // inicializa um veiculo no espaço do do vetor
        this.setQtidVeiculos(this.getQtidVeiculos() + 1);// adiciona 1 no set
    }


    public void calibraPneu(int idC,int idP){
        if(idC == -1){
            System.out.println("Veiculo inexistente! Tente novamente\n");
        }else if(idP != 1 && idP != 2 && idP != 3 && idP != 4 ){
            System.out.println("Pneu Inexistente! Tente novamente\n");
        }else{
            this.getVeiculos()[idC].getRodas()[idP - 1].setCalibragemPneu(true);
            System.out.println("O pneu " + idP + ", do carro " + (idC+1) + " esta calibrado!");
        }
    }

    public void calibraPneu(int id){
        if(id == -1){
            System.out.println("Veiculo inexistente! Tente novamente\n");
        }else{
            for (int i = 1; i <= this.getVeiculos()[id].getQuantidadeRodas(); i++) {
                if(!this.getVeiculos()[id].getRodas()[i-1].isCalibragemPneu()) {
                    this.calibraPneu(id, i);
                }
            }
            System.out.println("Todos os pneus do carro " + (id+1) + " foram calibrados\n");
        }
    }


    public void calibraPneu() {
        for (int i = 0; i < this.getQtidVeiculos(); i++) {
            for (int j = 1; j <= this.getVeiculos()[i].getQuantidadeRodas(); j++) {
                if(!this.getVeiculos()[i].getRodas()[j-1].isCalibragemPneu()){
                    this.calibraPneu(i, j);
                }
            }
        }
        System.out.println("\nTodos os pneus de todos os carros foram calibrados\n");
    }

    public void pagaIPVA(int id){
        if(id == -1){
            System.out.println("Veiculo inexistente! Tente novamente\n");
        }else{
            this.getVeiculos()[this.getVeiculoPos(id)].setIpva(true);
            System.out.println("\nO veiculo com o id: " + (id+1) + " esta com o IPVA pago!\n");
        }
    }

    public void pagaIPVA(){
        for(int i =0;i<this.getQtidVeiculos();i++){
            this.getVeiculos()[i].setIpva(true);
        }
    }

    public void removerVeiculo(int id){
        if(id == -1){
            System.out.println("Veiculo inexistente! Tente novamente\n");
        }else{
            this.getVeiculos()[id] = null;
            for(int i = id; i<this.getQtidVeiculos()-1; i++)
                this.setVeiculos(this.getVeiculos()[i+1],i);
            this.setQtidVeiculos(this.getQtidVeiculos() - 1);

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
        for(int i=0;i<this.getQtidVeiculos(); i++){
            this.getVeiculos()[i].mover();
        }

    }

    public void imprimirPista(){
        for(int i = 0;i<this.getQtidVeiculos();i++){
            System.out.println("Veiculo "+this.getVeiculos()[i].getId()+":");
            this.getVeiculos()[i].geraDesenho();
        }
    }

    public String toString(int id){
        if(id == -1){
            return "Veiculo inexistente! Tente novamente\n";
        }else{
            return this.getVeiculos()[id].toString();
        }

    }

    public int getQtidVeiculos() {
        return this.qtidVeiculos;
    }
    public void setQtidVeiculos(int qtidVeiculos) {
        if(this.getQtidVeiculos()>=20){
            System.out.println("Impossivel completar operacao, o vetor esta cheio\n");
        }else{
            this.qtidVeiculos = qtidVeiculos;
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
        for(int i = 0; i<this.getQtidVeiculos(); i++) {
            if(getVeiculos()[i].getId() == id)
                return i;
        }

        return -1;
    }
}