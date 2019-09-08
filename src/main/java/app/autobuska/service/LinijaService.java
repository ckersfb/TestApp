package app.autobuska.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import app.autobuska.model.Linija;


public interface LinijaService {
	List<Linija> findAll();
	Page<Linija> findAll(int pageNum);
	Linija findOne(Long id);
	Linija save(Linija linija);
	Linija remove(Long id);
	List<Linija> findByName(String name);
	Page<Linija> findByPrevoznikId(int pageNum, Long prevoznikId);
	
	// Pretraga na frontendu
	Page<Linija> pretraga(String destinacija, Long prevoznikId, Double cenakarte, int pageNum);
	Linija delete(Long id);
	
	
}


