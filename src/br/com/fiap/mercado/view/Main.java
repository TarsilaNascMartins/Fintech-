package br.com.fiap.mercado.view;
import java.sql.Date;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	    GastoDAO gastoDAO = new GastoDAO();
	    GanhoDAO ganhoDAO = new GanhoDAO();
	    InvestimentoDAO investimentoDAO = new InvestimentoDAO();
	    char opcao = ' ';
	    
	    do {
	        Gasto gasto = null;
	        Ganho ganho = null;
	        Investimento investimento = null; 
	        opcao = menu();
	        
	        switch (opcao) {
	            case 'I':
	                System.out.println("Voc� escolheu INCLUIR");
	                char tipo = escolherTipoMovimento();
	                
	                switch (tipo) {
	                    case '1':
	                        gasto = coletarDados();
	                        gastoDAO.incluir(gasto);
	                        break;
	                    case '2':
	                        ganho = coletarDadosGanhos();
	                        ganhoDAO.incluir(ganho);
	                        break;
	                    case '3':
	                    	investimento = coletarDadosInvestimento();
	                        investimentoDAO.incluir(investimento);
	                        break;
	                    case '4':
	                        break;
	                    default:
	                        System.out.println("Op��o inv�lida. Por favor, escolha uma op��o v�lida.");
	                }
	                break;    
	                
	            case 'E':
	                System.out.println("Voc� escolheu EXCLUIR");
	                char tipo2 = escolherTipoMovimento();
	                
	                switch (tipo2) {
	                    case '1': 
	                        String codigoExcluir = consultarPorMovimentacao();
	                        gasto = gastoDAO.consultarPorMovimentacao(codigoExcluir);
	                        
	                        if (gasto != null) {
	                            gastoDAO.excluir(gasto);
	                            System.out.println("Registro de gasto exclu�do com sucesso.");
	                        } else {
	                            System.out.println("Gasto n�o encontrado.");
	                        }
	                        break;
	                    case '2': 
	                        String codigoExcluirGanho = consultarPorMovimentacaoGanho();
	                        ganho = ganhoDAO.consultarPorMovimentacao(codigoExcluirGanho);
	                        
	                        if (ganho != null) {
	                            ganhoDAO.excluir(ganho);
	                            System.out.println("Registro de ganho exclu�do com sucesso.");
	                        } else {
	                            System.out.println("Ganho n�o encontrado.");
	                        }
	                        break;
	                    case '3':
	                    	String codigoExcluirInvestimento = consultarPorMovimentacaoInvestimento();
	                        investimento = investimentoDAO.consultarPorMovimentacao(codigoExcluirInvestimento);
	                        
	                        if (investimento != null) {
	                            investimentoDAO.excluir(investimento);
	                            System.out.println("Registro de investimento exclu�do com sucesso.");
	                        } else {
	                            System.out.println("Investimento n�o encontrado.");
	                        }
	                    	break;
	                    case '4':
	                        break;                        
	                    default:
	                        System.out.println("Op��o inv�lida. Por favor, escolha uma op��o v�lida.");          
	                }
	                break;
	                
	            case 'A':
	                System.out.println("Voc� escolheu ALTERAR");
	                char tipo3 = escolherTipoMovimento();
	                
	                switch (tipo3) {
	                    case '1':
	                        gasto = coletarDados();
	                        gastoDAO.alterarPorCdGasto(gasto);
	                        break;
	                    case '2':
	                        ganho = coletarDadosGanhos();
	                        ganhoDAO.alterarPorCdganho(ganho);
	                        break;
	                    case '3':
	                    	investimento = coletarDadosInvestimento();
	                        investimentoDAO.alterarPorCdInvestimento(investimento);
	                        break;
	                    case '4':
	                        break;
	                    default:
	                        System.out.println("Op��o inv�lida. Por favor, escolha uma op��o v�lida.");
	                }
	                break;

	            case 'C':
	                System.out.println("Voc� escolheu CONSULTAR");
	                char tipo4 = escolherTipoMovimento();
	                
	                switch (tipo4) {
	                    case '1':
	                        String codigoConsultar = consultarPorMovimentacao();
	                        gasto = gastoDAO.consultarPorMovimentacao(codigoConsultar);
	                        
	                        if (gasto != null) {
	                            mostrarDadosGasto(gasto);
	                        } else {
	                            System.out.println("Gasto n�o encontrado.");
	                        }
	                        break;
	                    case '2':
	                        String codigoConsultarganho = consultarPorMovimentacaoGanho();
	                        ganho = ganhoDAO.consultarPorMovimentacao(codigoConsultarganho);
	                        
	                        if (ganho != null) {
	                            mostrarDadosGanho(ganho);
	                        } else {
	                            System.out.println("Ganho n�o encontrado.");
	                        }
	                        break;
	                    case '3':
	                    	String codigoConsultarinvestimento = consultarPorMovimentacaoInvestimento();
	                        investimento = investimentoDAO.consultarPorMovimentacao(codigoConsultarinvestimento);
	                        
	                        if (investimento != null) {
	                            mostrarDadosInvestimento(investimento);
	                        } else {
	                            System.out.println("Investimento n�o encontrado.");
	                        }
	                        break;
	                    	
	                    case '4':
	                        break;
	                    default:
	                        System.out.println("Op��o inv�lida. Por favor, escolha uma op��o v�lida.");
	                }
	                break;
	        }
	    } while (opcao != 'S');
	}

	public static char escolherTipoMovimento() {
	    Scanner s = new Scanner(System.in);
	    char tipo = ' ';
	    
	    System.out.println("Escolha o tipo de movimento ");
	    System.out.println("\t(1) Gasto");
	    System.out.println("\t(2) Ganho");
	    System.out.println("\t(3) Investimento");
	    System.out.println("\t(4) Voltar");
	    System.out.print("Op��o: ");
	    
	    tipo = s.nextLine().charAt(0);
	    
	    return tipo;
	}


	  public static char menu() {
	    Scanner s = new Scanner(System.in);
	    char opcao = ' ';
	        
	    System.out.println("Escolha a sua opcao: ");
	    System.out.println("\t(I)ncluir");
	    System.out.println("\t(E)xcluir");
	    System.out.println("\t(A)lterar");
	    System.out.println("\t(C)onsultar");
	    System.out.println("\t(S)air");
	    System.out.print("\nOpcao: ");
	    opcao = s.nextLine().toUpperCase().charAt(0);

	    return opcao;
	  }

	  public static String consultarPorMovimentacao() {
	    Scanner s = new Scanner(System.in);
	    System.out.print("Digite o c�digo do gasto: ");
	    return s.nextLine();
	  }
	  
	  public static String consultarPorMovimentacaoGanho() {
		    Scanner s = new Scanner(System.in);
		    System.out.print("Digite o c�digo do ganho: ");
		    return s.nextLine();
		  }

	  public static String consultarPorMovimentacaoInvestimento() {
		    Scanner s = new Scanner(System.in);
		    System.out.print("Digite o c�digo do investimento: ");
		    return s.nextLine();
		  }

	 
	  
	  public static Gasto coletarDados() {
		    Scanner s = new Scanner(System.in);
		    Gasto gasto = new Gasto();
		    System.out.print("Digite o c�digo do gasto: ");
		    gasto.set_cd_gasto(s.nextInt());
		    System.out.print("Digite o c�digo da movimenta��o: ");
		    gasto.set_cd_movimentacao(s.nextInt());
		    System.out.print("Digite o c�digo do extrato: ");
		    gasto.set_cd_extrato(s.nextInt());
		    System.out.print("Digite a quantidade de parcelas: ");
		    gasto.set_qtd_parcelas(s.nextInt());
		    System.out.print("Digite o valor da movimenta��o: ");
		    gasto.set_vl_movimentacao(s.nextDouble());
		    s.nextLine(); 
		    System.out.print("Digite o tipo de despesa: ");
		    gasto.set_tp_despesa(s.nextLine());
		    System.out.print("Digite o nome da movimenta��o: ");
		    gasto.set_nm_movimentacao(s.nextLine());
		    System.out.print("Digite a descri��o da movimenta��o: ");
		    gasto.set_ds_movimentacao(s.nextLine());
		    System.out.print("Digite a data da movimenta��o (AAAA-MM-DD): ");
		    gasto.set_dt_movimentacao(Date.valueOf(s.nextLine()));

		    return gasto;
		}


	  public static Ganho coletarDadosGanhos() {
		    Scanner s = new Scanner(System.in);
		    Ganho ganho = new Ganho();
		    System.out.print("Digite o c�digo do ganho: ");
		    ganho.set_cd_ganho(s.nextInt());
		    System.out.print("Digite o c�digo da movimenta��o: ");
		    ganho.set_cd_movimentacao(s.nextInt());
		    System.out.print("Digite o c�digo do extrato: ");
		    ganho.set_cd_extrato(s.nextInt());
		    System.out.print("Digite a quantidade de parcelas: ");
		    ganho.set_qtd_parcelas(s.nextInt());
		    System.out.print("Digite o valor da movimenta��o: ");
		    ganho.set_vl_movimentacao(s.nextDouble());
		    s.nextLine(); 
		    System.out.print("Digite o tipo de receita: ");
		    ganho.set_tp_receita(s.nextLine());
		    System.out.print("Digite o nome da movimenta��o: ");
		    ganho.set_nm_movimentacao(s.nextLine());
		    System.out.print("Digite a descri��o da movimenta��o: ");
		    ganho.set_ds_movimentacao(s.nextLine());
		    System.out.print("Digite a data da movimenta��o (AAAA-MM-DD): ");
		    ganho.set_dt_movimentacao(Date.valueOf(s.nextLine()));

		    return ganho;
		}
	  
	  public static Investimento coletarDadosInvestimento() {
		    Scanner s = new Scanner(System.in);
		    Investimento investimento = new Investimento();
		    System.out.print("Digite o c�digo do investimento: ");
		    investimento.set_cd_investimento(s.nextInt());
		    System.out.print("Digite a descri��o do investimento: ");
		    investimento.set_ds_investimento(s.next());
		    System.out.print("Digite o valor do investimento: ");
		    investimento.set_vl_investimento(s.nextDouble());
		    s.nextLine();
		    System.out.print("Digite a data do investimento (AAAA-MM-DD): ");
		    investimento.set_dt_investimento(Date.valueOf(s.nextLine()));
		    System.out.print("Digite o c�digo do usu�rio: ");
		    investimento.set_cd_usuario(s.nextInt());

		    return investimento;
		}


	
	  public static void mostrarDadosGasto(Gasto gasto) {
		    if (gasto != null) {
		        System.out.println("\n############### DADOS DO GASTO #################");
		        System.out.println("C�digo do Gasto: " + gasto.get_cd_gasto());
		        System.out.println("C�digo da Movimenta��o: " + gasto.get_cd_movimentacao());
		        System.out.println("C�digo do Extrato: " + gasto.get_cd_extrato());
		        System.out.println("Quantidade de Parcelas: " + gasto.get_qtd_parcelas());
		        System.out.println("Valor da Movimenta��o: " + gasto.get_vl_movimentacao());
		        System.out.println("Tipo de Despesa: " + gasto.get_tp_despesa());
		        System.out.println("Nome da Movimenta��o: " + gasto.get_nm_movimentacao());
		        System.out.println("Descri��o da Movimenta��o: " + gasto.get_ds_movimentacao());
		        System.out.println("Data da Movimenta��o: " + gasto.get_dt_movimentacao());
		        System.out.println("############### DADOS DO GASTO #################\n");
		    }
		}

	  public static void mostrarDadosGanho(Ganho ganho) {
		    if (ganho != null) {
		        System.out.println("\n############### DADOS DO GANHO #################");
		        System.out.println("C�digo do Ganho: " + ganho.get_cd_ganho());
		        System.out.println("C�digo da Movimenta��o: " + ganho.get_cd_movimentacao());
		        System.out.println("C�digo do Extrato: " + ganho.get_cd_extrato());
		        System.out.println("Quantidade de Parcelas: " + ganho.get_qtd_parcelas());
		        System.out.println("Valor da Movimenta��o: " + ganho.get_vl_movimentacao());
		        System.out.println("Tipo da Receita: " + ganho.get_tp_receita());
		        System.out.println("Nome da Movimenta��o: " + ganho.get_nm_movimentacao());
		        System.out.println("Descri��o da Movimenta��o: " + ganho.get_ds_movimentacao());
		        System.out.println("Data da Movimenta��o: " + ganho.get_dt_movimentacao());
		        System.out.println("############### DADOS DO GASTO #################\n");
		    }
		}
	
	  public static void mostrarDadosInvestimento(Investimento investimento) {
		    if (investimento != null) {
		        System.out.println("\n############### DADOS DO INVESTIMENTO #################");
		        System.out.println("C�digo do Investimento: " + investimento.get_cd_investimento());
		        System.out.println("Descri��o do Investimento: " + investimento.get_ds_investimento());
		        System.out.println("Valor do Investimento: " + investimento.get_vl_investimento());
		        System.out.println("Data do Investimento: " + investimento.get_dt_investimento());
		        System.out.println("C�digo do Usu�rio: " + investimento.get_cd_usuario());
		        System.out.println("############### DADOS DO INVESTIMENTO #################\n");
		    }
		}

	
	
	
}
