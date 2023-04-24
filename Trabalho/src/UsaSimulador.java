
import java.util.Scanner;

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
            System.out.println("5 - Movimentar um Veiculo");
            System.out.println("6 - Movimentar Todos os Veiculos");
            System.out.println("7 - Imprimir Dados de um Veiculo");
            System.out.println("8 - Imprimir Dados de todos os Veiculos");
            System.out.println("9 - Calibrar Pneu Especifico");
            System.out.println("10 - Calibrar Todos os Pneus de um Carro");
            System.out.println("11 - Imprimir Pista de Corrida");
            System.out.println("12 - Gravar Veiculos em um Arquivo");
            System.out.println("13 - Ler Veiculos de um Arquivo");
            System.out.println("14 - Sair da Aplicacao");
            opcao = teclado.nextInt();

            switch(opcao){
                case 1:
                    simulador.incluirVeiculo();
                    System.out.println("O veiculo "+simulador.getVeiculos()[simulador.getQtidVeiculos()].getId()+" foi adicionado");
                    break;
                case 2:
                    System.out.println("Informe o id do veiculo que voce deseja remover:");
                    auxId = teclado.nextInt();
                    simulador.removerVeiculo(auxId);
                    System.out.println("O veiculo com o id: "+auxId+" foi removido");
                    break;
                case 3:
                    System.out.println("Informe o id do veiculo que voce deseja abastecer:");
                    auxId = teclado.nextInt();
                    System.out.println("Informe quanto de gasolina gostaria de colocar:");
                    double auxD = teclado.nextDouble();
                    simulador.abastecer(auxId,auxD);
                    System.out.println("O veiculo com o id: "+auxId+" esta com "+simulador.getVeiculos()[auxId].getCombustivel()+" de gasolina no tanque");
                    break;
                case 4:
                    System.out.println("informe o id do veiculo que voce deseja pagar o ipva:");
                    auxId = teclado.nextInt();
                    simulador.pagaIPVA(auxId);
                    System.out.println("O veiculo com o id: "+auxId+" esta com o IPVA pago!");
                    break;
                case 5:
                    System.out.println("Informe o id do veiculo que voce deseja movimentar:");
                    auxId = teclado.nextInt();
                    simulador.mover(auxId);
                    System.out.println("O veiculo com o id: "+auxId+" se moveu");
                    break;
                case 6:
                    simulador.moverTodos();
                    System.out.println("Todos os veiculos foram movidos!");
                    break;
                case 7:
                    System.out.println("Informe o id do veiculo que voce deseja saber os dados:");
                    auxId = teclado.nextInt();
                    System.out.println(simulador.getVeiculos()[auxId].toString());
                    break;
                case 8:
                    System.out.println("Os carros sao os seguintes:");
                    for(int i=0;i<simulador.getVeiculos().length;i++){
                        System.out.println(simulador.getVeiculos()[i].toString());
                    }
                    break;
                case 9:
                    System.out.println("Informe o id do veiculo que voce deseja calibrar o pneu:");
                    auxId = teclado.nextInt();
                    System.out.println("Informe o pneu do carro (1-4):");
                    int pneu = teclado.nextInt();
                    simulador.getVeiculos()[auxId].getRodas()[pneu].setCalibragemPneu(true);
                    System.out.println("O pneu "+pneu+", do carro "+auxId+" esta calibrado!");
                    break;
                case 10:
                    System.out.println("Informe o id do veiculo que voce deseja calibrar os pneus:");
                    auxId = teclado.nextInt();
                    for(int i=0;i<simulador.getVeiculos()[auxId].getRodas().length;i++){
                        simulador.getVeiculos()[auxId].getRodas()[i].setCalibragemPneu(true);
                    }
                    System.out.println("Todos os pneus do carro "+auxId+" foram calibrados");
                    break;
                case 11:
                    simulador.imprimirPista();
                    break;
                case 12:
                    System.out.println("Os veiculos foram Gravados");
                    break;
                case 13:
                    System.out.println("Informe o arquivo que será lido");
                    break;
                case 14:
                    System.out.println("Voce saiu da aplicacao ");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente Novamente");
            }
        }while(opcao != 14);

    }

}
