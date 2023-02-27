package AC2;


import java.time.LocalDate;


public class Produtos {

	private int codigo;
	private String nomeProduto;
	private String descricao;
	private double preco;
	
	
	
//construtores
	public Produtos(int codigo, String nomeProduto, String descricao, double preco ) { 
		this.codigo = codigo;
		this.nomeProduto = nomeProduto;
		this.descricao = descricao;
		this.preco = preco;
	}//quando nao tem validade
	
	

	
//getter and setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	

//metodos
	
	
	public String paraString()
	{
		String info = "";
		
		info += this.getCodigo() + ",";
		info += this.getNomeProduto()+",";
		info += this.getDescricao()+",";
		info += this.getPreco()+"\n";
		
		
		return info;
		
	}
	
	public String imprimirRelatorio() //metodo para imprimir relatorios
	{
		String info = "";
		
		info += "\n======================";
		info += "\n Codigo: " + this.getCodigo(); // usa a funcao paraString da classe cliente
		info += "\n Nome do Produto: " + this.getNomeProduto();
		info += "\n Descricao: " + this.getDescricao();
		info += "\n Preco: " + this.getPreco();
		
		
		return info;
		
	}
	
	public boolean vencido() //metodo para verificar e retornar se esta vencido
	{
		boolean vencido = false;
		
		return vencido;//retorna o boolean
		
	}
	
}
