public class Conta {
    private String titular;
    private String numConta;
    private String agencia;
    private String senha;
    private double saldo;

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumConta() {
        return numConta;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getSenha() {
        return senha;
    }


    public double getSaldo() {
        return saldo;
    }


    public void sacar (double valor){
        if(valor <= saldo &&  valor >0){
            saldo =  saldo - valor;
        }
        else{
            System.out.println("Valor de saque indispónivel!");

        }

    }
    public void depositar(double valor){
        if(valor > 0){
            saldo = saldo + valor;
        }
    }

    public Conta(String titular, String agencia, String numConta , String senha, double saldo) {
        this.titular = titular;
        this.numConta = numConta;
        this.agencia = agencia;
        this.senha = senha;
        this.saldo = saldo;
    }
}
