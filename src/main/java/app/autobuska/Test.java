package app.autobuska;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.autobuska.model.Linija;
import app.autobuska.model.Prevoznik;
import app.autobuska.service.LinijaService;
import app.autobuska.service.PrevoznikService;






@Component
public class Test {
	
	@Autowired
	private LinijaService linijaService;
	@Autowired
	private PrevoznikService prevoznikService;
	@Autowired
	private PrevoznikService ps;
	
	@PostConstruct
	public void init() {
		
		Prevoznik pre1 = new Prevoznik();
		
		pre1.setNaziv("Lasta ");
		pre1.setAdresa("Koste racina 3222");
		pre1.setPib("a12222");
		prevoznikService.save(pre1);
		
		Prevoznik pre2 = new Prevoznik();
		
		pre2.setNaziv("Boka Tours ");
		pre2.setAdresa("Koste racina 3222");
		pre2.setPib("a12");
		prevoznikService.save(pre2);
		
		Linija linija1 = new Linija();
		linija1.setBrojmesta(32);
		linija1.setCenakarte(69.00);
		linija1.setVremepolaska("15:30");
		linija1.setDestinacija("telep");
		linija1.setPrevoznik(pre1);
		
		linijaService.save(linija1);
		
	}

}
