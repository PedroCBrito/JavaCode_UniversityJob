package AC2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

 public class PessoaFisica extends Cliente {
	
	 
	private String CPF;
	private int quantidadeMaximaDeParcelas;
	
	
//getters e setters
	
	 public String getCPF() {
		return CPF;
	}
	
	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
	
	public int getQuantidadeMaximaDeParcelas() {
		return quantidadeMaximaDeParcelas;
	}
	
	public void setQuantidadeMaximaDeParcelas(int quantidadeMaximaDeParcelas) {
		this.quantidadeMaximaDeParcelas = quantidadeMaximaDeParcelas;
	}
	
	
//construtores	
	public PessoaFisica(String nome, Endereco endereco,	LocalDate dataDeCadastro,	String CPF , int quantidadeMaximaDeParcelas) {
		super(nome, endereco, dataDeCadastro);
		this.CPF = CPF;
		this.quantidadeMaximaDeParcelas = quantidadeMaximaDeParcelas;
	}
	
	
//metodos	
	@Override
	public String paraString()
	{
		String info = "";
		
		info += super.getNome()+",";
		info += super.getEndereco().paraString()+",";
		info += super.getDataDeCadastro()+",";
		info += this.getCPF()+",";
		info += this.getQuantidadeMaximaDeParcelas()+"\n";
		
		return info;
		
	}
	
	@Override
	public String getDocumento() { //para fazer a verificacao dos documentos
		String documento = getCPF();
		
		return documento;
		
	}
	
	
	@Override
	public String imprimiRelatorio() {//para fazer a verificacao dos documentos
		
	String info = "";
	
	info += "\n======================";
	info += "\nNome: " + this.getNome(); // usa a funcao paraString da classe cliente
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");//para formatar a data
    String dataFormatada = this.getDataDeCadastro().format(formatter);
	info += "\nData do Cadastro: " +dataFormatada;
	Endereco endereco = new Endereco();
	endereco = this.getEndereco();
	info += "\nRua: " +endereco.getRua();
	info += "\nBairro: " +endereco.getBairro();
	info += "\nCEP: " +endereco.getCEP();
	info += "\nEstado: " +endereco.getEstado();
	info += "\nNumero: " +endereco.getNumero();
	info += "\nCPF: " +this.getCPF();
	info += "\nQuantidade maxima de parcelas: " +this.getQuantidadeMaximaDeParcelas();
	
	
	return info;
	}
	
	
}
