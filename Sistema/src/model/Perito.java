//NOME: Luiz Felipe Cardoso Gonçalves
//RM: 80721	

////NOME: Lucas Fernando Cardoso Gonçalves
//RM: 81333	

////NOME: Henrique Mendes Coelho Rodrigues
//RM: 81242	

package model;

public class Perito {
	private Integer id;
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	
	public Perito(Integer id, String nome, String telefone, String endereco, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
	}
	
	public Perito() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	

}
