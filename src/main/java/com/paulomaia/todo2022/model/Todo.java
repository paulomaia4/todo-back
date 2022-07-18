package com.paulomaia.todo2022.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String descricao;
	@Column
	private boolean finalizado;
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime dataCriacao;
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime dataTermino;
	
	@PrePersist
	public void beforeSave() {
	setDataCriacao(LocalDateTime.now());
	}
	
	
	private void setCreatedDate(LocalDateTime now) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the descreicao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descreicao the descreicao to set
	 */
	public void setDescreicao(String descreicao) {
		this.descricao = descricao;
	}
	/**
	 * @return the finalizado
	 */
	public boolean isFinalizado() {
		return finalizado;
	}
	/**
	 * @param finalizado the finalizado to set
	 */
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	/**
	 * @return the dataCriacao
	 */
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	/**
	 * @param dataCriacao the dataCriacao to set
	 */
	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	/**
	 * @return the dataTermino
	 */
	public LocalDateTime getDataTermino() {
		return dataTermino;
	}
	/**
	 * @param dataTermino the dataTermino to set
	 */
	public void setDataTermino(LocalDateTime dataTermino) {
		this.dataTermino = dataTermino;
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", descreicao=" + descricao + ", finalizado=" + finalizado + ", dataCriacao="
				+ dataCriacao + ", dataTermino=" + dataTermino + "]";
	}
	public Todo(Long id, String descreicao, boolean finalizado, LocalDateTime dataCriacao, LocalDateTime dataTermino) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.finalizado = finalizado;
		this.dataCriacao = dataCriacao;
		this.dataTermino = dataTermino;
	}
	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
