package cost.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cost.management.entities.DipendenteCommessa;
import cost.management.service.DipendenteCommessaService;

@RestController
@RequestMapping("/api")
public class DipendenteCommessaController {

	@Autowired
	private DipendenteCommessaService dipCommService;
	

	@PostMapping(value="/dipendentecommessa/{dipendenteid}/{commessaid}" ,consumes={"application/json"})
	public DipendenteCommessa addDipendenteCommessa(@RequestBody DipendenteCommessa dipCommessa,
			@PathVariable("dipendenteid") String dipendenteid, @PathVariable("commessaid") String commessaid) {
		//DipendenteCommessa dipCommessa = new DipendenteCommessa();
		System.out.println("INSIDE CONTROLLER&&&&&&&&&&&&&&&&");
		System.out.println("DIPENDENTE ID :" + dipendenteid);
		System.out.println("OGGETTO DIPEDNETECOMEESSA CODICE FISCALE !@@@@@@: "+ dipCommessa.getId().getDipendenteCodiceFiscale().toString());
		System.out.println("OGGETTO DIPEDNETECOMEESSA CODICE COMMESSA !@@@@@@: "+ dipCommessa.getId().getCommessaCodice().toString());

		return dipCommService.addDipendenteCommessa(dipCommessa, dipendenteid, commessaid);
	}

}