package AC2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoPerecivel extends Produtos{

	
	private LocalDate dataValidade;
	
	
	
	public ProdutoPerecivel(int codigo, String nomeProduto, String descricao, double preco, LocalDate dataValidade ) { 
		super(codigo,nomeProduto,descricao,preco);
		this.dataValidade = dataValidade;
	}//quando tem validade
	
	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	
	
	//metodos
		public boolean vencido() //metodo para verificar e retornar se esta vencido
		{
			boolean vencido = false;// variavel que guarda se esta vencido
			LocalDate now = LocalDate.now(); //guarda a data atual na variavel now
			
			
			if(now.isBefore(this.getDataValidade())) { //compara a data atual com a data de validade
				vencido = false;//se a data atual for antes da data de vencimento entao é falso 
			}else {
				vencido = true;//se nao for antes é verdadeiro
			}
			
			
			return vencido;//retorna o boolean
			
		}
		
		
		public String paraString()
		{
			String info = "";
			
			info += this.getDataValidade()+",";
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
			info += "\nCodigo: " +this.getCodigo(); // usa a funcao paraString da classe cliente
			info += "\nNome do Produto: " +this.getNomeProduto();
			info += "\nDescricao: " +this.getDescricao();
			info += "\nPreco: " +this.getPreco();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");//para formatar a data
	        String dataFormatada = this.getDataValidade().format(formatter);
			info += "\nData de Validade: " + dataFormatada;
			
			
			return info;
			
		}
		
}
