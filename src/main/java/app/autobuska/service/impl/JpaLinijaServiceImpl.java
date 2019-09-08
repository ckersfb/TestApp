package app.autobuska.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import app.autobuska.model.Linija;
import app.autobuska.repository.LinijaRepository;
import app.autobuska.service.LinijaService;


@Service
@Transactional
public class JpaLinijaServiceImpl implements LinijaService {
	@Autowired
	private LinijaRepository linijaRepository;

	@Override
	public Page<Linija> findAll(int pageNum) {
		// TODO Auto-generated method stub
		return linijaRepository.findAll(new PageRequest(pageNum, 5));
	}

	@Override
	public Linija findOne(Long id) {
		return linijaRepository.findOne(id);
	}

	@Override
	public Linija save(Linija linija) {
		return linijaRepository.save(linija);
		
	}

	@Override
	public Linija remove(Long id) {
		Linija linija = linijaRepository.findOne(id);
		if(linija != null) {
			linijaRepository.delete(linija);
		}
		
		return linija;
	}

	@Override
	public Page<Linija> findByPrevoznikId(int pageNum, Long prevoznikId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Linija> pretraga( String destinacija, Long prevoznikId,
			Double cenakarte, int pageNum) {
		if(destinacija != null ){
			destinacija = "%" + destinacija + "%";
		}
		return linijaRepository.pretraga(destinacija, prevoznikId, cenakarte, new PageRequest(pageNum, 5));
	}

	@Override
	public List<Linija> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Linija> findAll() {
		// TODO Auto-generated method stub
		return linijaRepository.findAll();
	}

	@Override
	public Linija delete(Long id) {
		Linija linija = linijaRepository.findOne(id);
		if(linija != null){
			linijaRepository.delete(linija);
		}
		
		return linija;
	}

	
}
