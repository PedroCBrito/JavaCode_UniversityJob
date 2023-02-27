package AC2;
import java.io.IOException;
import java.util.ArrayList;


public class GerenciaCompra {
	
	
private ArrayList <Compra> listaCompra;


	//getters and setters
	public GerenciaCompra() {
		this.listaCompra = new ArrayList<Compra>();	
	}

	public ArrayList<Compra> getListaCompra() {
		return listaCompra;
	}

	public void setListaCompra(ArrayList<Compra> listaCompra) {
		this.listaCompra = listaCompra;
	}
	
	public void cadastrar( Compra objCompra ){
		this.listaCompra.add(objCompra);
	}
	
	//metodos 
	
	public void passaArraylist() throws IOException { //metodo para passar arraylist para atualizar o documento
		BaseDados baseDados = new BaseDados();
		baseDados.atualizaCompra(listaCompra);
		
	}
	
	public String imprimir(){ //para exibir os dados dos produtos
		
		String info="";
		
		if(this.listaCompra.size()>0) {
			
			for(Compra compra: listaCompra){
				info += "\n";
				info += compra.imprimirRelatorio(); //recebe o relatorio de compras	
			}
			
		}
		else {
			info = "\nA lista esta vazia";
		}//caso nao acha compra ainda
		
		return info;
	}//imprimir
	
	
	public String buscaPeloNumero(String numero){ //para exibir os dados das compras com base no numero informado
		
		String info= "Nao foi encontrado uma compra com este numero"; //caso nao encontre
		
		if(this.listaCompra.size()>0) {
			
			for(Compra compra: listaCompra){
				
				if(compra.getIdentificador().equals(numero)) { //verifica se eh igual
				
					info = "Compra de numero: "+ numero + "\n" +compra.imprimirRelatorioItemsComprados(); //recebe o relatorio de compras
					info += "\n======================";
					return info;
				}//if
				
				
			}//for
		}
		else {
			info = "\nA lista esta vazia";
		}//caso nao acha compra ainda
		
		return info;
	}//imprimir
	
	public String getContasNaoPagas() {//metodo para exibir as compras nao pagas
		
		String info = "";
		if(this.listaCompra.size() > 0) {
			for(Compra compra: listaCompra) {
				if(compra.getTotalPagoAtualmente() < compra.getValorTotal()) { //verifica se esta paga
					info += "\n" + compra.imprimirRelatorio();
					info += "\n======================";
				} //if
			}//for
		} else {
			info = "\nA lista esta vazia";
		}//else
		if(info.equals("")) { //se nao encontrar nada
			info = "Não existe compra nao paga";
		}
		
		
		return info;
	}//imprimir
	
	public String getCompraMaisCara(){//metodo para exibir a compra mais cara
		
		String info = "";
		int aux = 0;
		if(this.listaCompra.size() > 0) {
			for(int i=1;i<this.getListaCompra().size();i++) {
				if(this.getListaCompra().get(aux).getValorTotal() < this.getListaCompra().get(i).getValorTotal()) { //verifica conta mais cara
					aux = i;
				}
			}
			info = this.getListaCompra().get(aux).imprimirRelatorioItemsComprados();
		} else {
			info = "\nA lista esta vazia";
		}
		
		
		
		return info;
	}
	
	
	
	public String getCompraMaisBarata(){//metodo para exibir a compra mais barata
		
		String info = "";
		int aux = 0;
		if(this.listaCompra.size() > 0) {
			for(int i=1;i<this.getListaCompra().size();i++) {
				if(this.getListaCompra().get(aux).getValorTotal() > this.getListaCompra().get(i).getValorTotal()) { //verifica conta mais barata
					aux = i;
				}//if
			}//for
			info = this.getListaCompra().get(aux).imprimirRelatorioItemsComprados();
		} else {
			info = "\nA lista esta vazia";
		}//else
		return info;
	}
	
	
	
	public String getDezUltimasCompras() { //metodo para exibir as ultimas 10 compras pagas
		
		String info = "";
		int i;
		if(this.listaCompra.size()>0) {
			if(this.listaCompra.size()<10) {
				for(i=this.getListaCompra().size()-1;i>=0;i--) {
					if(this.getListaCompra().get(i).getTotalPagoAtualmente() == this.getListaCompra().get(i).getValorTotal()) { // verifica se esta paga
						info += this.getListaCompra().get(i).imprimirRelatorio();
						info += "\n======================";
					}//for
				}//for
			} else {
				for(i=9;i>=0;i--) {
					if(this.getListaCompra().get(i).getTotalPagoAtualmente() == this.getListaCompra().get(i).getValorTotal()) {
						info += this.getListaCompra().get(i).imprimirRelatorio();
						info += "\n======================";
					}//if
				}//for
			}//else
		} else {
			info = "\nA lista esta vazia";
		}//else
		
		if(info.equals("")) { //se nao encontrar nada
			info = "Não existe compra paga";
		}
		
		return info;
	}

	public String getValorComprasUltimosDozeMeses() {//metodo para exibir o valor das compras feitas nos ultimos 12 por mes
		String info = "";
		Double TotalMes;
		if(this.listaCompra.size()>0) {
			for(int i = 0;i<=11;i++) {
				TotalMes = 0.0;
				for(Compra compra: listaCompra) {
					if(compra.getData().getMonthValue() == i ) { //verifica por mes
						TotalMes += compra.getValorTotal();
					}//if
				}//for
				if(i==11) { //se for o mes atual
					info += "\nEsse Mes";
					info += "\nValor Total: " + TotalMes;
					info += "\n======================";
				}else {
				info += "\n" + (11-i) + " Meses atras";
				info += "\nValor Total: " + TotalMes;
				info += "\n======================";
				}
			}//for
		} else {
			info = "\nA lista esta vazia";
		}//else
		return info;
	}
}
