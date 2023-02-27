package AC2;

import java.time.LocalDateTime;

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
	public PessoaFisica(String nome, Endereco endereco,	LocalDateTime dataDeCadastro,	String CPF , int quantidadeMaximaDeParcelas) {
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
		info += this.getQuantidadeMaximaDeParcelas()+";\n";
		
		return info;
		
	}
	
	@Override
	public String getDocumento() { //para fazer a verificacao dos documentos
		String documento = getCPF();
		
		return documento;
		
	}
}
