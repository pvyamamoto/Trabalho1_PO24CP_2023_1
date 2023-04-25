
public class Simulador {

    private Veiculo[] veiculos = new Veiculo[this.maxVeiculos];
    private static int qtidVeiculos;

    private final int maxVeiculos = 20;

    public Simulador(){
        this.setQtidVeiculos(0);
    }

    public void incluirVeiculo(){
        this.setQtidVeiculos(this.getQtidVeiculos() + 1);// adiciona 1 no set
        this.getVeiculos()[this.getQtidVeiculos() ] = new Veiculo(); // inicializa um veiculo no espaço do do vetor
    }


    public void pagaIPVA(int id){
        this.getVeiculos()[id].setIpva(true);
    }

    public void pagaTodosIPVA(){
        for(int i =0;i<this.getQtidVeiculos();i++){
            this.getVeiculos()[i].setIpva(true);
        }
    }

    public void removerVeiculo(int id){
        if(this.getVeiculos()[id] == null){
            System.out.println("Veiculo inexistente!");
        }else{
            this.getVeiculos()[id] = null;
        }
    }

    public void abastecer(int id, double quant){
        this.getVeiculos()[id].setCombustivel(this.getVeiculos()[id].getCombustivel() + quant);// setando o combustivel com oq tem + o adicionado
    }

    public void mover(int id){
        this.getVeiculos()[id].mover();
    }

    public void moverTodos(){
        for(int i=0;i<this.getVeiculos().length;i++){
            this.getVeiculos()[i].mover();
        }

    }

    public void imprimirPista(){
        for(int i =0;i<this.getQtidVeiculos();i++){
            this.getVeiculos()[i+1].geraDesenho();
        }
    }

    public String toString(){
        return "ebaaa";
    }



    public static int getQtidVeiculos() {
        return qtidVeiculos;
    }

    public static void setQtidVeiculos(int qtidVeiculos) {

        if(Simulador.getQtidVeiculos()>=20){
            System.out.println("Impossivel completar operacao, o vetor esta cheio");
        }else{
            Simulador.qtidVeiculos = qtidVeiculos;
        }
    }


    public Veiculo[] getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(Veiculo[] veiculos) {
        this.veiculos = veiculos;
    }
}
