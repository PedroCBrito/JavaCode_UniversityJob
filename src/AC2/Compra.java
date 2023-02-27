package AC2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Compra {
	
	private ArrayList<ItemCompra> itens = new ArrayList(); //criando arraylist para guardar os itens da compra
	private String identificador;
	private LocalDate data;
	private double valorTotal;
	private double totalPagoAtualmente;
	private long  CPF;
	private String  CNPJ;
		
	
//getters and setters
	public ArrayList<ItemCompra> getItens() {
		return new ArrayList<ItemCompra>(itens);
	}


	public void setItens(ArrayList<ItemCompra> itens) {
		this.itens = itens;
	}


	public String getIdentificador() {
		return identificador;
	}


	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}


	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}


	public double getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}


	public double getTotalPagoAtualmente() {
		return totalPagoAtualmente;
	}


	public void setTotalPagoAtualmente(double totalPagoAtualmente) {
		this.totalPagoAtualmente = totalPagoAtualmente;
	}
	
	
//construtores
	public Compra(String identificador,ArrayList<ItemCompra> itens,LocalDate data,double valorTotal, double totalPagoAtualmente, long CPF) {
		
		this.identificador = identificador;
		this.data = data;
		this.valorTotal = valorTotal;
		this.totalPagoAtualmente = totalPagoAtualmente;
		this.CPF= CPF;
		this.itens = itens;
		
	}
	
	public Compra(String identificador,ArrayList<ItemCompra> itens,LocalDate data,double valorTotal, double totalPagoAtualmente, String CNPJ) {
		
		this.identificador = identificador;
		this.data = data;
		this.valorTotal = valorTotal;
		this.totalPagoAtualmente = totalPagoAtualmente;
		this.CNPJ= CNPJ;
		this.itens = itens;
		
	}
	
	
//getters and setters


	public long getCPF() {
		return CPF;
	}


	public void setCPF(long cPF) {
		CPF = cPF;
	}


	public String getCNPJ() {
		return CNPJ;
	}


	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	
	
	
//metodos
	
	public Double valorApagar() //metodo que retorna o valor que ainda deve ser pago
	{
		Double aPagar; //variavel auxiliar
			
		aPagar = this.getValorTotal() - this.getTotalPagoAtualmente(); //calculo do valor a ser pago
			
		return aPagar;
			
	}
	
	public String paraString() //transforma em string para armazenar no documento
	{
		String info = "";
		for(ItemCompra compra: itens) {
			info += compra.getQuantidade()  + ",";
			info += compra.getNomeProduto()  + ",";
			info += compra.getPrecoUnitario() + ",";
			info += compra.getValorTotalDoItem()  + ";";
		
		}
		
		info += "/" + this.getIdentificador() + ",";
		info += this.getData() + ",";
		info += this.getValorTotal() + ",";
		info += this.getTotalPagoAtualmente() + ",";
		info += this.getCNPJ() + ",";
		info += this.getCPF() + "\n";
		
		return info;
		
	}
	
	public String imprimirRelatorio() //metodo para imprimir relatorios
	{
		String info = "";
		
		info += "\n======================";
		info += "\nCompra: " +this.getIdentificador();
		info += "\nIdentificador: " +this.getIdentificador();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");//para formatar a data
        String dataFormatada = this.getData().format(formatter);
		info += "\nData da compra: " + dataFormatada;
		info += "\nValor Total: " +this.getValorTotal();
		info += "\nValor Pago Atualmente: " + this.getTotalPagoAtualmente();
		if(this.getCPF() == 0) { // para quando nao for CPF
			info += "\nCNPJ: " + this.getCNPJ();
		}else {
			info += "\nCPF: " + this.getCPF();
		}
		return info;
	}
	
	public String imprimirRelatorioItemsComprados() //metodo para imprimir relatorios
	{
		String info = this.imprimirRelatorio();
		info += "\n======================\nProdutos Comprados:";
		for(ItemCompra itemCompra : itens) { //pega os itens vendidos

			
	        info += "\n\nNome do Produto: " + itemCompra.getNomeProduto();
	        info += "\nPreco do Produto Unitario: " + itemCompra.getPrecoUnitario();
	        info += "\nQuantidade do produto: " + itemCompra.getQuantidade();
	        info += "\nValor total: " + itemCompra.getValorTotalDoItem();

	        }
		return info;
	}
	
}
