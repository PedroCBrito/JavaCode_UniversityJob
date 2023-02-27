package AC2;

public class Endereco {

	private String rua;
	private String numero;
	private String bairro;
	private String CEP;
	private String cidade;
	private String estado;
	
	public String getRua() {
		return rua;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCEP() {
		return CEP;
	}
	
	public void setCEP(String CEP) {
		this.CEP = CEP;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	public String paraString()//transforma em string para armazenar no documento
	{
		String info = "";
		
		info += this.getRua();
		info += "," + this.getNumero();
		info += "," + this.getBairro();
		info += "," + this.getCEP();
		info += "," + this.getCidade();
		info += "," + this.getEstado();
		
		return info;
	}
	
}
