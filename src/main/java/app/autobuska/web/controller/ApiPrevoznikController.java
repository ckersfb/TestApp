package app.autobuska.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.autobuska.model.Prevoznik;
import app.autobuska.service.PrevoznikService;
import app.autobuska.support.PrevoznikDTOToPrevoznik;
import app.autobuska.support.PrevoznikToPrevoznikDTO;
import app.autobuska.web.dto.PrevoznikDTO;



@RestController
@RequestMapping(value="/api/prevoznici")
public class ApiPrevoznikController {
	@Autowired
	private PrevoznikToPrevoznikDTO toDTO;
	@Autowired
	private PrevoznikDTOToPrevoznik toPrevoznik;
	@Autowired
	private PrevoznikService prevoznikService;
	
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<PrevoznikDTO>> getPrevoznici(
			@RequestParam(value="name", required=false) String name){
		
		List<Prevoznik> prevoznici;
		
		if(name!=null){
			prevoznici=prevoznikService.findByName(name);
		}else{
			prevoznici = prevoznikService.findAll();
		}
		return new ResponseEntity<>(
				toDTO.convert(prevoznici), 
				HttpStatus.OK);
	
}
	
	@RequestMapping(method=RequestMethod.POST,
			consumes="application/json")
		public ResponseEntity<PrevoznikDTO> add(
				@Validated @RequestBody PrevoznikDTO newPrevoznikDTO){
		
		Prevoznik savedPrevoznik = prevoznikService.save(
				toPrevoznik.convert(newPrevoznikDTO));
		
		return new ResponseEntity<>(
				toDTO.convert(savedPrevoznik), 
				HttpStatus.CREATED);
		}
	@ExceptionHandler(value=DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

}
}
