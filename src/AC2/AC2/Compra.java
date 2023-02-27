package AC2;

import java.util.ArrayList;

public class Compra {
	
	private ArrayList<ItemCompra> itens = new ArrayList(); //criando arraylist para guardar os itens da compra
	private String identificador;
	private String data;
	private double valorTotal;
	private double totalPagoAtualmente;
	private String CPF;
	private int CNPJ;
		
	
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


	public String getData() {
		return data;
	}


	public void setData(String data) {
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
	public Compra(ItemCompra itemcompra, String identificador,String data,double valorTotal, double totalPagoAtualmente, String CPF) {
		
		this.identificador = identificador;
		this.data = data;
		this.valorTotal = valorTotal;
		this.totalPagoAtualmente = totalPagoAtualmente;
		this.CPF= CPF;
		
	}
	
	public Compra(ItemCompra itemcompra, String identificador,String data,double valorTotal, double totalPagoAtualmente, int CNPJ) {
		
		this.identificador = identificador;
		this.data = data;
		this.valorTotal = valorTotal;
		this.totalPagoAtualmente = totalPagoAtualmente;
		this.CNPJ= CNPJ;
		
		
	}
	
	
//metodos
	
	public Double valorApagar() //metodo que retorna o valor que ainda deve ser pago
	{
		Double aPagar; //variavel auxiliar
		
		aPagar = this.getValorTotal() - this.getTotalPagoAtualmente(); //calculo do valor a ser pago
		
		return aPagar;
		
	}


	public String getCPF() {
		return CPF;
	}


	public void setCPF(String cPF) {
		CPF = cPF;
	}


	public int getCNPJ() {
		return CNPJ;
	}


	public void setCNPJ(int cNPJ) {
		CNPJ = cNPJ;
	}
}
