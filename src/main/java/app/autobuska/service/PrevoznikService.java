package app.autobuska.service;

import java.util.List;

import app.autobuska.model.Prevoznik;



public interface PrevoznikService {
	
	List<Prevoznik> findAll();
	Prevoznik findOne(Long id);
	Prevoznik save(Prevoznik prevoznik);
	void remove(Long id);
	List<Prevoznik> findByName(String name);

}
