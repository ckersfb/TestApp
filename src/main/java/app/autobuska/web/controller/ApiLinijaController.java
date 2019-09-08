package app.autobuska.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.autobuska.model.Linija;
import app.autobuska.service.LinijaService;
import app.autobuska.support.LinijaDTOToLinija;
import app.autobuska.support.LinijaToLinijaDTO;
import app.autobuska.web.dto.LinijaDTO;





@RestController
@RequestMapping(value="/api/linije")
public class ApiLinijaController {

	@Autowired
	LinijaService linijaService;
	@Autowired
	private LinijaToLinijaDTO toDTO;
	@Autowired
	private LinijaDTOToLinija toLinija;
	
	
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<LinijaDTO>> getLinije(
			@RequestParam(required=false) String destinacija,
			@RequestParam(required=false) Long prevoznikId,
			@RequestParam(required=false) Double cenakarte,
			@RequestParam(value="pageNum", defaultValue="0") int pageNum){
		
		Page<Linija> linijePage = null;
		
		if(destinacija != null || prevoznikId != null || cenakarte != null) {
			linijePage = linijaService.pretraga(destinacija, prevoznikId, cenakarte, pageNum);
		}
		else {
			linijePage = linijaService.findAll(pageNum);
		}


		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(linijePage.getTotalPages()) );
		
		return new ResponseEntity<>(
				toDTO.convert(linijePage.getContent()),
				headers,
				HttpStatus.OK);
	}
	
	
	
	
	@RequestMapping(method=RequestMethod.POST,
			consumes="application/json")
		public ResponseEntity<LinijaDTO> add(
				@Validated @RequestBody LinijaDTO newLinijaDTO){
		
		Linija savedLinija = linijaService.save(
				toLinija.convert(newLinijaDTO));
		
		return new ResponseEntity<>(
				toDTO.convert(savedLinija), 
				HttpStatus.CREATED);
		}
	
	@RequestMapping(method=RequestMethod.PUT,
			value="/{id}",
			consumes="application/json")
	public ResponseEntity<LinijaDTO> edit(
			@Validated @RequestBody LinijaDTO linijaDTO,
			@PathVariable Long id){
		
		if(!id.equals(linijaDTO.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Linija persisted = linijaService.save(
				toLinija.convert(linijaDTO));
		
		return new ResponseEntity<>(
				toDTO.convert(persisted),
				HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	ResponseEntity<LinijaDTO> getLinija(@PathVariable Long id){
		Linija linija = linijaService.findOne(id);
		if(linija==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(
				toDTO.convert(linija),
				HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	ResponseEntity<LinijaDTO> delete(@PathVariable Long id){
		Linija deleted = linijaService.delete(id);
		
		if(deleted == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(
				toDTO.convert(deleted),
				HttpStatus.OK);
	}
	
}
