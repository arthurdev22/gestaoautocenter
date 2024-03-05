package com.gestao.gestaocliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestao.gestaocliente.domain.servico.DadosAlterarServico;
import com.gestao.gestaocliente.domain.servico.DadosCadastrarServico;
import com.gestao.gestaocliente.domain.servico.Servico;
import com.gestao.gestaocliente.domain.servico.ServicoRepository;
import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/servico")

public class ServicoController {
	
	@Autowired
	private ServicoRepository repository;
	
	@GetMapping ("cadastrar")
	public String carregaPaginaFormulario(Long id ,Model model) {
		if (id != null) {
			var servico = repository.getReferenceById(id);
			model.addAttribute("servico" , servico);
		}
		return "servico/servformulario";
	}
	
	@GetMapping
	public String carregaListagem(Model model) {
		model.addAttribute("listaservico", repository.findAll());
		return "servico/servlistagem";
		
	}
	@PostMapping
	@Transactional
	public String 
	cadastrarServico(DadosCadastrarServico dados ) {
		var servico = new Servico(dados);
		repository.save(servico);
		return "redirect:/servico";
	}
	
	@PutMapping
	@Transactional
	public String alterarServico(DadosAlterarServico dados ) {
		var servico = repository.getReferenceById(dados.id());
		servico.atualizarDados(dados);
				
		return "redirect:/servico";
		
	}
	
	@DeleteMapping
	public String removerServico(Long id) {
		repository.deleteById(id);
	return "redirect:/servico";
	}
}
	
	
	
	
	
	
	
	
	
	