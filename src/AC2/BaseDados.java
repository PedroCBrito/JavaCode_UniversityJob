package AC2;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class BaseDados {
	
	

	public void verificaArquivoCliente(GerenciaCliente gerCliente) throws IOException {
	File arquivoCliente = new File("baseDados/Clientes.txt"); 
	boolean existe = arquivoCliente.exists();

	if(existe==false) {	//se nao existir ele cria o arquivo Cliente

		arquivoCliente.createNewFile();
	
	}
	
	FileReader fr = new FileReader("baseDados/Clientes.txt"); 
	BufferedReader br = new BufferedReader(fr);
	
	String clientes = "";
	while( br.ready() ) { //passa ate chegar no final do arquivo
		clientes = br.readLine(); //guarda linha por linha na string clientes
		String [] dadosCliente = clientes.split(","); //separa por virgular e armazena no vetor de strings 
		if(dadosCliente.length == 10) { //cria objeto se for Pessoa Juridica
			
			
					

				String nome = dadosCliente[0];
				Endereco endereco = new Endereco();
				endereco.setRua(dadosCliente[1]);
				endereco.setNumero(dadosCliente[2]);
				endereco.setBairro(dadosCliente[3]);
				endereco.setCEP(dadosCliente[4]);
				endereco.setCidade(dadosCliente[5]);
				endereco.setEstado(dadosCliente[6]);
				LocalDate dataDeCadastro = LocalDate.parse(dadosCliente[7]);
				String CPF = dadosCliente[8];
				int quantidadeMaximaDeParcelas = Integer.parseInt(dadosCliente[9]);
				Cliente cliente = new PessoaFisica(nome,endereco,dataDeCadastro,CPF,quantidadeMaximaDeParcelas);
				gerCliente.cadastrar(cliente);
			
				
			
			}//if se for Pessoa Fisica
			
			if(dadosCliente.length == 11) { //cria objeto se for Pessoa Juridica
				
					String nome = dadosCliente[0];
					Endereco endereco = new Endereco();
					endereco.setRua(dadosCliente[1]);
					endereco.setNumero(dadosCliente[2]);
					endereco.setBairro(dadosCliente[3]);
					endereco.setCEP(dadosCliente[4]);
					endereco.setCidade(dadosCliente[5]);
					endereco.setEstado(dadosCliente[6]);
					LocalDate dataDeCadastro = LocalDate.parse(dadosCliente[7]);
					String CNPJ = dadosCliente[8];
					String razaoSocial = dadosCliente[9];
					int prazoMaximo = Integer.parseInt(dadosCliente[10]);
					Cliente cliente = new PessoaJuridica(nome,endereco,dataDeCadastro,CNPJ,razaoSocial,prazoMaximo);
					gerCliente.cadastrar(cliente);
				
				
				
			}//if se for Pessoa Juridica

		}
		br.close();//Fecha o arquivo
	
}
	
	public void atualizaClientes(ArrayList<Cliente> listaCliente) throws IOException { //atualiza o arquivo de Clientes

		String info = "";
		File arquivoCliente = new File("baseDados/Clientes.txt"); 
		FileWriter fwArquivoClientes = new FileWriter(arquivoCliente, false);
		BufferedWriter bfArquivo = new BufferedWriter(fwArquivoClientes);//para escrever no arquivo
		
		
		
		for(Cliente cliente: listaCliente) {
			info += cliente.paraString();
			
		}
		
		
		bfArquivo.write(info);//escreve a String no arquivo
		
		bfArquivo.close();//Fecha o arquivo
		 
		 
		}//salva e atualiza o arquivo clientes
	
	
	
	
	
	public void verificaArquivoProduto(GerenciaProd gerProd) throws IOException { 
		File arquivoProduto = new File("baseDados/Produtos.txt"); 
		boolean existe = arquivoProduto.exists();

		if(existe==false) {	//se nao existir ele cria o arquivo Produtos

			arquivoProduto.createNewFile();
		
		}
		
		FileReader fr = new FileReader("baseDados/Produtos.txt"); 
		BufferedReader br = new BufferedReader(fr);
		
		String produtos = "";
		while( br.ready() ) { //passa ate chegar no final do arquivo
			produtos = br.readLine(); //guarda linha por linha na string produtos
			String [] listaProdutos = produtos.split(","); //separa por virgular e armazena no vetor de strings 
		
		if(listaProdutos.length == 4) { //cria objeto se for Produto nao perecivel	
			int codigo = Integer.parseInt(listaProdutos[0]);
			String nomeProduto = listaProdutos[1];
			String descricao = listaProdutos[2];
			double preco = Double.parseDouble(listaProdutos[3]);
			
			Produtos produto = new Produtos(codigo,nomeProduto,descricao,preco);
			gerProd.cadastrar(produto); //passa para a criacao do objeto
			
		}//if Produto nao perecivel	
		
		if(listaProdutos.length == 5) { //cria objeto se for Produto perecivel	
			LocalDate dataValidade = LocalDate.parse(listaProdutos[0]);
			int codigo = Integer.parseInt(listaProdutos[1]);
			String nomeProduto = listaProdutos[2];
			String descricao = listaProdutos[3];
			double preco = Double.parseDouble(listaProdutos[4]);
			
			Produtos produto = new ProdutoPerecivel(codigo,nomeProduto,descricao,preco,dataValidade);
			gerProd.cadastrar(produto);//passa para a criacao do objeto
			
		}//if Produto perecivel	
			
			
			
		
	}//while
	
	
		br.close();//Fecha o arquivo
	}//verificaArquivoProduto
	
	
	
	public void atualizaProdutos(ArrayList<Produtos> listaProdutos) throws IOException { //atualiza o arquivo de produtos

		String info = "";
		File arquivoProduto = new File("baseDados/Produtos.txt"); 
		FileWriter fwArquivoProdutos = new FileWriter(arquivoProduto, false);
		BufferedWriter bfArquivo = new BufferedWriter(fwArquivoProdutos);//para escrever no arquivo
		
		
		
		for(Produtos produto: listaProdutos) {
			info += produto.paraString();
			
		}
		
		
		bfArquivo.write(info);//escreve a String no arquivo
		
		bfArquivo.close();//Fecha o arquivo
		 
		 
		}//salva e atualiza o arquivo Produtos
	
	
	
	public void verificaArquivoCompra(GerenciaCompra gerComp) throws IOException {
		
		File arquivoCompra = new File("baseDados/Compra.txt"); 
		boolean existe = arquivoCompra.exists();

		if(existe==false) {	//se nao existir ele cria o arquivo Compra

			arquivoCompra.createNewFile();
		
		}
		
		FileReader fr = new FileReader("baseDados/Compra.txt"); 
		BufferedReader br = new BufferedReader(fr);
		
		String compras = "";
		
		while( br.ready() ) { //passa ate chegar no final do arquivo
			compras = br.readLine(); //guarda linha por linha na string compras
			String [] separa = compras.split("/"); //separa por / e armazena no vetor de strings
			String dadosItensCompras = separa[0];
			String dadosCompras = separa[1];
			ArrayList<ItemCompra> itens = new ArrayList<ItemCompra>(); //cria um arraylist para guardar os clientes
			
			String [] ItensCompras = dadosItensCompras.split(";");//separa por ; e armazena no vetor de strings
			for(String compra : ItensCompras) {
				String [] dados = compra.split(",");//separa por virgula e armazena no vetor de strings
				int quantidade =  Integer.parseInt(dados[0]);
				String nomeProduto =  dados[1];
				Double precoUnitario =  Double.parseDouble(dados[2]);
				Double valorTotalDoItem =  Double.parseDouble(dados[3]);
				
				ItemCompra itemcompra = new ItemCompra(quantidade,nomeProduto,precoUnitario,valorTotalDoItem);
				itens.add(itemcompra);
				
			}

			
			String [] Compras = dadosCompras.split(",");
			String identificador = Compras[0];
			LocalDate data = LocalDate.parse(Compras[1]);
			double valorTotal = Double.parseDouble(Compras[2]);
			double totalPagoAtualmente = Double.parseDouble(Compras[3]);
			
			String CNPJ = Compras[4];
			int CPF = Integer.parseInt(Compras[5]);
			
			if(CPF == 0) {
				Compra compra = new Compra(identificador,itens,data,valorTotal,totalPagoAtualmente,CNPJ);			
				gerComp.cadastrar(compra);
			}//if nao tiver CPF
			else {
				Compra compra = new Compra(identificador,itens,data,valorTotal,totalPagoAtualmente,CPF);
				gerComp.cadastrar(compra);
			}
		}
		
	}
	
	
	
	
	
	public void atualizaCompra(ArrayList<Compra> listaCompra) throws IOException { //atualiza o arquivo compra

		String info = "";
		File arquivoCompra = new File("baseDados/Compra.txt"); 
		FileWriter fwArquivoCompra = new FileWriter(arquivoCompra, false);
		BufferedWriter bfArquivo = new BufferedWriter(fwArquivoCompra);//para escrever no arquivo
		
		
		
		for(Compra compra: listaCompra) {
			info += compra.paraString();
			
		}
		
		
		bfArquivo.write(info);//escreve a String no arquivo
		
		bfArquivo.close();//Fecha o arquivo
		 
		 
		}//salva e atualiza o arquivo Compra
	
}
