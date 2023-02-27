package AC2;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class Menu {

	public static void main(String[] args) throws IOException {
		
		GerenciaCliente gerCliente = new GerenciaCliente();
		GerenciaProd gerProd = new GerenciaProd();
		gerCliente.recuperaDados(); // Metodo da classe BaseDados para saber se o arwuivo existe
		
		
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
				gerCliente.cadastrar(cliente); //passa as infos para gerencia cliente
				
				break;
			}//case 1
			
			
			
			
			case 2:{ // para deletar por CPF ou CNPJ
				String aux;
				boolean feito;
				aux =JOptionPane.showInputDialog("Insira o CPF ou CNPJ a ser deletado"); //recebe o CNPJ ou CPF
				
				feito = gerCliente.deletaClientePorDoc(aux); // chama o metodo e guarda se foi feito
				
				if(feito = true) {//verifica se funcionou
					JOptionPane.showInputDialog("Cliente deletado com sucesso");//se funcionar
				}else {
					JOptionPane.showInputDialog("Cliente nao foi deletado, verifique"); // se nao funcionar
				}
				
				
				break;
			}//case 2
			
			
			
			case 3:{ // para deletar por nome
				String aux;
				boolean feito;
				aux =JOptionPane.showInputDialog("Insira o Nome a ser deletado"); //recebe o nome
				
				feito = gerCliente.deletaClientePorNome(aux); // chama o metodo e guarda se foi feito
				
				if(feito = true) {//verifica se funcionou
					JOptionPane.showInputDialog("Cliente deletado com sucesso");//se funcionar
				}else {
					JOptionPane.showInputDialog("Cliente nao foi deletado, verifique"); // se nao funcionar
				}
				
				
				break;
				
			}//case 3
			
			
			
			
			case 4:{ // para cadastrar um produto
				int tipo;
				tipo = Integer.parseInt(JOptionPane.showInputDialog("Deseja cadastrar um: \n1-Produto Perecivel \n 2-Produto Nao Perecivel"));
				
				Produtos prod = cadastroProd(tipo);
				gerProd.cadastrar(prod);//passa as infos para gerencia produto
				
				break;
			}//case 4
			
			case 5:{ // para cadastrar um produto
				
				
				break;
			}//case 4
			
			case 8:{ // para cadastrar um produto
				
				gerCliente.passaArraylist();
				
				
				break;
			}//case 41
			
			default:{
				JOptionPane.showMessageDialog(null, "Opcao invalida");
			}
			
			}
		
		
		}
		
		
	}
	
public static Cliente cadastroCliente(int tipo){ //metodo para receber dados de cadastro
		
		String nome;
		Endereco endereco = new Endereco();
		LocalDateTime dataDeCadastro;
		
		
		
		
		nome = JOptionPane.showInputDialog("Digite o nome do  Cliente: ");
		dataDeCadastro = LocalDateTime.now(); //guarda a data atual na variavel datadeCadastro
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

public static Produtos cadastroProd(int tipo){ //metodo para receber dados de cadastro
	int codigo;
	String nomeProduto;
	String descricao;
	double preco;
	
	
	codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto: "));
	nomeProduto = JOptionPane.showInputDialog("Digite o nome do  produto: ");
	descricao = JOptionPane.showInputDialog("Digite a descricao do produto: ");
	preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preco do produto: "));
if(tipo == 2) {//se nao for perecivel
	return new Produtos(codigo,nomeProduto,descricao,preco);
}else {//se for perecivel
	LocalDateTime dataValidade;
	dataValidade = LocalDateTime.parse(JOptionPane.showInputDialog("Digite a data de validade do produto: "));
	return new Produtos(codigo,nomeProduto,descricao,preco,dataValidade);
}//else
}//cadastroProd



	}


