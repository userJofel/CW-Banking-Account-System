package Banking.service;

import Banking.model.Conta;
import java.util.ArrayList;

public class ContaService {
    // @userJofel
    private final ArrayList<Conta> contas = new ArrayList<>();

    public void criarConta(String user, String password) {
        if (user == null || password == null) {
            System.out.print("O nome ou a senha não podem ser vazios!");
            return;
        }

        user = user.trim();
        password = password.trim();

        if (user.length() <= 3 || password.length() < 6) {
            System.out.print("O usuário não pode ter menos de 3 caracteres e a senha não pode ter menos de 6 caracteres!");
            return;
        }

        for (Conta conta : contas) {
            if (conta.getUsuario().equals(user)) {
                System.out.print("Já existe um usuário com esse nome!");
                return;
            }
        }

        Conta newConta = new Conta(user, password);
        System.out.print("Conta criada com sucesso!\nFaça login!");
        contas.add(newConta);
    }

    public Conta entrarConta(String user, String password) {
        for (Conta conta : contas) {
            if (conta.getUsuario().equals(user)) {

                if (conta.getTentativas() <= 0) {
                    System.out.println("Tentativas restantes: " + conta.getTentativas());
                    conta.subTentativas();
                    return null;
                }

                if (conta.tryAcessar(password)) {
                    return conta;
                } else {
                    conta.subTentativas();
                    System.out.println("Tentativas restantes: " + conta.getTentativas());
                    return null;
                }
            }
        }
        System.out.println("Usuário não encontrado!");
        return null;
    }



}
