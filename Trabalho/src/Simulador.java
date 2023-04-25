
public class Simulador {

    private Veiculo[] veiculos = new Veiculo[this.maxVeiculos];
    private static int qtidVeiculos;

    private final int maxVeiculos = 20;

    public Simulador(){
        this.setQtidVeiculos(0);
    }

    public void incluirVeiculo(){
        Veiculo v = new Veiculo();
        this.setVeiculos(v); // inicializa um veiculo no espaço do do vetor
        Simulador.setQtidVeiculos(Simulador.getQtidVeiculos() + 1);// adiciona 1 no set
    }


    public void pagaIPVA(int id){
        this.getVeiculos()[id].setIpva(true);
    }

    public void pagaTodosIPVA(){
        for(int i =0;i<Simulador.getQtidVeiculos();i++){
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
        for(int i=0;i<Simulador.getQtidVeiculos(); i++){
            this.getVeiculos()[i].mover();
        }

    }

    public void imprimirPista(){
        for(int i = 0;i<Simulador.getQtidVeiculos();i++){
            this.getVeiculos()[i].geraDesenho();
        }
    }

    public String toString(){
        return "ebaaa";
    }



    public static int getQtidVeiculos() {
        return Simulador.qtidVeiculos;
    }

    public static void setQtidVeiculos(int qtidVeiculos) {

        if(Simulador.getQtidVeiculos()>=20){
            System.out.println("Impossivel completar operacao, o vetor esta cheio");
        }else{
            Simulador.qtidVeiculos = qtidVeiculos;
        }
    }


    public Veiculo[] getVeiculos(){
        return veiculos;
    }
    public void setVeiculos(Veiculo veiculo) {
        this.veiculos[Simulador.getQtidVeiculos()] = veiculo;
    }
}
