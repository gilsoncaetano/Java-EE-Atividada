package model;

public class javaBeans {
	private String id;
	private String nome;
	private String fone;
	private String email;
	
	//construtor pad�o
	public javaBeans () {
		
	}
	//construtor que recebe o vetor(ArrayList) do m�todo listarContatos()(DAO)
	public javaBeans(String id, String nome, String fone, String email) {
		this.id = id;
		this.nome = nome;
		this.fone = fone;
		this.email = email;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
