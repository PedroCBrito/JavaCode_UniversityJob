package AC2;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Menu {

	public static void main(String[] args) throws IOException {
		
		GerenciaCliente gerCliente = new GerenciaCliente();
		GerenciaProd gerProd = new GerenciaProd();
		GerenciaCompra gerCompra = new GerenciaCompra();
		
		BaseDados baseDados = new BaseDados();
		baseDados.verificaArquivoCliente(gerCliente);
		baseDados.verificaArquivoProduto(gerProd);
		baseDados.verificaArquivoCompra(gerCompra);
		
		
		String menuPrincipal = "1. Cadastrar cliente\n"
				  +	"2. Deletar cliente pelo CPF ou CNPJ\n"
			      + "3. Deletar cliente pelo nome\n"
			      + "4. Cadastro de Produtos\n"
			      + "5. Efetuação de uma compra\n"
				  + "6. Atualização da situação de pagamento de uma compra\n"
			      + "7. Relatórios\n"
			      + "8. Sair (termina o sistema)";
				  //cria uma String que representara o menu inicial

		String menuRelatorios = "(a) Relação de todos os Clientes que possuem o nome iniciado por uma determinada\r\n"
				  + "sequência de caracteres\n"
				  + "(b) Relação de todos os Produtos\n"
			      + "(c) Busca de um produto pelo nome\n"
			      + "(d) Relação de produtos que são perecíveis e que estão com a data de validade vencida\n"
			      + "(e) Relação de todas as compras\n" 
		          + "(f) Busca de uma compra pelo número\n"
 				  + "(g) Relação de todas as compras que não foram pagas ainda\n"
				  + "(h) Relação das 10 últimas compras pagas\n"
				  + "(i) Apresentação das informações da compra mais cara\n"
				  + "(j) Apresentação das informações da compra mais barata\n"
				  + "(k) Relação do valor total de compras feitas em cada mês nos últimos 12 meses";
				//cria uma String que representara o menu dentro dos relatorios
		

	
		
		

		
		int opcao = 0;
		while(opcao!=8){		
			opcao = Integer.parseInt( JOptionPane.showInputDialog(menuPrincipal) ); // mostra o menu principal

			switch(opcao){
			
			case 1:{ // para cadastro do cliente
				int tipo;
				tipo = Integer.parseInt(JOptionPane.showInputDialog("Deseja cadastrar uma: \n1-Pessoa Fisica \n 2-Pessoa juridica"));
				
				Cliente cliente = cadastroCliente(tipo);
				if(gerCliente.verificaExistencia(cliente)) { //para verificar se ja existe um cliente igual
					JOptionPane.showMessageDialog(null,"Cliente ja esta cadastrado");//se ja existir
				}else {
					gerCliente.cadastrar(cliente); //passa as infos para gerencia cliente
				}
				
				
				break;
			}//case 1
			
			case 2:{ // para deletar por CPF ou CNPJ
				String aux;
				boolean feito;
				aux =JOptionPane.showInputDialog("Insira o CPF ou CNPJ a ser deletado"); //recebe o CNPJ ou CPF
				
				feito = gerCliente.deletaClientePorDoc(aux); // chama o metodo e guarda se foi feito
				
				if(feito = true) {//verifica se funcionou
					JOptionPane.showMessageDialog(null,"Cliente deletado com sucesso");//se funcionar
				}else {
					JOptionPane.showMessageDialog(null,"Cliente nao foi deletado, verifique"); // se nao funcionar
				}
				
				
				break;
			}//case 2
			
			case 3:{ // para deletar por nome
				String aux;
				boolean feito;
				aux =JOptionPane.showInputDialog("Insira o Nome a ser deletado"); //recebe o nome
				
				feito = gerCliente.deletaClientePorNome(aux); // chama o metodo e guarda se foi feito
				
				if(feito = true) {//verifica se funcionou
					JOptionPane.showMessageDialog(null,"Cliente deletado com sucesso");//se funcionar
				}else {
					JOptionPane.showMessageDialog(null,"Cliente nao foi deletado, verifique"); // se nao funcionar
				}
				
				
				break;
				
			}//case 3
			
			case 4:{ // para cadastrar um produto
				int tipo;
				tipo = Integer.parseInt(JOptionPane.showInputDialog("Deseja cadastrar um: \n1-Produto Perecivel \n 2-Produto Nao Perecivel"));
				
				Produtos prod = cadastroProd(tipo, gerProd);
				if(gerProd.verificaExistencia(prod)) { //para verificar se ja existe um cliente igual
					JOptionPane.showMessageDialog(null,"Produto ja esta cadastrado");//se ja existir
				}else {
					gerProd.cadastrar(prod);//passa as infos para gerencia produto
					JOptionPane.showMessageDialog(null,"Produto Cadastrado");
				}
				
				
				break;
			}//case 4
			
			case 5:{ // para cadastrar um produto
				Compra comp = efetuarCompra(gerProd, gerCompra);
				gerCompra.cadastrar(comp);
				JOptionPane.showMessageDialog(null, "Compra efetuada");
				break;
			}//case 5
			
			case 6:{//Para a atualização da situação de pagamento de uma compra
				String info = gerCompra.imprimir();
				int id = Integer.parseInt(JOptionPane.showInputDialog(info + "\n\nEscolha o ID da compra que deseja pagar"));
				pagarCompra(id, gerCompra);
				break;
			}
			
			
			case 7:{ // relatorios
				String escolha;

                escolha = JOptionPane.showInputDialog(menuRelatorios); // mostra o menu de relatorios

            switch(escolha){


                case "a":{ // Relação de todos os Clientes que possuem o nome iniciado por uma determinada sequência de caracteres
                	String aux;
                    aux = JOptionPane.showInputDialog("Insira a sequencia de caracteres que deseja procurar: "); //recebe nome do produto
                	gerCliente.clientesIniciando(aux);
                	
                	JOptionPane.showMessageDialog(null ,gerCliente.clientesIniciando(aux));
                	
                    break;
                }
                case "b":{ // Relação de todos os Produtos

                     JOptionPane.showMessageDialog(null ,gerProd.imprimir()); //chama metodo para mostrar os produtos cadastrados

                     break;
                }
                case "c":{ // Busca de um produto pelo nome
                    
                    String aux;
                    aux =JOptionPane.showInputDialog("Insira o nome do produto"); //recebe nome do produto
                
                    JOptionPane.showMessageDialog(null ,gerProd.buscaNomeProduto(aux));

                    break;
                }
                case "d":{ // Relação de produtos que são perecíveis e que estão com a data de validade vencida
                	
                	JOptionPane.showMessageDialog(null ,gerProd.verificaVencimento());
                	                	
                    break;
                }
                case "e":{ // Relação de todas as compras
                	
                	JOptionPane.showMessageDialog(null ,gerCompra.imprimir());
                	
                	
                    break;
                }
                case "f":{ // Busca de uma compra pelo número

                    String aux;
                    aux =JOptionPane.showInputDialog("Insira o numero da compra"); //recebe nome do produto
                    
                    JOptionPane.showMessageDialog(null ,gerCompra.buscaPeloNumero(aux));
                    
                    break;
                }
                case "g":{ // Relação de todas as compras que não foram pagas ainda
                	
                	JOptionPane.showMessageDialog(null, gerCompra.getContasNaoPagas());
                    break;
                }
                case "h":{ // Relação das 10 últimas compras pagas

                	JOptionPane.showMessageDialog(null, gerCompra.getDezUltimasCompras());
                    break;
                }
                case "i":{ // Apresentação das informações da compra mais cara
                	
                	JOptionPane.showMessageDialog(null, gerCompra.getCompraMaisCara());
                    break;
                }
                case "j":{ // Apresentação das informações da compra mais barata
                	
                	JOptionPane.showMessageDialog(null, gerCompra.getCompraMaisBarata());
                    break;
                }
                case "k":{ // Relação do valor total de compras feitas em cada mês nos últimos 12 meses.
                	
                	JOptionPane.showMessageDialog(null, gerCompra.getValorComprasUltimosDozeMeses());
                    break;
                }
        }//switch
				
				break;
			}//case 7
			
			
			case 8:{ // para sair e salvar o software
				
				gerCliente.passaArraylist(); //atualiza o arquivo Cliente  quando sai do app
				gerProd.passaArraylist();//atualiza o arquivo Produto quando sai do app
				gerCompra.passaArraylist();//atualiza o arquivo Produto quando sai do app
				
				break;
			}//case 8
			
			default:{
				JOptionPane.showMessageDialog(null, "Opcao invalida");
			}
			
			}
		
		
		}
		
		
	}
	
	
	//Metodos
	public static Cliente cadastroCliente(int tipo){ //metodo para receber dados de cadastro
		
		String nome;
		Endereco endereco = new Endereco();
		LocalDate dataDeCadastro;
		
		
		
		
		nome = JOptionPane.showInputDialog("Digite o nome do  Cliente: ");
		dataDeCadastro = LocalDate.now(); //guarda a data atual na variavel datadeCadastro
		endereco.setRua(JOptionPane.showInputDialog("Digite o nome da rua: "));
		endereco.setNumero(JOptionPane.showInputDialog("Digite o Numero da residencia: "));
		endereco.setBairro(JOptionPane.showInputDialog("Digite o nome do Bairro: "));
		endereco.setCEP(JOptionPane.showInputDialog("Digite o CEP: "));
		endereco.setCidade(JOptionPane.showInputDialog("Digite o nome da cidade: "));
		endereco.setEstado(JOptionPane.showInputDialog("Digite o estado: "));
		
		if(tipo == 1) { // se for cadastro de pessoa fisica
			String CPF;
			int quantidadeMaximaDeParcelas;
			CPF = JOptionPane.showInputDialog("Digite o CPF: ");
			quantidadeMaximaDeParcelas = Integer.parseInt(JOptionPane.showInputDialog("Digite a  quantidade maxima de parcelas: "));
			
			return new PessoaFisica(nome,endereco,dataDeCadastro,CPF,quantidadeMaximaDeParcelas);
		}else { // se for cadastro de pesssoa juridica
			String CNPJ;
			String razaoSocial;
			int prazoMaximo;
			CNPJ = JOptionPane.showInputDialog("Digite o CNPJ: ");
			razaoSocial = JOptionPane.showInputDialog("Digite a razao social: ");
			prazoMaximo = Integer.parseInt(JOptionPane.showInputDialog("Digite o prazo maximo: "));
			return new PessoaJuridica(nome,endereco,dataDeCadastro,CNPJ,razaoSocial,prazoMaximo);
		}
		
	}//cadastroCliente

	
	
	public static Produtos cadastroProd(int tipo, GerenciaProd gerProd){ //metodo para receber dados de cadastro
		int codigo;
		String nomeProduto;
		String descricao;
		double preco;
	
	
		codigo = gerProd.getListaContas().size();
		nomeProduto = JOptionPane.showInputDialog("Digite o nome do  produto: ");
		descricao = JOptionPane.showInputDialog("Digite a descricao do produto: ");
		preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preco do produto: "));
			if(tipo == 2) {//se nao for perecivel
				return new Produtos(codigo,nomeProduto,descricao,preco);
			}else {//se for perecivel
				LocalDate dataValidade = LocalDate.parse(JOptionPane.showInputDialog("Digite a data de validade do produto: (Ano-Mes-Dia) "));
				
				return new ProdutoPerecivel(codigo,nomeProduto,descricao,preco,dataValidade);
		}//else
	}//cadastroProd

	
	
	public static Compra efetuarCompra(GerenciaProd gerProdut, GerenciaCompra gerCompra) { //metodo para efetuar a compra
		int id, quant, continua;
		ArrayList<ItemCompra> aux = new ArrayList(); //criando arraylist para guardar os itens da compra
		do {//while para adicionar mais de 1 item
			String info = gerProdut.imprimir();
			id = Integer.parseInt(JOptionPane.showInputDialog(info + "\n\nEscolha o codigo do produto que deseja comprar"));
			quant = Integer.parseInt(JOptionPane.showInputDialog("Escolha a quantidade que deseja comprar: "));
			String nomeProduto = gerProdut.getListaContas().get(id).getNomeProduto();
			double precoUnitario = gerProdut.getListaContas().get(id).getPreco();
			double valorTotalDoItem = precoUnitario * quant;
			ItemCompra itemCompraAux = new ItemCompra(quant, nomeProduto, precoUnitario, valorTotalDoItem);
			aux.add(itemCompraAux);
			continua = Integer.parseInt(JOptionPane.showInputDialog("Deseja Comprar outro produto? \n1-Sim \n2-Nao"));
		}while(continua == 1);
		String identificador = String.valueOf(gerCompra.getListaCompra().size());
		LocalDate data = LocalDate.now();
		double valorTotal = 0;
		for(int i=0; i<aux.size(); i++) {
			valorTotal += aux.get(i).getValorTotalDoItem();
		}//for
		double totalPagoAtualmente = 0;
		int cpfOuCnpj = Integer.parseInt(JOptionPane.showInputDialog("Deseja Comprar usando: \n1-CPF \n 2-CNPJ"));
		if(cpfOuCnpj == 1) {//para saber o usuario quer pagar com cpf ou cnpj
			long CPF = Integer.parseInt(JOptionPane.showInputDialog("Digite o CPF: "));
			return new Compra(identificador,aux,data,valorTotal,totalPagoAtualmente,CPF);
		} else {
			String CNPJ = JOptionPane.showInputDialog("Digite o CNPJ");
			return new Compra(identificador,aux,data,valorTotal,totalPagoAtualmente,CNPJ);
		}//else
	}//efetuarCompra
	
	
	
	public static void pagarCompra(int id, GerenciaCompra gerCompra) { // metodo para pagar as compras
		double valor;
		if(gerCompra.getListaCompra().get(id).getTotalPagoAtualmente() == gerCompra.getListaCompra().get(id).getValorTotal()){//para verificar se a compra ja esta paga
			JOptionPane.showMessageDialog(null ,"Essa compra ja esta paga");
		} else {
			do {//while para nao deixar o usuario pagar com um valor acima do nescessario
				double valorTotal = gerCompra.getListaCompra().get(id).valorApagar();
				valor = Integer.parseInt(JOptionPane.showInputDialog("Valor que resta pagar: " + valorTotal + "\n\nEscolha o valor que deseja pagar"));
				if(valor>gerCompra.getListaCompra().get(id).getValorTotal() - gerCompra.getListaCompra().get(id).getTotalPagoAtualmente()) {
					JOptionPane.showMessageDialog(null ,"Valor invalido");
				}//if
			} while (valor>gerCompra.getListaCompra().get(id).getValorTotal() - gerCompra.getListaCompra().get(id).getTotalPagoAtualmente());
			gerCompra.getListaCompra().get(id).setTotalPagoAtualmente(valor+gerCompra.getListaCompra().get(id).getTotalPagoAtualmente());
			JOptionPane.showMessageDialog(null, "Pagamento efutuado");
		} //else
	} //pagarCompra
	
}


