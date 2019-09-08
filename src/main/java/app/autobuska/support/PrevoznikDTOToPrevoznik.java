package app.autobuska.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import app.autobuska.model.Prevoznik;
import app.autobuska.service.PrevoznikService;
import app.autobuska.web.dto.PrevoznikDTO;



@Component
public class PrevoznikDTOToPrevoznik implements Converter<PrevoznikDTO, Prevoznik> {

	@Autowired
	PrevoznikService prevoznikService;

	@Override
	public Prevoznik convert(PrevoznikDTO dto) {
		Prevoznik prevoznik = null;
		
		if(dto.getId()!=null){
			prevoznik = prevoznikService.findOne(dto.getId());
			
			if(prevoznik == null){
				throw new IllegalStateException("Tried to "
						+ "modify a non-existant prevoznik");
			}
		}
		else {
			prevoznik = new Prevoznik();
		}
		
		prevoznik.setId(dto.getId());
		prevoznik.setNaziv(dto.getNaziv());
		prevoznik.setAdresa(dto.getAdresa());
		prevoznik.setPib(dto.getPib());
		
		return prevoznik;
	}
	
	public List<Prevoznik> convert (List<PrevoznikDTO> dtoPrevoznici){
		List<Prevoznik> prevoznici = new ArrayList<>();
		
		for(PrevoznikDTO dto : dtoPrevoznici){
			prevoznici.add(convert(dto));
		}
		
		return prevoznici;
	}
	
}
