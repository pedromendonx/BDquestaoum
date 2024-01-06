package visaoTerminal;
import java.sql.SQLException;
import java.util.Scanner;

import modelo.dao.AlunoDao;
import modelo.entidade.Aluno;

public class Principal {
public static void main(String[] args) throws SQLException {
    Scanner teclado = new Scanner(System.in);

    while (true) {
        System.out.println("Adicionar aluno: Clique 1");
        int opcao = teclado.nextInt();
        teclado.nextLine();

        if (opcao == 0) {
            System.out.println("Programa encerrado...");
            break;
        }
        if (opcao == 1) {
            Aluno c = new Aluno();

            System.out.println("Digite o nome do aluno: ");
            c.setNome(teclado.nextLine());
            System.out.println("Digite o nome do curso do aluno: ");
            c.setCurso(teclado.nextLine());

            System.out.println("Digite a nota do 1 bimestre do aluno: ");
            c.setNota1(teclado.nextInt());
            System.out.println("Digite a nota do 2 bimestre do aluno: ");
            c.setNota2(teclado.nextInt());
            System.out.println("Digite a nota do 3 bimestre do aluno: ");
            c.setNota3(teclado.nextInt());
            System.out.println("Digite a nota do 4 bimestre do aluno: ");
            c.setNota4(teclado.nextInt());

            try (AlunoDao dao = new AlunoDao()) {
                if (dao.adicionar(c)) {
                    System.out.println("Aluno salvo com sucesso!");
                    System.out.println("------------------------------------------------");
                    System.out.println("Aperte 1 novamente para adicionar outro aluno: ");
                    System.out.println("Aperte 0 para encerrar o programa: ");
                }else{
                    System.err.println("Erro ao salvar o aluno!");
                }
            } 
        } else {
            System.err.println("Opção Errada!!");
        }
    }
    teclado.close();
}
}
