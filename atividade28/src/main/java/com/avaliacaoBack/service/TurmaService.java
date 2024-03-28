package com.avaliacaoBack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacaoBack.entitie.Turma;
import com.avaliacaoBack.repository.TurmaRepository;

@Service
public class TurmaService {
	private final TurmaRepository TurmaRepository;

	//construtor que recebe a dependencia
	@Autowired
	public TurmaService(TurmaRepository TurmaRepository) {
		this.TurmaRepository = TurmaRepository;
	}

	public List<Turma> buscaTodosTurma(){
		return TurmaRepository.findAll();
	}

	public Turma buscaTurmaId(Long id) {
		Optional <Turma> Turma = TurmaRepository.findById(id);
		return Turma.orElse(null);
	}
	//metodo salvar os produtos
	public Turma SalvaTurma(Turma Turma) {
		return TurmaRepository.save(Turma);
	}
	public Turma alterarTurma(Long id, Turma alterarTurma) {
		Optional <Turma> existeTurma = TurmaRepository.findById(id);

		if (existeTurma.isPresent()) {
			alterarTurma.setId(id);
			return TurmaRepository.save(alterarTurma);
		}
		return null;
	}
	public boolean apagarTurma(Long id) {
		Optional <Turma> existeTurma = TurmaRepository.findById(id);
		if (existeTurma.isPresent()) {
			TurmaRepository.deleteById(id);
			return true;
		}
		return false;
	}

}




