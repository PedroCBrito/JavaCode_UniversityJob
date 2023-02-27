package AC2;

import java.io.IOException;
import java.util.ArrayList;


public class GerenciaCliente {


		private ArrayList<Cliente> listaCliente; //cria um arraylist para guardar os clientes
		
//getters and setters
		public ArrayList<Cliente> getListaCliente() {
			return listaCliente;
		}

		public void setListaCliente(ArrayList<Cliente> listaCliente) {
			this.listaCliente = listaCliente;
		}

		
//constructors
		public GerenciaCliente(){ 
			
			this.listaCliente = new ArrayList<Cliente>();
		}
		
		public void cadastrar(Cliente cliente) { //funcao para cadastrar um cliente
			this.listaCliente.add(cliente);
		}
		
		
		
//metodos		
public String imprimir(){ //para exibir os dados dos clientes
			
			String info="";
			
			if(this.listaCliente.size()>0) {
				
				for(Cliente cliente: listaCliente){
					info += "\n=============";
					info += cliente.paraString(); // usa a funcao paraString da classe cliente	
				}
				
			}
			else {
				info = "\nA lista esta vazia";
			}//caso nao acha clientes cadastrados ainda
			
			return info;
		}




		
public boolean deletaClientePorDoc(String documento) {
			boolean feito = false;
			int i=0;
						
			for(Cliente cliente: this.listaCliente){
				if(documento.equals(cliente.getDocumento()) || documento.equals(cliente.getDocumento()) ) { //verificando se eh elemento correto
					listaCliente.remove(i);
					feito = true;
					return feito;

				}else {
					i++; //soma para saber em que posicao esta o elemento a ser deletado
				}
			}
			
			return feito; //retorna true se funcionou e false se deu errado
		}



		
		
public boolean deletaClientePorNome(String nome) {
			boolean feito = false;
			int i=0;
						
			for(Cliente cliente: this.listaCliente){
				if(nome.equals(cliente.getNome())) { //verificando se eh elemento correto
					listaCliente.remove(i);
					feito = true;
					return feito;

				}else {
					i++; //soma para saber em que posicao esta o elemento a ser deletado
				}
			}
			
			return feito; //retorna true se funcionou e false se deu errado
		}

public void passaArraylist() throws IOException {
	BaseDados baseDados = new BaseDados();
	baseDados.atualizaClientes(listaCliente);
	
}

public void recuperaDados() throws IOException {
	BaseDados baseDados = new BaseDados();
	baseDados.verificaArquivoCliente(listaCliente);
	
}


	}

