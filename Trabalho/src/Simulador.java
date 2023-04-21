
public class Simulador {

    private Veiculo[] veiculos;
    private static int qtidVeiculos = 0;

    public void incluirVeiculo(){
        this.setQtidVeiculos(1);// adiciona 1 no set
        this.getVeiculos()[qtidVeiculos] = new Veiculo(); // inicializa um veiculo no espaço do do vetor
    }

    public void removerVeiculo(int id){
        if(this.getVeiculos()[id] == null){
            System.out.println("Veiculo inexistente!");
        }else{
            this.getVeiculos()[id] = null;
        }
    }

    public void abastecer(int id, double quant){
        this.getVeiculos()[id].setCombustivel(quant);
    }

    public void mover(int id){

    }

    public void moverTodos(){

    }

    public void imprimirPista(){

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
            Simulador.qtidVeiculos += qtidVeiculos;  // += para acionar o espaco e nao mudar, assim progredindo pelo vetor (tem que ter tratamento para o limite de veiculos)
        }
    }


    public Veiculo[] getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(Veiculo[] veiculos) {
        this.veiculos = veiculos;
    }
}
