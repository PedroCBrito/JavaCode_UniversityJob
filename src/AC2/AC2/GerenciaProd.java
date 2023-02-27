package AC2;
import java.util.ArrayList;

public class GerenciaProd {
	
	
private ArrayList <Produtos> listaProdutos;
	
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
	
	
	
	
	
}
