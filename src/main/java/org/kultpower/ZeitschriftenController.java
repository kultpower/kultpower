package org.kultpower;

import java.util.Iterator;


import org.kultpower.entities.Ausgabe;
import org.kultpower.entities.Zeitschrift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.persistence.EntityManager;

@Controller
@RequestMapping(value = "/zeitschriften")
public class ZeitschriftenController {

	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Zeitschrift nicht gefunden")  // 404
	public class ZeitschriftNotFoundException extends RuntimeException {

	}

	@Autowired
	ZeitschriftenRepository repo;

	@Autowired
	AusgabenRepository ausgabenRepo;

	@Autowired
	private EntityManager entityManager;

	@RequestMapping(method = RequestMethod.GET)
	public String zeitschrift(Model model) {

		Iterable<Zeitschrift> all = repo.findAll();
		Iterator<Zeitschrift> iterator = all.iterator();
		while(iterator.hasNext()) {
			Zeitschrift zeitschrift = iterator.next();
			System.out.println(zeitschrift.getId());
		}
		model.addAttribute("all", all);
		return "zeitschriften";
	}

	@RequestMapping(value = "/{zeitschriftId}", method = RequestMethod.GET)
	public String zeigeZeitschrift(@PathVariable String zeitschriftId, Model model) {
		Zeitschrift one = repo.findById(zeitschriftId).get();

		if (one==null) {
			throw new ZeitschriftNotFoundException();
		}
		model.addAttribute("one", one);

		return "zeitschrift";
	}


	@RequestMapping(value = "/{zeitschriftId}/{ausgabeShortname}", method = RequestMethod.GET)
	public String zeigeAusgabe(
			@PathVariable String zeitschriftId,
			@PathVariable String ausgabeShortname,
			Model model) {

		model.addAttribute("ausgabeId", ausgabeShortname);
		Zeitschrift zeitschrift = repo.findById(zeitschriftId).get();

		model.addAttribute("zeitschrift", zeitschrift);

		Ausgabe ausgabe = ausgabenRepo.findByZeitschriftAndShortname(zeitschrift, ausgabeShortname);
		model.addAttribute("ausgabe", ausgabe);

		return "ausgabe";
	}

	public String getText() {
		String s = "System.currentTimeMillis(): " + System.currentTimeMillis();
		System.out.println(s);
		return "" + s;
	}
}
