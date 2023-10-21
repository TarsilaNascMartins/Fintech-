package br.com.fiap.mercado.view;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InvestimentoDAO {
    public void incluir(Investimento investimento) {
        String incluir = "INSERT INTO T_INVESTIMENTO (CD_INVESTIMENTO, DS_INVESTIMENTO, VL_INVESTIMENTO, DT_INVESTIMENTO, CD_USUARIO) " +
            "VALUES (?, ?, ?, ?, ?)";
        
        Conexao conexao = new Conexao();
        try {
            PreparedStatement pstmt = conexao.conectar().prepareStatement(incluir);
            pstmt.setInt(1, investimento.get_cd_investimento());
            pstmt.setString(2, investimento.get_ds_investimento());
            pstmt.setDouble(3, investimento.get_vl_investimento());
            pstmt.setDate(4, (Date) investimento.get_dt_investimento());
            pstmt.setInt(5, investimento.get_cd_usuario());
            
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir dados na tabela Investimento: " + ex.getMessage());
        } finally {
            conexao.desconectar();
        }
    }

    public Investimento consultarPorMovimentacao(String cd_investimento) {
        Conexao conexao = new Conexao();
        Investimento investimento = null;
        try {
            String consulta = "SELECT * FROM T_INVESTIMENTO WHERE CD_INVESTIMENTO = ?";
            PreparedStatement pstmt = conexao.conectar().prepareStatement(consulta);
            pstmt.setString(1, cd_investimento);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                investimento = new Investimento();
                investimento.set_cd_investimento(rs.getInt("CD_INVESTIMENTO"));
                investimento.set_ds_investimento(rs.getString("DS_INVESTIMENTO"));
                investimento.set_vl_investimento(rs.getDouble("VL_INVESTIMENTO"));
                investimento.set_dt_investimento(rs.getDate("DT_INVESTIMENTO"));
                investimento.set_cd_usuario(rs.getInt("CD_USUARIO"));
            }
        } catch (SQLException ex) {
            System.out.println("Nao conseguiu consultar os dados da Tabela Investimento: " + ex.getMessage());
        } finally {
            conexao.desconectar();
        }

        return investimento;
    }

    public void alterarPorCdInvestimento(Investimento investimento) {
        String update = "UPDATE T_INVESTIMENTO SET DS_INVESTIMENTO = ?, VL_INVESTIMENTO = ?, DT_INVESTIMENTO = ?, CD_USUARIO = ? WHERE CD_INVESTIMENTO = ?";
        Conexao conexao = new Conexao();
        try {
            PreparedStatement pstmt = conexao.conectar().prepareStatement(update);
            pstmt.setString(1, investimento.get_ds_investimento());
            pstmt.setDouble(2, investimento.get_vl_investimento());
            pstmt.setDate(3, (Date) investimento.get_dt_investimento());
            pstmt.setInt(4, investimento.get_cd_usuario());
            pstmt.setInt(5, investimento.get_cd_investimento());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar dados da tabela Investimento: " + ex.getMessage());
        } finally {
            conexao.desconectar();
        }
    }

    public void excluir(Investimento investimento) {
        String delete = "DELETE FROM T_INVESTIMENTO WHERE CD_INVESTIMENTO = ?";
        Conexao conexao = new Conexao();
        try {
            PreparedStatement pstmt = conexao.conectar().prepareStatement(delete);
            pstmt.setInt(1, investimento.get_cd_investimento());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir dados da tabela Investimento: " + ex.getMessage());
        } finally {
            conexao.desconectar();
        }
    }
}

