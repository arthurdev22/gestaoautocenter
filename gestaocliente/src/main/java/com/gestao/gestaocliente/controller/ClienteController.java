package com.gestao.gestaocliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gestao.gestaocliente.domain.cliente.Cliente;
import com.gestao.gestaocliente.domain.cliente.ClienteRepository;
import com.gestao.gestaocliente.domain.cliente.DadosAlterarCliente;
import com.gestao.gestaocliente.domain.cliente.DadosCadastrarCliente;
import jakarta.transaction.Transactional;

@Controller
@RequestMapping ("/cliente")
public class ClienteController {
	//private List<Cliente> clientes = new ArrayList<> () ;
	
	@Autowired
	private ClienteRepository repository;
	
	@GetMapping ("cadastrar")
	public String carregaPaginaFormulario(Long id ,Model model) {
		if (id != null) {
			var cliente = repository.getReferenceById(id);
			model.addAttribute("cliente" , cliente);
		}
		return "cliente/formulario";
	}
	
	@GetMapping
	public String carregaListagem(Model model) {
		model.addAttribute("listacliente", repository.findAll());
		return "cliente/listagemcliente";
		
	}
	@PostMapping
	@Transactional
	public String 
	cadastrarCliente(DadosCadastrarCliente dados ) {
		var cliente = new Cliente(dados);
		repository.save(cliente);
		
		return "redirect:/cliente";
	}
	
	@PutMapping
	@Transactional
	public String alterarCliente(DadosAlterarCliente dados ) {
		var cliente = repository.getReferenceById(dados.id());
		cliente.atualizarDados(dados);
				
		return "redirect:/cliente";
		
	}
	
	@DeleteMapping
	public String removerCliente(Long id) {
		repository.deleteById(id);
	return "redirect:/cliente";
	}

}

	
