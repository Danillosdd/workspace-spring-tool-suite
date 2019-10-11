package com.threeway.curso.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threeway.curso.boot.dao.CargoDao;
import com.threeway.curso.boot.domain.Cargo;
@Service
@Transactional
public class CargoServiceImpl implements CargoService {
	
	@Autowired
	private CargoDao dao;

	@Override
	public void salvar(Cargo cargo) {
		dao.save(cargo);
		
	}

	@Override
	public void editar(Cargo cargo) {
		dao.update(cargo);
		
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true) // nao ira abrir uma nova transao, apenas leitura
	public Cargo buscarPortId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true) // nao ira abrir uma nova transao, apenas leitura
	public List<Cargo> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public boolean cargoTemFuncionarios(Long id) {
		if(buscarPortId(id).getFuncionarios().isEmpty()) {
			return false;
		}
		return true;
	}

}
