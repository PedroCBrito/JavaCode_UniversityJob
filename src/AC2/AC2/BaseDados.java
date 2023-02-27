package AC2;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class BaseDados {
	
	GerenciaCliente gerCliente = new GerenciaCliente();

	public void verificaArquivoCliente(ArrayList<Cliente> listaCliente) throws IOException {
	File arquivoCliente = new File("baseDados/Clientes.txt"); 
	boolean existe = arquivoCliente.exists();

	if(existe==false) {	//se nao existir ele cria o arquivo Cliente

		arquivoCliente.createNewFile();
	
	}
	
	FileReader fr = new FileReader("baseDados/Clientes.txt"); 
	BufferedReader br = new BufferedReader(fr);
	
	String clientes = "";
	while( br.ready() ) {
		clientes = br.readLine(); 
		String [] dadosCliente = clientes.split(","); 
		if(dadosCliente.length == 10) { //cria objeto se for Pessoa Fisica
			
					

				String nome = dadosCliente[0];
				Endereco endereco = new Endereco();
				endereco.setRua(dadosCliente[1]);
				endereco.setNumero(dadosCliente[2]);
				endereco.setBairro(dadosCliente[3]);
				endereco.setCEP(dadosCliente[4]);
				endereco.setCidade(dadosCliente[5]);
				endereco.setEstado(dadosCliente[6]);
				LocalDateTime dataDeCadastro = LocalDateTime.parse(dadosCliente[7]);
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
					LocalDateTime dataDeCadastro = LocalDateTime.parse(dadosCliente[7]);
					String CNPJ = dadosCliente[8];
					String razaoSocial = dadosCliente[9];
					int prazoMaximo = Integer.parseInt(dadosCliente[10]);
					Cliente cliente = new PessoaJuridica(nome,endereco,dataDeCadastro,CNPJ,razaoSocial,prazoMaximo);
					gerCliente.cadastrar(cliente);
				
				
				
			}//if se for Pessoa Juridica

		}
		br.close();//Fecha o arquivo
	
}
	
	public void atualizaClientes(ArrayList<Cliente> listaCliente) throws IOException {

		String info = "";
		File arquivoCliente = new File("baseDados/Clientes.txt"); 
		FileWriter fwArquivoClientes = new FileWriter(arquivoCliente, false);
		BufferedWriter bfArquivo = new BufferedWriter(fwArquivoClientes);//para escrever no arquivo
		
		
		
		for(Cliente cliente: listaCliente) {
			info += cliente.paraString();
			
		}
		
		JOptionPane.showInputDialog(info);
		bfArquivo.write(info);//escreve a String no arquivo
		
		bfArquivo.close();//Fecha o arquivo
		 
		 
		}//salva e atualiza o arquivo clientes
	

}
