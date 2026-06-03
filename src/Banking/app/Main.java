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

        while (contaAtual == null) {

            String nomeDaConta;
            String senhaDaConta;

            System.out.println("\n=== Banking Account ===\n" + "1 - Entra na conta\n" + "2 - Criar uma conta");
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
                default:
                    System.out.println("Opção inválida");
            }
        }

        while (contaAtual != null) {
            System.out.println("\n=== Banking Account ===\n" + "1 - Consultar saldo\n" + "2 - Depositar dinheiro\n" + "3 - Sacar dinheiro\n" + "4 - Encerrar sessão\n" + "Ação: ");
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
                case 3:
                case 4:
                default:
            }
        }


    }
}