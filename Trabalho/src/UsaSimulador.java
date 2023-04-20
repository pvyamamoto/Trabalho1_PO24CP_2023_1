package Trabalho1_PO24CP_2023_1.Trabalho.src;

import java.util.Scanner;

public class UsaSimulador {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int opcao = 0;
        int auxId;
        Simulador simulador = new Simulador();


        do{
            System.out.println(" =====        Menu        ====== ");
            System.out.println(" ===== Escolha uma Opcao Abaxio ====== ");
            System.out.println("1 - Incluir Veiculo");
            System.out.println("2 - Remover Veiculo");
            System.out.println("3 - Abastecer Veiculo");
            System.out.println("4 - Movimentar um Veiculo");
            System.out.println("5 - Movimentar Todos os Veiculos");
            System.out.println("6 - Imprimir Dados de um Veiculo");
            System.out.println("7 - Imprimir Dados de todos os Veiculos");
            System.out.println("8 - Calibrar Pneu Especifico");
            System.out.println("9 - Calibrar Todos os Pneus de um Carro");
            System.out.println("10 - Imprimir Pista de Corrida");
            System.out.println("11 - Gravar Veiculos em um Arquivo");
            System.out.println("12 - Ler Veiculos de um Arquivo");
            System.out.println("13 - Sair da Aplicacao");
            opcao = teclado.nextInt();

            switch(opcao){
                case 1:
                    simulador.incluirVeiculo();
                    System.out.println("O veiculo "+simulador.getVeiculos()+" foi adicionado");
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
                    simulador.abastecer(auxId);
                    System.out.println("O veiculo com o id: "+auxId+" esta com "+simulador.getVeiculos()[auxId].getCombustivel()+" de gasolina no tanque");
                    break;
                case 4:
                    System.out.println("Informe o id do veiculo que voce deseja movimentar:");
                    auxId = teclado.nextInt();
                    simulador.mover(auxId);
                    System.out.println("O veiculo com o id: "+auxId+" se moveu");
                    break;
                case 5:
                    simulador.mover();
                    System.out.println("Todos os veiculos foram movidos!");
                    break;
                case 6:
                    System.out.println("Informe o id do veiculo que voce deseja saber os dados:");
                    auxId = teclado.nextInt();
                    simulador.getVeiculos()[auxId].toString();
                    break;
                case 7:
                    System.out.println("Os carros sao os seguintes:");
                    for(int i=0;i<simulador.getVeiculos().length;i++){
                        System.out.println(simulador.getVeiculos()[i].toString());
                    }
                    break;
                case 8:
                    System.out.println("Informe o id do veiculo que voce deseja calibrar o pneu:");
                    auxId = teclado.nextInt();
                    System.out.println("Informe o pneu do carro (1-4):");
                    int pneu = teclado.nextInt();
                    simulador.getVeiculos()[auxId].getRodas()[pneu].setCalibragemPneu(true);
                    System.out.println("O pneu "+pneu+", do carro "+auxId+" esta calibrado!");
                    break;
                case 9:
                    System.out.println("Informe o id do veiculo que voce deseja calibrar os pneus:");
                    auxId = teclado.nextInt();
                    for(int i=0;i<simulador.getVeiculos()[auxId].getRodas().length;i++){
                        simulador.getVeiculos()[auxId].getRodas()[i].setCalibragemPneu(true);
                    }
                    System.out.println("Todos os pneus do carro "+auxId+" foram calibrados");
                    break;
                case 10:
                    simulador.imprimirPista();
                    break;
                case 11:
                    System.out.println("Os veiculos foram Gravados");
                    break;
                case 12:
                    System.out.println("Informe o arquivo que será lido");
                    break;
                case 13:
                    System.out.println("Voce saiu da aplicacao ");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente Novamente");
            }






        }while(opcao != 13);










    }

}
