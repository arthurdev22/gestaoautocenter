package com.gestao.gestaocliente.domain.veiculo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

	@Entity
	@Table (name="tblveiculo")
	public class Veiculo {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		private String modelo_veiculo;
		private String placa;
		private String ano_veiculo;
		private String proprietario;
		
		public Veiculo (DadosCadastrarVeiculo dados) {
			this.modelo_veiculo = dados.modelo_veiculo();
			this.placa = dados.placa();
			this.ano_veiculo = dados.ano_veiculo();
			this.proprietario = dados.proprietario();
		}
	
		public Veiculo() {}

		@Override
		public String toString() {
			return "Veiculo[modelo_veiculo="+ modelo_veiculo +", placa="+ placa +", ano_veiculo="+ ano_veiculo+", proprietario="+ proprietario +" ]";
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getModelo_veiculo() {
			return modelo_veiculo;
		}

		public void setModelo_veiculo(String modelo_veiculo) {
			this.modelo_veiculo = modelo_veiculo;
		}

		public String getPlaca() {
			return placa;
		}

		public void setPlaca(String placa) {
			this.placa = placa;
		}

		public String getAno_veiculo() {
			return ano_veiculo;
		}

		public void setAno_veiculo(String ano_veiculo) {
			this.ano_veiculo = ano_veiculo;
		}

		public String getProprietario() {
			return proprietario;
		}

		public void setProprietario(String proprietario) {
			this.proprietario = proprietario;
		}
		
		public void atualizarDados(DadosAlterarVeiculo dados) {
			this.modelo_veiculo = dados.modelo_veiculo();
			this.placa = dados.placa();
			this.ano_veiculo = dados.ano_veiculo();
			this.proprietario = dados.proprietario();
			
		
		}
		
		
}