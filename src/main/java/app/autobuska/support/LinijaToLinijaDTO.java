package app.autobuska.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import app.autobuska.model.Linija;
import app.autobuska.web.dto.LinijaDTO;




@Component
public class LinijaToLinijaDTO implements Converter<Linija, LinijaDTO> {

	@Override
	public LinijaDTO convert(Linija source) {
		
		
		
		LinijaDTO dto = new LinijaDTO();
		dto.setId(source.getId());
		dto.setBrojmesta(source.getBrojmesta());
		dto.setCenakarte(source.getCenakarte());
		dto.setVremepolaska(source.getVremepolaska());
		dto.setDestinacija(source.getDestinacija());
		
		dto.setPrevoznikId(source.getPrevoznik().getId());
		dto.setPrevoznikNaziv(source.getPrevoznik().getNaziv());
		
		return dto;
	}
	
	public List<LinijaDTO> convert(List<Linija> linije){
		List<LinijaDTO> ret = new ArrayList<>();
		
		for(Linija a : linije){
			ret.add(convert(a));
		}
		
		return ret;
	}

	
	

}
