package com.gestao.gestaocliente.domain.servico;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="tblservico")
public class Servico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String placa;
	private String dataserv;
	private String servico1;
	
	public Servico(DadosCadastrarServico dados) {
		this.placa =dados.placa();
		this.dataserv = dados.dataserv();
		this.servico1 =dados.servico1();
		
	}
	
	public Servico () {}

	@Override
	public String toString() {
		return "Servico[placa=" + placa + ", dataserv=" + dataserv +",]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getDataserv() {
		return dataserv;
	}

	public void setDataserv(String dataserv) {
		this.dataserv = dataserv;
	}

	public String getServico1() {
		return servico1;
	}

	public void setServico1(String servico1) {
		this.servico1 = servico1;
	}
	
	public void atualizarDados(DadosAlterarServico dados) {
		this.placa =dados.placa();
		this.dataserv = dados.dataserv();
		this.servico1 =dados.servico1();
	
	}

	
}