package br.com.alura.forum.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.modelo.StatusTopico;
import br.com.alura.forum.modelo.Topico;

public class DetalhadoTopicoDto {
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	private StatusTopico status;
	private String autor;
	private List<RespostaDto> respostas;

	public DetalhadoTopicoDto(Topico topico) {
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
		this.status = topico.getStatus();
		this.autor = topico.getAutor().getNome();
		this.respostas = new ArrayList<>();
		this.respostas.addAll(topico.getRespostas().stream()
				.map(RespostaDto::new).collect(Collectors.toList()));
	}

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public StatusTopico getStatus() {
		return status;
	}

	public String getAutor() {
		return autor;
	}

	public List<RespostaDto> getRespostas() {
		return respostas;
	}

}
