package Banking.model;

public class Conta {
    private static int nextId = 1;
    private final int id;
    private String usuario;
    private String senha;
    private double saldo;
    private int tentativas;

    public Conta(String nome, String senha) {
        this.id = nextId;
        this.usuario = nome;
        this.senha = senha;
        this.saldo = 0;
        this.tentativas = 3;
        nextId++;
    }

    public int getId() {return this.id;}
    public String getUsuario() {return this.usuario;}
    public boolean tryAcessar(String senha) {
        return this.senha.equals(senha);
    }

    public int getTentativas() {return tentativas;}

    public void subTentativas() {
        if (!(this.tentativas <= 0)) {
            this.tentativas--;
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
    }

    public void sacar(double valor) {
        if (valor <= 0 || valor > this.saldo) {
            System.out.println("Não é permitido sacar valores negativos ou mais do que você tem!");
            return;
        }

        this.saldo -= valor;
    }
}