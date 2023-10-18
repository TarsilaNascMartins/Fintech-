
import java.sql.SQLException;

import java.util.Date;

public class GastoPostView {

    public static void main(String[] args) throws SQLException {
        GastoModel model = new GastoModel();
        
        model.setGastoName("Conta de Luz 2222222222");
        model.setGastoType("Contas22222222");
        model.setDescricao("M�s de Outubro222222222222");
        model.setValor(56.32);
        model.setDataMovimentacao(new Date()); // Data atual, voc� pode personalizar isso.
        model.setQuantidadeParcelas(1);

        GastoDAO dao = new GastoDAO();
        dao.insert(model);
    }
}
