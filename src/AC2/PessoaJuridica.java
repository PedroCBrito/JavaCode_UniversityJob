package AC2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
	public PessoaJuridica(String nome, Endereco endereco,	LocalDate dataDeCadastro,	String CNPJ , String razaoSocial,  int prazoMaximo) {
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
		info += super.getEndereco().paraString()+",";
		info += super.getDataDeCadastro()+",";
		info += this.getCNPJ()+",";
		info += this.getRazaoSocial()+",";
		info += this.getPrazoMaximo()+"\n";
		
		return info;
		
	}
	
	@Override
	public String getDocumento() {//para fazer a verificacao dos documentos
	String documento = getCNPJ();
		
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
	info += "\nCNPJ: " +this.getCNPJ();
	info += "\nRazao Social: " +this.getRazaoSocial();
	info += "\nPrazo Maximo: " +this.getPrazoMaximo();
	
	
	return info;
	}
}
