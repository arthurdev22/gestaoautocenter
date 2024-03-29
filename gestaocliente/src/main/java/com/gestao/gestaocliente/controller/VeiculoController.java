package com.gestao.gestaocliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestao.gestaocliente.domain.veiculo.DadosAlterarVeiculo;
import com.gestao.gestaocliente.domain.veiculo.DadosCadastrarVeiculo;
import com.gestao.gestaocliente.domain.veiculo.Veiculo;
import com.gestao.gestaocliente.domain.veiculo.VeiculoRepository;

import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/veiculos")
public class VeiculoController {
	
	@Autowired
	private VeiculoRepository repository;
	
	@GetMapping ("cadastrar")
	public String carregaPaginaFormulario(Long id ,Model model) {
		if (id != null) {
			var veiculo = repository.getReferenceById(id);
			model.addAttribute("veiculo" , veiculo);
		}
		return "veiculo/veiculoformulario";
	}
	
	@GetMapping
	public String carregaListagem(Model model) {
		model.addAttribute("listaveiculo", repository.findAll());
		return "veiculo/veiculolistagem";
	}
	
	@PostMapping
	@Transactional
	public String 
	cadastrarVeiculo(DadosCadastrarVeiculo dados ) {
		var veiculo = new Veiculo(dados);
		repository.save(veiculo);
		
		return "redirect:/veiculos";
	}
	
	@PutMapping
	@Transactional
	public String alterarVeiculo(DadosAlterarVeiculo dados ) {
		var veiculo = repository.getReferenceById(dados.id());
		veiculo.atualizarDados(dados);
				
		return "redirect:/veiculos";
	}
	
	@DeleteMapping
	public String removerVeiculo(Long id) {
		repository.deleteById(id);
	return "redirect:/veiculos";
	}

}
