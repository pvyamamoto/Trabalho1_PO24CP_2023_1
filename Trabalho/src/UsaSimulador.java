import java.util.Scanner;
import java.io.File;

public class UsaSimulador {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int opcao = 0;
        int auxId;
        Simulador simulador = new Simulador();


        do{
            System.out.println(" =====        Menu        ====== ");
            System.out.println(" ===== Escolha uma Opcao Abaixo ====== ");
            System.out.println("1 - Incluir Veiculo");
            System.out.println("2 - Remover Veiculo");
            System.out.println("3 - Abastecer Veiculo");
            System.out.println("4 - Paga IPVA de um veiculo");
            System.out.println("5 - Paga IPVA de todos os veiculos");
            System.out.println("6 - Movimentar um Veiculo");
            System.out.println("7 - Movimentar Todos os Veiculos");
            System.out.println("8 - Imprimir Dados de um Veiculo");
            System.out.println("9 - Imprimir Dados de todos os Veiculos");
            System.out.println("10 - Calibrar Pneu Especifico");
            System.out.println("11 - Calibrar Todos os Pneus de um Carro");
            System.out.println("12 - Calibrar Todos os Pneus de Todos os Carros");
            System.out.println("13 - Imprimir Pista de Corrida");
            System.out.println("14 - Gravar Veiculos em um Arquivo");
            System.out.println("15 - Ler Veiculos de um Arquivo");
            System.out.println("16 - Sair da Aplicacao");
            opcao = teclado.nextInt();

            switch(opcao){
                case 1:
                    if(Simulador.getQtidVeiculos() < simulador.getMaxVeiculos()) {
                        simulador.incluirVeiculo();
                        System.out.println("O veiculo " + simulador.getVeiculos()[Simulador.getQtidVeiculos() - 1].getId() + " foi adicionado");
                    }else{
                        System.out.println("Quantidade maxima de veiculos atingida!");
                    }
                    break;
                case 2:
                    System.out.println("Informe o id do veiculo que voce deseja remover:");
                    auxId = teclado.nextInt();
                    simulador.removerVeiculo(simulador.getVeiculoPos(auxId));
                    break;
                case 3:
                    System.out.println("Informe o id do veiculo que voce deseja abastecer:");
                    auxId = teclado.nextInt();
                    System.out.println("Informe quanto de combustivel gostaria de colocar:");
                    double auxD = teclado.nextDouble();
                    simulador.abastecer(auxId,auxD);
                    System.out.println("O veiculo com o id: "+auxId+" esta com "+simulador.getVeiculos()[simulador.getVeiculoPos(auxId)].getCombustivel()+" de combustivel no tanque");
                    break;
                case 4:
                    System.out.println("informe o id do veiculo que voce deseja pagar o ipva:");
                    auxId = teclado.nextInt();
                    simulador.pagaIPVA(auxId);
                    System.out.println("O veiculo com o id: "+auxId+" esta com o IPVA pago!");
                    break;
                case 5:
                    simulador.pagaTodosIPVA();
                    System.out.println("Os IPVA de todos os veiculos estao pagos!");
                    break;
                case 6:
                    System.out.println("Informe o id do veiculo que voce deseja movimentar:");
                    auxId = teclado.nextInt();
                    simulador.mover(auxId);
                    System.out.println("O veiculo com o id: "+auxId+" se moveu");
                    break;
                case 7:
                    simulador.moverTodos();
                    System.out.println("Todos os veiculos foram movidos!");
                    break;
                case 8:
                    System.out.println("Informe o id do veiculo que voce deseja saber os dados:");
                    auxId = teclado.nextInt();
                    System.out.println(simulador.getVeiculos()[simulador.getVeiculoPos(auxId)].toString());
                    break;
                case 9:
                    System.out.println("Os carros sao os seguintes:\n");
                    for(int i = 0; i < Simulador.getQtidVeiculos(); i++){
                        System.out.println(simulador.getVeiculos()[i].toString());
                    }
                    break;
                case 10:
                    System.out.println("Informe o id do veiculo que voce deseja calibrar o pneu:");
                    auxId = teclado.nextInt();
                    System.out.println("Informe o pneu do carro (1-4):");
                    int pneu = teclado.nextInt();
                    simulador.getVeiculos()[simulador.getVeiculoPos(auxId)].getRodas()[pneu].setCalibragemPneu(true);
                    System.out.println("O pneu "+pneu+", do carro "+auxId+" esta calibrado!");
                    break;
                case 11:
                    System.out.println("Informe o id do veiculo que voce deseja calibrar os pneus:");
                    auxId = teclado.nextInt();
                    for(int i=0;i<simulador.getVeiculos()[simulador.getVeiculoPos(auxId)].getQuantidadeRodas();i++){
                        simulador.getVeiculos()[simulador.getVeiculoPos(auxId)].getRodas()[i].setCalibragemPneu(true);
                    }
                    System.out.println("Todos os pneus do carro "+auxId+" foram calibrados");
                    break;
                case 12:
                    for(int i = 0; i< Simulador.getQtidVeiculos(); i++)
                        for(int j=0; j<simulador.getVeiculos()[i].getQuantidadeRodas(); j++){
                            simulador.getVeiculos()[i].getRodas()[j].setCalibragemPneu(true);
                        }
                    System.out.println("Todos os pneus de todos os carros foram calibrados");
                    break;
                case 13:
                    simulador.imprimirPista();
                    break;
                case 14:
                    File fileVeiculos = new File("/Desktop/veiculos.txt");
                    try{
                        if(!fileVeiculos.exists()){
                            fileVeiculos.createNewFile();
                        }
                    }
                    System.out.println("Os veiculos foram Gravados");
                    break;
                case 15:
                    System.out.println("Informe o arquivo que será lido");
                    break;
                case 16:
                    System.out.println("Voce saiu da aplicacao ");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente Novamente");
            }
        }while(opcao != 16);

    }

}
