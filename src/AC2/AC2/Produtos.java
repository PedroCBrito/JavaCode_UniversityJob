package AC2;


import java.time.LocalDateTime;


public class Produtos {

	private int codigo;
	private String nomeProduto;
	private String descricao;
	private double preco;
	private LocalDateTime dataValidade;
	
	
//construtores
	public Produtos(int codigo, String nomeProduto, String descricao, double preco ) { 
		this.codigo = codigo;
		this.nomeProduto = nomeProduto;
		this.descricao = descricao;
		this.preco = preco;
	}//quando nao tem validade
	
	public Produtos(int codigo, String nomeProduto, String descricao, double preco, LocalDateTime dataValidade ) { 
		this.codigo = codigo;
		this.nomeProduto = nomeProduto;
		this.descricao = descricao;
		this.preco = preco;
		this.dataValidade = dataValidade;
	}//quando tem validade

	
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

	public LocalDateTime getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDateTime dataValidade) {
		this.dataValidade = dataValidade;
	}

//metodos
	public boolean vencido() //metodo para verificar e retornar se esta vencido
	{
		boolean vencido = false;// variavel que guarda se esta vencido
		LocalDateTime now = LocalDateTime.now(); //guarda a data atual na variavel now
		
		
		if(now.isBefore(this.getDataValidade())) { //compara a data atual com a data de validade
			vencido = false;//se a data atual for antes da data de vencimento entao é falso 
		}else {
			vencido = true;//se nao for antes é verdadeiro
		}
		
		
		return vencido;//retorna o boolean
		
	}

}
