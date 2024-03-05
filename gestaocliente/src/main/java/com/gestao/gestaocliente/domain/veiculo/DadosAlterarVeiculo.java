package com.gestao.gestaocliente.domain.veiculo;

public record DadosAlterarVeiculo(
		Long id,
		String modelo_veiculo,
		String placa,
		String ano_veiculo,
		String proprietario) {

}
