package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.entidade.Aluno;

public class AlunoDao extends AbstratoDao {
        public boolean adicionar (Aluno c) throws SQLException {
            boolean sucesso;
            String sql = "insert into aluno (nome, curso, nota1, nota2, nota3, nota4) values (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, c.getNome());
                stmt.setString(2, c.getCurso());
                stmt.setFloat(3, c.getNota1());
                stmt.setFloat(4, c.getNota2());
                stmt.setFloat(5, c.getNota3());
                stmt.setFloat(6, c.getNota4());

                sucesso = stmt.executeUpdate() == 1;
            } catch (SQLException e) {
                throw e;
            }

            return sucesso;

        }    
}
