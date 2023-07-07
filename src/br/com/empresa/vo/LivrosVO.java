package br.com.empresa.vo;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.*;

@Entity
@Table(name="livros")
public class LivrosVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8072398248268673188L;
	
	@Id
	@Basic(optional = false)
	@Column(name = "livro", nullable = false)
	private BigInteger id;
	
	@Basic(optional=false)
	@Column(name="escritor",nullable = false, length = 30)
	private String escritor;
	
	@Basic(optional=false)
	@Column(name="sigla",length = 2)
	private String sigla;
	
	@Basic(optional=false)
	@Column(name="qtd_capitulos")
	private int qtdecaptulos;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getEscritor() {
		return escritor;
	}

	public void setEscritor(String escritor) {
		this.escritor = escritor;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public int getQtdecaptulos() {
		return qtdecaptulos;
	}

	public void setQtdecaptulos(int qtdecaptulos) {
		this.qtdecaptulos = qtdecaptulos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return escritor;
	}


	
	

}
