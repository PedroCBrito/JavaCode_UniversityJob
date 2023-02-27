package AC2;

import java.time.LocalDateTime;

public abstract class Cliente {

	private String nome;
	private Endereco endereco;
	private LocalDateTime dataDeCadastro;

//getters e setters
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public LocalDateTime getDataDeCadastro() {
		return dataDeCadastro;
	}
	
	public void setDataDeCadastro(LocalDateTime dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	
	
//construtores
	public Cliente( String nome, Endereco endereco, LocalDateTime dataDeCadastro) { 
		this.nome = nome;
		this.endereco = endereco;
		this.dataDeCadastro = dataDeCadastro;
	}//construtor para o super funcionar nas herancas
	
	
	
//metodos
	//Metodo para retorna uma string com as informações organizadas.
	public abstract String paraString();
	//metodo para retornar o CPF ou CNPJ para verificacao
	public abstract String getDocumento();
	
	
}
