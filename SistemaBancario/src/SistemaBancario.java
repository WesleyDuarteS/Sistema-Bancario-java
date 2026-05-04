import java.util.List;
import java.util.Scanner;

/**
 * Sistema bancário simples (console)
 * Funcionalidades:
 * - Login de usuário
 * - Consulta de saldo
 * - Saque
 * - Depósito
 * - Transferência entre contas
 */
public class SistemaBancario {

    // Scanner global para entrada de dados
    static Scanner leia = new Scanner(System.in);

    public static void main(String[] args) {

        int menu = 0;

        // Serviço responsável pelas contas cadastradas
        BancoServico bancoServico = new BancoServico();
        List<Conta> contas = bancoServico.getContas();

        // Usuário autenticado
        Conta usuarioLogado = autenticarUsuario(contas);

        // MENU PRINCIPAL
        while (menu != 5) {

            System.out.println("\nBem-vindo ao Banco ADS, " + usuarioLogado.getTitular());
            System.out.println("1 - Ver saldo");
            System.out.println("2 - Sacar");
            System.out.println("3 - Depositar na própria conta");
            System.out.println("4 - Transferir para outra conta");
            System.out.println("5 - Sair");

            menu = leia.nextInt();
            leia.nextLine(); // limpar buffer

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

    /**
     * Realiza autenticação do usuário antes de acessar o sistema
     */
    private static Conta autenticarUsuario(List<Conta> contas) {

        while (true) {

            System.out.println("\n=== LOGIN ===");

            System.out.print("Agência: ");
            String agencia = leia.nextLine();

            System.out.print("Conta: ");
            String numConta = leia.nextLine();

            System.out.print("Senha: ");
            String senha = leia.nextLine();

            Conta conta = buscarConta(agencia, numConta, contas);

            // valida login
            if (conta != null && conta.getSenha().equals(senha)) {
                System.out.println("Login realizado com sucesso!");
                return conta;
            }

            System.out.println("Credenciais inválidas ou conta não encontrada.\n");
        }
    }

    /**
     * Mostra saldo da conta
     */
    private static void verSaldo(Conta usuario) {
        System.out.println("Saldo atual: R$ " + usuario.getSaldo());
    }

    /**
     * Realiza saque
     */
    private static void sacar(Conta usuario) {

        System.out.println("Saldo atual: R$ " + usuario.getSaldo());

        System.out.print("Digite o valor do saque: R$ ");
        double valor = leia.nextDouble();
        leia.nextLine();

        usuario.sacar(valor);

        System.out.println("Novo saldo: R$ " + usuario.getSaldo());
    }

    /**
     * Realiza depósito na própria conta
     */
    private static void depositar(Conta usuario) {

        System.out.println("Saldo atual: R$ " + usuario.getSaldo());

        System.out.print("Digite o valor do depósito: R$ ");
        double valor = leia.nextDouble();
        leia.nextLine();

        usuario.depositar(valor);

        System.out.println("Novo saldo: R$ " + usuario.getSaldo());
    }

    /**
     * Realiza transferência entre contas
     */
    private static void transferir(Conta usuario, List<Conta> contas) {

        System.out.print("Agência destino: ");
        String agencia = leia.nextLine().trim();

        System.out.print("Conta destino: ");
        String numConta = leia.nextLine().trim();

        Conta destino = buscarConta(agencia, numConta, contas);

        if (destino == null) {
            System.out.println("Conta não encontrada!");
            return;
        }

        System.out.println("Cliente encontrado: " + destino.getTitular());

        System.out.print("Valor da transferência: R$ ");
        double valor = leia.nextDouble();
        leia.nextLine();

        usuario.sacar(valor);
        destino.depositar(valor);

        System.out.println("Transferência realizada com sucesso!");
        System.out.println("Seu saldo: R$ " + usuario.getSaldo());
    }

    /**
     * Busca conta por agência + número
     */
    private static Conta buscarConta(String agencia, String numConta, List<Conta> contas) {

        for (Conta c : contas) {
            if (c.getAgencia().equals(agencia) &&
                    c.getNumConta().equals(numConta)) {
                return c;
            }
        }

        return null;
    }

    /**
     * Método extra de autenticação (não usado diretamente no fluxo atual)
     * Pode ser útil para futuras melhorias
     */
    private static Conta autenticar(Conta conta, String senha) {
        if (conta != null && conta.getSenha().equals(senha)) {
            return conta;
        }
        return null;
    }
}