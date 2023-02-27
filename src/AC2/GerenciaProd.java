package AC2;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class GerenciaProd {
	
	
private ArrayList <Produtos> listaProdutos;
private ArrayList <ProdutoPerecivel> listaProdutosPereciveis;
	
	public GerenciaProd() {
		this.listaProdutos = new ArrayList<Produtos>();	
	}

	public ArrayList<Produtos> getListaContas() {
		return listaProdutos;
	}

	public void setListaContas(ArrayList<Produtos> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	
	public void cadastrar( Produtos objProduto ){
		this.listaProdutos.add(objProduto);
		
		
	}
	
	public void passaArraylist() throws IOException { //metodo para passar arraylist para atualizar o documento
		BaseDados baseDados = new BaseDados();
		baseDados.atualizaProdutos(listaProdutos);
		
	}
	
	

	
//metodos
	public String imprimir(){ //para exibir os produtos cadastrados
		
		String info="";
		
		if(this.listaProdutos.size()>0) {
			
			for(Produtos produto: listaProdutos){
				info += produto.imprimirRelatorio();
			}
			
		}
		else {
			info = "\nA lista esta vazia";
		}//caso nao acha produtos cadastrados
		
		return info;
	}//imprimir
	
	
	public String buscaNomeProduto(String nome){ //para exibir os produtos cadastrados pelo nome

		String info = "";
		
			if(this.listaProdutos.size()>0) {			
				for(Produtos produto: listaProdutos){
		
					if(nome.equals(produto.getNomeProduto().toLowerCase())) { //verificando se eh elemento correto
						
						info = produto.imprimirRelatorio();//chama o metodo para imprimir
						info += "\n======================";
						return info; //retorna as informacoes do produto
			
					}else {
						info = "Não existe produto com este nome"; //se nao encontrar o produto pelo nome desejado
						
					}//else
					
				}//for
				
		}	else {
			info = "\nA lista esta vazia";
			
		}//caso nao acha produtos cadastrados
		
		return info;
		}//buscaNomeProduto
	
	public String verificaVencimento(){ //para exibir os produtos cadastrados
		String info = "Produto que sao pereciveis: ";
		
		for(Produtos produto: listaProdutos) {
			if(produto instanceof ProdutoPerecivel ) { //verifica se o produto eh perecivel
				info += produto.imprimirRelatorio();
				
			}//if
		}//for
		
		info += "\n\n\n\nProdutos Vencidos: ";
		
		for(Produtos produto: listaProdutos) {
			if(produto instanceof ProdutoPerecivel ) {//verifica se o produto eh perecivel
				if(produto.vencido()) { //verifica se esta vencido
					info += produto.imprimirRelatorio();	
				}//if se estiver vencido
			}//if
		}//for
		
		
		return info;
		}//verificaVencimento
	
	
	
	public boolean verificaExistencia(Produtos produto) { //verifica se ja foi cadastrado o produto
		
		
		for(Produtos listaProdutos: this.listaProdutos){
			
			if(listaProdutos.getNomeProduto().equals(produto.getNomeProduto()) && listaProdutos.getDescricao().equals(produto.getDescricao()) && listaProdutos.getPreco() == produto.getPreco() ) { //verificando se o documento ja foi cadastrado
				return true;

			}
		
		}//for
		return false;
	}
	
	
}
