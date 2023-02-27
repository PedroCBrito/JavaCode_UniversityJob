package AC2;

import java.time.LocalDateTime;

public class PessoaJuridica extends Cliente{
	
	private String CNPJ;
	private String razaoSocial;
	private int prazoMaximo;
	
//getters e setters
	
	public String getCNPJ() {
		return CNPJ;
	}
	
	public void setCNPJ(String CNPJ) {
		this.CNPJ = CNPJ;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public int getPrazoMaximo() {
		return prazoMaximo;
	}
	
	public void setPrazoMaximo(int prazoMaximo) {
		this.prazoMaximo = prazoMaximo;
	}

//construtores
	public PessoaJuridica(String nome, Endereco endereco,	LocalDateTime dataDeCadastro,	String CNPJ , String razaoSocial,  int prazoMaximo) {
		super(nome, endereco, dataDeCadastro);
		this.CNPJ = CNPJ;
		this.razaoSocial = razaoSocial;
		this.prazoMaximo = prazoMaximo;
	}

	
//metodos
	@Override
	public String paraString()
	{
		String info = "";
		
		info += super.getNome()+",";
		info += super.getEndereco().paraString()+"\n";
		info += super.getDataDeCadastro()+",";
		info += this.getCNPJ()+",";
		info += this.getRazaoSocial()+",";
		info += this.getPrazoMaximo()+";\n";
		
		return info;
		
	}
	
	@Override
	public String getDocumento() {//para fazer a verificacao dos documentos
	String documento = getCNPJ();
		
		return documento;
		
	}

}
