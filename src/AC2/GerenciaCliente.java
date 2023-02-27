package AC2;

import java.io.IOException;
import java.time.LocalDate;
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



public String clientesIniciando(String nome) {
String info= "";
	
if(this.listaCliente.size()>0) {			
	for(Cliente cliente: this.listaCliente){
		
		if(cliente.getNome().toLowerCase().contains(nome)) { //verificando se eh elemento correto
			info += cliente.imprimiRelatorio();

		}
	

	}//for
}
else {
	info = "\nA lista esta vazia";
}	
	if(info.equals("")) {//se nao encontrar nada
		info = "Não existe cliente com este nome";
	}
	return info;

}	




public void passaArraylist() throws IOException { //metodo para passar arraylist para atualizar o documento
	BaseDados baseDados = new BaseDados();
	baseDados.atualizaClientes(listaCliente); //chama metodo na base de dados
	
}


public boolean verificaExistencia(Cliente cliente) {
	
	
	for(Cliente listaClientes: this.listaCliente){
		
		if(listaClientes.getDocumento().equals(cliente.getDocumento())) { //verificando se o documento ja foi cadastrado
			return true;

		}
	
	}//for
	return false;
}




	}

