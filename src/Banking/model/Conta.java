package Banking.model;

import java.util.ArrayList;

public class Conta {
    private static int nextId = 1;
    private final int id;
    private String usuario;
    private String senha;
    private double saldo;
    private int tentativas;
    private long proximoPodeAcessar;
    private ArrayList<Movimentacao> movimentacaos;

    public Conta(String nome, String senha) {
        this.id = nextId;
        this.usuario = nome;
        this.senha = senha;
        this.saldo = 0;
        this.tentativas = 3;
        this.movimentacaos = new ArrayList<>();
        nextId++;
    }

    public int getId() {return this.id;}
    public String getUsuario() {return this.usuario;}
    public boolean tryAcessar(String senha) {
        return this.senha.equals(senha);
    }

    public int getTentativas() {return tentativas;}

    public void subTentativas() {
        long agora = System.currentTimeMillis();

        if (this.tentativas > 0) {
            this.tentativas--;

            if (this.tentativas == 0) {
                this.proximoPodeAcessar = agora + 1000 * 60 * 10;
                System.out.println("Você foi bloqueado por 10 minutos.");
            }

        } else {
            if (agora >= this.proximoPodeAcessar) {
                this.tentativas = 3;
                this.proximoPodeAcessar = 0;
                System.out.println("Tentativas liberadas novamente.");
            } else {
                long tempoRestante = (this.proximoPodeAcessar - agora) / 1000;
                System.out.println("Aguarde " + tempoRestante + " segundos para tentar novamente.");
            }
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Não é permitido depositar valores negativos!");
            return;
        }
        this.saldo += valor;
        movimentacaos.add(new Movimentacao(Movimentacao.Tipo.DEPOSITO, valor));
    }

    public void sacar(double valor) {
        if (valor <= 0 || valor > this.saldo) {
            System.out.println("Não é permitido sacar valores negativos ou mais do que você tem!");
            return;
        }

        this.saldo -= valor;
        movimentacaos.add(new Movimentacao(Movimentacao.Tipo.SAQUE, valor));
    }

    public void getMovimentacoes() {
        for (Movimentacao movimentacao : movimentacaos) {
            System.out.println(movimentacao);
        }
    }
}