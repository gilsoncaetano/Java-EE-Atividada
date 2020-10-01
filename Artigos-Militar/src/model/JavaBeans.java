package model;

public class JavaBeans {
	///Passo "3"
	private String idclientes;
	private String nome;
	private String cpf;
	private String rg;
	private String datanascimento;
	private String sexo;
	private String email;
	private String telefone;
	
	private String idendereco;
	private String tipo;
	private String logradoura;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	
	
	
	//construtor padrão
	public JavaBeans() {
		
	}
	// construtor que recebe o vetor(ArrayList) do método listarClientes()DAO

	public JavaBeans(String idclientes, String nome, String cpf, String rg, String datanascimento, String sexo,
			String email, String telefone) {
		
		this.idclientes = idclientes;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.datanascimento = datanascimento;
		this.sexo = sexo;
		this.email = email;
		this.telefone = telefone;
		
	}
	public JavaBeans(String idendereco,String tipo, String logradoura, String numero, String complemento,
			String bairro, String cep) {
		this.idendereco = idendereco;
		this.tipo = tipo;
		this.logradoura = logradoura;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
	}
	
	
	// Clientes
	public String getIdclientes() {
		return idclientes;
	}
	public void setIdclientes(String idclientes) {
		this.idclientes = idclientes;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getDatanascimento() {
		return datanascimento;
	}
	public void setDatanascimento(String datanascimento) {
		this.datanascimento = datanascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

//endereço
	public String getIdendereco() {
		return idendereco;
	}
	public void setIdendereco(String idendereco) {
		this.idendereco = idendereco;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getLogradoura() {
		return logradoura;
	}
	public void setLogradoura(String logradoura) {
		this.logradoura = logradoura;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
		

}
