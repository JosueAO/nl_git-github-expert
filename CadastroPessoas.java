import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public record Pessoa(String nome, int idade, String cpf) {}

public class CadastroPessoas {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Cadastro de Pessoas ===");
            System.out.println("1. Cadastrar pessoa");
            System.out.println("2. Listar pessoas cadastradas");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.print("Nome: ");
                String nome = scanner.next();

                System.out.print("Idade: ");
                int idade = scanner.nextInt();

                System.out.print("CPF: ");
                String cpf = scanner.next();

                // Remove caracteres não numéricos do CPF
                cpf = cpf.replaceAll("\\D", "");

                // Formata o CPF com a máscara
                cpf = cpf.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");

                Pessoa pessoa = new Pessoa(nome, idade, cpf);
                pessoas.add(pessoa);

                System.out.println("Pessoa cadastrada com sucesso!\n");
            } else if (opcao == 2) {
                if (pessoas.isEmpty()) {
                    System.out.println("Nenhuma pessoa cadastrada.\n");
                } else {
                    System.out.println("=== Pessoas Cadastradas ===");
                    for (Pessoa pessoa : pessoas) {
                        System.out.println("Nome: " + pessoa.nome());
                        System.out.println("Idade: " + pessoa.idade());
                        System.out.println("CPF: " + pessoa.cpf());
                        System.out.println("-----------------------");
                    }
                    System.out.println();
                }
            } else if (opcao == 3) {
                System.out.println("Saindo do programa...");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.\n");
            }
        }

        scanner.close();
    }
}
