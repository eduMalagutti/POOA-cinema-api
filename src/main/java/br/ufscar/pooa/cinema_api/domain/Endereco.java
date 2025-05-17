package br.ufscar.pooa.cinema_api.domain;

import java.util.Objects;

public class Endereco {
	private String pais;
	private String estado;
	private String cidade;
	private String cep;
	private String bairro;
	private String rua;
	private String numero;
	private String complemento;

	public Endereco(String pais, String estado, String cidade, String cep, String bairro, String rua, String numero, String complemento) {
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
		this.cep = cep;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
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

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Endereco endereco = (Endereco) o;
		return Objects.equals(pais, endereco.pais) && Objects.equals(estado, endereco.estado) && Objects.equals(cidade, endereco.cidade) && Objects.equals(cep, endereco.cep) && Objects.equals(bairro, endereco.bairro) && Objects.equals(rua, endereco.rua) && Objects.equals(numero, endereco.numero) && Objects.equals(complemento, endereco.complemento);
	}

	@Override
	public int hashCode() {
		return Objects.hash(pais, estado, cidade, cep, bairro, rua, numero, complemento);
	}
}
