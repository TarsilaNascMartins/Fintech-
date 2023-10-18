package br.com.fiap.mercado.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class GastoDAO {

    public GastoModel findById(int id) {
        GastoModel gastoModel = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM98328", "210598");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM T_GASTO WHERE ID = " + id);

            if (rs.next()) {
                gastoModel = new GastoModel();
                gastoModel.setGastoName(rs.getString("NAME"));
                gastoModel.setGastoType(rs.getString("TYPE"));
                gastoModel.setDescricao(rs.getString("DESCRICAO"));
                gastoModel.setValor(rs.getDouble("VALOR"));
                gastoModel.setDataMovimentacao(rs.getDate("DATA_MOVIMENTACAO"));
                gastoModel.setQuantidadeParcelas(rs.getInt("QUANTIDADE_PARCELAS"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gastoModel;
    }

    public List<GastoModel> findAll() {
        List<GastoModel> listGasto = new ArrayList<GastoModel>();

        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM98328", "210598");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM T_GASTO");

            while (rs.next()) {
                GastoModel gastoModel = new GastoModel();
                gastoModel.setGastoName(rs.getString("NAME"));
                gastoModel.setGastoType(rs.getString("TYPE"));
                gastoModel.setDescricao(rs.getString("DESCRICAO"));
                gastoModel.setValor(rs.getDouble("VALOR"));
                gastoModel.setDataMovimentacao(rs.getDate("DATA_MOVIMENTACAO"));
                gastoModel.setQuantidadeParcelas(rs.getInt("QUANTIDADE_PARCELAS"));

                listGasto.add(gastoModel);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn = null;
        }

        return listGasto;
    }

    public void insert(GastoModel gastoModel) {
        String SQL1 =
                "INSERT INTO T_GASTO(ID, NAME, TYPE, DESCRICAO, VALOR, DATA_MOVIMENTACAO, QUANTIDADE_PARCELAS)"
                        + " VALUES (T_GASTO_SEQ.nextval, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM98328", "210598");
            PreparedStatement ptmt = conn.prepareStatement(SQL1);

            ptmt.setString(1, gastoModel.getGastoName());
            ptmt.setString(2, gastoModel.getGastoType());
            ptmt.setString(3, gastoModel.getDescricao());
            ptmt.setDouble(4, gastoModel.getValor());
            ptmt.setDate(5, gastoModel.getDataMovimentacao());
            ptmt.setInt(6, gastoModel.getQuantidadeParcelas());

            ptmt.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn = null;
        }
    }

    public void update(GastoModel gastoModel) {
        String SQL1 =
            "UPDATE T_GASTO SET NAME = ?, TYPE = ?, DESCRICAO = ?, VALOR = ?, DATA_MOVIMENTACAO = ?, QUANTIDADE_PARCELAS = ? WHERE ID = ?";

        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM98328", "210598");
            PreparedStatement ptmt = conn.prepareStatement(SQL1);

            ptmt.setString(1, gastoModel.getGastoName());
            ptmt.setString(2, gastoModel.getGastoType());
            ptmt.setString(3, gastoModel.getDescricao());
            ptmt.setDouble(4, gastoModel.getValor());
            ptmt.setDate(5, gastoModel.getDataMovimentacao());
            ptmt.setInt(6, gastoModel.getQuantidadeParcelas());
            ptmt.setInt(7, gastoModel.getId()); // Adicione o ID para a cl�usula WHERE

            ptmt.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn = null;
        }
    }

    
    
    
    
    

    public void delete(int id) {
        // Implemente a exclus�o de um gasto com base no ID
    }
}

