package app.autobuska.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.autobuska.model.Prevoznik;
import app.autobuska.repository.PrevoznikRepository;
import app.autobuska.service.PrevoznikService;

@Service
@Transactional
public class JpaPrevoznikServiceImpl implements PrevoznikService {
	
	@Autowired
	private PrevoznikRepository prevoznikRepository;

	@Override
	public List<Prevoznik> findAll() {
		// TODO Auto-generated method stub
		return prevoznikRepository.findAll();
	}

	@Override
	public Prevoznik findOne(Long id) {
		// TODO Auto-generated method stub
		return prevoznikRepository.findOne(id);
	}

	
	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Prevoznik save(Prevoznik prevoznik) {
		return prevoznikRepository.save(prevoznik);
	}

	@Override
	public List<Prevoznik> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
