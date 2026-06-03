package Banking.app;

import Banking.model.Conta;
import Banking.service.ContaService;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        ContaService service = new ContaService();
        Scanner scanner = new Scanner(System.in);

        int op;
        Conta contaAtual = null;

        while (true) {

            if (contaAtual == null) {

                String nomeDaConta;
                String senhaDaConta;

                System.out.println("\n=== Banking Account ===\n" + "1 - Entra na conta\n" + "2 - Criar uma conta\n" + "3 - Sair do programa");
                op = scanner.nextInt();
                scanner.nextLine();
                switch (op) {
                    case 1:
                        System.out.print("Usuário: ");
                        nomeDaConta = scanner.nextLine();
                        System.out.print("Senha: ");
                        senhaDaConta = scanner.next();
                        contaAtual = service.entrarConta(nomeDaConta, senhaDaConta);
                        break;
                    case 2:
                        System.out.print("Usuário: ");
                        nomeDaConta = scanner.nextLine();
                        System.out.print("Senha: ");
                        senhaDaConta = scanner.next();
                        service.criarConta(nomeDaConta, senhaDaConta);
                        break;
                    case 3:
                        System.out.println("Saindo");
                        return;
                    default:
                        System.out.println("Opção inválida");
                }
            } else {
                System.out.println("\n=== Banking Account ===\n" + "1 - Consultar saldo\n" + "2 - Depositar dinheiro\n" + "3 - Sacar dinheiro\n" + "4 - Historico de movimentação\n" + "5 - Encerrar sessão\n" + "Ação: ");
                op = scanner.nextInt();
                scanner.nextLine();

                double deposito;
                double sacar;

                switch (op) {
                    case 1:
                        System.out.println("Saldo: R$" + contaAtual.getSaldo());
                        break;
                    case 2:
                        System.out.print("Digite a quantidade que deseja depositar: ");
                        deposito = scanner.nextDouble();
                        contaAtual.depositar(deposito);
                        break;
                    case 3:
                        System.out.print("Digite a quantidade que deseja sacar: ");
                        sacar = scanner.nextDouble();
                        contaAtual.sacar(sacar);
                        break;
                    case 4:
                        contaAtual.getMovimentacoes();
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        contaAtual = null;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            }
        }
    }
}