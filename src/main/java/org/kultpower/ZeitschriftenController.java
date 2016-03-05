package org.kultpower;

import com.sun.org.apache.xml.internal.utils.StringComparable;
import org.kultpower.entities.Ausgabe;
import org.kultpower.entities.Zeitschrift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.style.ToStringCreator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping(value = "/zeitschriften")
public class ZeitschriftenController {

	@Autowired
	ZeitschriftenRepository repo;

	@Autowired
	AusgabenRepository ausgabenRepo;

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
		Zeitschrift one = repo.findById(zeitschriftId);
		model.addAttribute("one", one);
		//System.out.println(one.getAusgaben().iterator().next());

		return "zeitschrift";
	}

	@RequestMapping(value = "/{zeitschriftId}/{ausgabeShortname}", method = RequestMethod.GET)
	public String zeigeAusgabeNeu(
			@PathVariable String zeitschriftId,
			@PathVariable String ausgabeShortname,
			Model model) {

		model.addAttribute("ausgabeId", ausgabeShortname);
		Zeitschrift zeitschrift = repo.findOne(zeitschriftId);

		model.addAttribute("zeitschrift", zeitschrift);

		Ausgabe ausgabe = ausgabenRepo.findByZeitschriftAndShortname(zeitschrift, ausgabeShortname);
		model.addAttribute("ausgabe", ausgabe);

		return "ausgabe";
	}

	//@RequestMapping(value = "/{zeitschriftId}/{ausgabeId}", method = RequestMethod.GET)
	public String zeigeAusgabe(
			@PathVariable String zeitschriftId,
			@PathVariable String ausgabeId,
			Model model) {

		model.addAttribute("ausgabeId", ausgabeId);
		Zeitschrift zeitschrift = repo.findById(zeitschriftId);

		model.addAttribute("zeitschrift", zeitschrift);

		Ausgabe ausgabe = ausgabenRepo.findOne(ausgabeId);
		model.addAttribute("ausgabe", ausgabe);

		return "ausgabe";
	}
}
