package app.autobuska.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import app.autobuska.model.Linija;
import app.autobuska.model.Prevoznik;
import app.autobuska.service.LinijaService;
import app.autobuska.service.PrevoznikService;
import app.autobuska.web.dto.LinijaDTO;



@Component
public class LinijaDTOToLinija implements Converter<LinijaDTO, Linija> {
	@Autowired
	private LinijaService linijaService;
	@Autowired
	private PrevoznikService prevoznikService;

	@Override
	public Linija convert(LinijaDTO source) {
		Linija linija;
		Prevoznik p = prevoznikService.findOne(source.getPrevoznikId());
		
		if(source.getId()==null){
			linija = new Linija();
		}else{
			linija = linijaService.findOne(source.getId());
		}
		
		
		
		linija.setBrojmesta(source.getBrojmesta());
		linija.setCenakarte(source.getCenakarte());
		linija.setVremepolaska(source.getVremepolaska());
		linija.setDestinacija(source.getDestinacija());
		
		linija.setPrevoznik(p);
		return linija;
	}
		
		public List<Linija> convert(List<LinijaDTO> linijaDTOs){
			List<Linija> ret = new ArrayList<>();
			
			for(LinijaDTO linijaDTO : linijaDTOs){
				ret.add(convert(linijaDTO));
			}
			
			return ret;
		
	}

}
