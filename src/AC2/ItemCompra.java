package AC2;

public class ItemCompra {
	
	private int quantidade;
	private String nomeProduto;
	private double precoUnitario;
	private double valorTotalDoItem;
	
	//construtor
	public ItemCompra(int quantidade, String nomeProduto, double precoUnitario, double valorTotalDoItem) {
		this.quantidade = quantidade;
		this.nomeProduto = nomeProduto;
		this.precoUnitario = precoUnitario;
		this.valorTotalDoItem = valorTotalDoItem;
	}
	
//getters and setters
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public double getValorTotalDoItem() {
		return valorTotalDoItem;
	}
	public void setValorTotalDoItem(double valorTotalDoItem) {
		this.valorTotalDoItem = valorTotalDoItem;
	}
	
}
