import java.util.List;
import java.util.Scanner;

public class SistemaBancario { // Aplicação bancária executada no console

    static Scanner leia = new Scanner(System.in); // Scanner global para entrada de dados

    public static void main(String[] args) {

        int menu = 0; // Controla o menu principal

        BancoServico bancoServico = new BancoServico(); // Fornece as contas cadastradas
        List<Conta> contas = bancoServico.getContas(); // Lista de contas do banco

        Conta usuarioLogado = autenticarUsuario(contas); // Usuário autenticado no sistema

        while (menu != 5) { // Mantém o menu aberto até o usuário escolher sair

            System.out.println("Bem-vindo ao Banco ADS, " + usuarioLogado.getTitular());
            System.out.println("1 - Ver saldo");
            System.out.println("2 - Sacar");
            System.out.println("3 - Depositar na própria conta");
            System.out.println("4 - Transferir para outra conta");
            System.out.println("5 - Sair");

            menu = leia.nextInt();
            leia.nextLine(); // Limpa o buffer

            switch (menu) {

                case 1:
                    verSaldo(usuarioLogado);
                    break;

                case 2:
                    sacar(usuarioLogado);
                    break;

                case 3:
                    depositar(usuarioLogado);
                    break;

                case 4:
                    transferir(usuarioLogado, contas);
                    break;

                case 5:
                    System.out.println("Saindo do sistema... Banco ADS agradece sua visita!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static Conta autenticarUsuario(List<Conta> contas) { // Autentica o usuário antes de liberar o menu

        while (true) {

            System.out.println("\n=== LOGIN ===");

            System.out.print("Agência: ");
            String agencia = leia.nextLine();

            System.out.print("Conta: ");
            String numConta = leia.nextLine();

            System.out.print("Senha: ");
            String senha = leia.nextLine();

            Conta conta = buscarConta(agencia, numConta, contas); // Procura a conta informada

            if (conta != null && conta.getSenha().equals(senha)) {
                System.out.println("Login realizado com sucesso!");
                return conta;
            }

            System.out.println("Credenciais inválidas ou conta não encontrada.\n");
        }
    }

    private static void verSaldo(Conta usuario) { // Exibe o saldo da conta autenticada
        System.out.println("Saldo atual: R$ " + usuario.getSaldo());
    }

    private static void sacar(Conta usuario) { // Solicita e realiza um saque

        System.out.println("Saldo atual: R$ " + usuario.getSaldo());

        System.out.print("Digite o valor do saque: R$ ");
        double valor = leia.nextDouble();
        leia.nextLine(); // Limpa o buffer

        usuario.sacar(valor);

        System.out.println("Novo saldo: R$ " + usuario.getSaldo());
    }

    private static void depositar(Conta usuario) { // Solicita e realiza um depósito

        System.out.println("Saldo atual: R$ " + usuario.getSaldo());

        System.out.print("Digite o valor do depósito: R$ ");
        double valor = leia.nextDouble();
        leia.nextLine(); // Limpa o buffer

        usuario.depositar(valor);

        System.out.println("Novo saldo: R$ " + usuario.getSaldo());
    }

    private static void transferir(Conta usuario, List<Conta> contas) {

        Conta destino = null;
        boolean destinatarioValido = false;

        while (!destinatarioValido) {

            System.out.print("Agência destino: ");
            String agencia = leia.nextLine().trim();

            System.out.print("Conta destino: ");
            String numConta = leia.nextLine().trim();

            destino = buscarConta(agencia, numConta, contas);

            destinatarioValido = validarDestinatario(usuario, destino);
        }

        System.out.println("Cliente encontrado: " + destino.getTitular());

        System.out.print("Valor da transferência: R$ ");
        double valor = leia.nextDouble();
        leia.nextLine(); // Limpa o buffer

        if (valor <= 0) {
            System.out.println("O valor deve ser maior que zero!");
            return;
        }

        if (valor > usuario.getSaldo()) {
            System.out.println("Saldo insuficiente!");
            return;
        }

        usuario.sacar(valor);
        destino.depositar(valor);

        System.out.println("Transferência realizada com sucesso!");
        System.out.println("Seu saldo atual: R$ " + usuario.getSaldo());
    }

    private static boolean validarDestinatario(
            Conta usuario,
            Conta destino
    ) {

        if (destino == null) {
            System.out.println("Conta não encontrada! Digite novamente.\n");
            return false;
        }

        if (usuario == destino) {
            System.out.println(
                    "Não é possível transferir para a própria conta! Digite outra conta.\n"
            );
            return false;
        }

        return true;
    }


    private static Conta buscarConta(String agencia, String numConta, List<Conta> contas) { // Busca por agência e conta

        for (Conta c : contas) {
            if (c.getAgencia().equals(agencia) && c.getNumConta().equals(numConta)) {
                return c;
            }
        }

        return null; // Nenhuma conta encontrada
    }

    private static Conta autenticar(Conta conta, String senha) { // Metodo autenticar para futuras melhoris
        if (conta != null && conta.getSenha().equals(senha)) {
            return conta;
        }

        return null;
    }
}

