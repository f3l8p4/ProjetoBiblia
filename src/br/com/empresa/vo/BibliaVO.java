package br.com.empresa.vo;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="biblia")
public class BibliaVO implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1835850187861385047L;

	@Id
	@Basic(optional = false)
	@Column(name = "sequencia", nullable = false)
	private BigInteger id;
	
	
	@Basic(optional = false)
	@Column(name = "capitulo", nullable = false)
	private int capitulo;
	
	@Basic(optional = false)
	@Column(name = "versiculo", nullable = false)
	private int versiculo;
	
	@Basic(optional = false)
	@Column(name = "texto", nullable = false)
	private String texto;
	
	//Cliente
	@NotNull
	@JoinColumn(name = "livro", referencedColumnName = "livro", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private LivrosVO livrosVO;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public int getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(int capitulo) {
		this.capitulo = capitulo;
	}

	public int getVersiculo() {
		return versiculo;
	}

	public void setVersiculo(int versiculo) {
		this.versiculo = versiculo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LivrosVO getLivrosVO() {
		return livrosVO;
	}

	public void setLivrosVO(LivrosVO livrosVO) {
		this.livrosVO = livrosVO;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
}
