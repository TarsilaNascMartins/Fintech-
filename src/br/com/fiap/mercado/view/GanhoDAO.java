package br.com.fiap.mercado.view;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GanhoDAO {

public void incluir(Ganho ganho) {
  String incluir = "INSERT INTO T_ganho (CD_ganho, CD_MOVIMENTACAO, CD_EXTRATO, VL_MOVIMENTACAO, TP_RECEITA, NM_MOVIMENTACAO, DS_MOVIMENTACAO, DT_MOVIMENTACAO, QTD_PARCELAS) " +
      "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
  
  Conexao conexao = new Conexao();
  try {
      PreparedStatement pstmt = conexao.conectar().prepareStatement(incluir);
      pstmt.setInt(1, ganho.get_cd_ganho());
      pstmt.setInt(2, ganho.get_cd_movimentacao());
      pstmt.setInt(3, ganho.get_cd_extrato());
      pstmt.setDouble(4, ganho.get_vl_movimentacao());
      pstmt.setString(5, ganho.get_tp_receita());
      pstmt.setString(6, ganho.get_nm_movimentacao());
      pstmt.setString(7, ganho.get_ds_movimentacao());
      pstmt.setDate(8, ganho.get_dt_movimentacao());
      pstmt.setInt(9, ganho.get_qtd_parcelas());
      
      pstmt.executeUpdate();
  } catch (SQLException ex) {
      System.out.println("Erro ao inserir dados na tabela ganho: " + ex.getMessage());
  } finally {
      conexao.desconectar();
  }
}



public Ganho consultarPorMovimentacao(String cd_ganho) {
  Conexao conexao = new Conexao();
  Ganho ganho = null;
  try {
    String consulta = "SELECT * FROM T_GANHO WHERE CD_GANHO = '" + cd_ganho + "'";
    ResultSet rs = conexao.executarConsulta(consulta);

    if(rs.next()) {
      ganho = new Ganho();
      ganho.set_cd_ganho(rs.getInt("CD_GANHO"));
      ganho.set_tp_receita(rs.getString("TP_RECEITA"));
      ganho.set_cd_movimentacao(rs.getInt("CD_MOVIMENTACAO"));
      ganho.set_cd_extrato(rs.getInt("CD_EXTRATO"));
      ganho.set_nm_movimentacao(rs.getString("NM_MOVIMENTACAO"));
      ganho.set_ds_movimentacao(rs.getString("DS_MOVIMENTACAO"));
      ganho.set_vl_movimentacao(rs.getDouble("VL_MOVIMENTACAO"));
      ganho.set_dt_movimentacao(rs.getDate("DT_MOVIMENTACAO"));
      ganho.set_qtd_parcelas(rs.getInt("QTD_PARCELAS"));
      
      
    }
  } catch (SQLException ex) {
    System.out.println("Nao conseguiu consultar os dados da Tabela ganho.");
  } finally {
    conexao.desconectar();
  }

  return ganho;
}

public void alterarPorCdganho(Ganho ganho) {
  String update = "UPDATE T_ganho SET NM_MOVIMENTACAO = '" + ganho.get_nm_movimentacao() + 
  "', DS_MOVIMENTACAO = " + ganho.get_ds_movimentacao() + "WHERE CD_ganho = '" + 
 ganho.get_cd_ganho() + "'";
  Conexao conexao = new Conexao();
  conexao.executarDML(update);
}

public void excluir(Ganho ganho) {
  String delete = "DELETE FROM  T_ganho WHERE CD_ganho='" + ganho.get_cd_ganho() + "'";

  Conexao conexao = new Conexao();
  conexao.executarDML(delete);
}
}
