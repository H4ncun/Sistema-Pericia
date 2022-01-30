package model;

public class CadastroProvas {
	private Integer id;
	private String nome;
	private Perito perito;
	private String comentario;
	private String numero_processo;
	
	public CadastroProvas(Integer id, String nome, Perito perito, String comentario, String numero_processo) {
		super();
		this.id = id;
		this.nome = nome;
		this.perito = perito;
		this.comentario = comentario;
		this.numero_processo = numero_processo;
	}
	
	public CadastroProvas() {
		
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

	public Perito getPerito() {
		return perito;
	}

	public void setPerito(Perito perito) {
		this.perito = perito;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getNumero_processo() {
		return numero_processo;
	}

	public void setNumero_processo(String numero_processo) {
		this.numero_processo = numero_processo;
	} 
	
	
}
