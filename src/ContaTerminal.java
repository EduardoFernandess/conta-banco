import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Entrada para o número da conta com tratamento de erro
        int numConta = -1;
        while (numConta == -1) {
            try {
                System.out.println("Por favor, digite o número da sua conta:");
                numConta = sc.nextInt();
                sc.nextLine();  // limpa o buffer
            } catch (Exception e) {
                System.out.println("Por favor, insira um número de conta válido.");
                sc.nextLine();  // limpa a entrada inválida
            }
        }

        // Entrada para o número da agência com tratamento de erro (verifica se é um número)
        String numAgencia = "";
        while (true) {
            try {
                System.out.println("Por favor, digite o número da agência:");
                numAgencia = sc.nextLine();
                
                // Verifica se a entrada contém apenas números
                if (!numAgencia.matches("[0-9]+")) {
                    throw new Exception("O número da agência deve ser composto apenas por números.");
                }
                break;  // Sai do loop se a entrada for válida
            } catch (Exception e) {
                System.out.println("input inválido: " + e.getMessage());
            }
        }

        // Entrada para o nome do cliente com tratamento de erro
        String nomeCliente = "";
        while (nomeCliente.isEmpty()) {
            try {
                System.out.println("Por favor, digite seu nome:");
                nomeCliente = sc.nextLine();
                if (nomeCliente.trim().isEmpty()) {
                    throw new Exception("Nome não pode ser vazio.");
                }
            } catch (Exception e) {
                System.out.println(" Por favor, insira seu nome corretamente.");
            }
        }

        // Entrada para o valor do depósito inicial com tratamento de erro
        double saldo = -1.0;
        while (saldo == -1.0) {
            try {
                System.out.println("Por favor, insira o valor de depósito inicial para saldo:");
                String saldoStr = sc.nextLine();
                // Substitui a vírgula por ponto final para tratar o valor decimal
                saldoStr = saldoStr.replace(',', '.');
                saldo = Double.parseDouble(saldoStr);
                if (saldo < 0) {
                    throw new Exception("O valor do depósito não pode ser negativo.");
                }
            } catch (Exception e) {
                System.out.println("Por favor, insira um valor de depósito válido.");
            }
        }

        // Exibe o resultado
        String resultado = "Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, " +
                            "sua agência é " + numAgencia + ", conta " + numConta + " e seu saldo " +
                            saldo + " já está disponível para saque.";

        System.out.println(resultado);

        sc.close();
    }
}
