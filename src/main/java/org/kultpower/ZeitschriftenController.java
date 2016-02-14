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

//	@Autowired
//	StaticResourceConfiguration staticResourceConfiguration;

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

	/*
	@RequestMapping(value = "/files/{id}", method = RequestMethod.GET)
	public String findOne(@PathVariable String id, Model model) {
		Zeitschrift one = repo.findOne(id);
		model.addAttribute("one", one);
		System.out.println(one.getName());

		//staticResourceConfiguration
		String folder = staticResourceConfiguration.getStaticResources() + "/zeitschriften/" + id + "/cover/150/";
		Path path= Paths.get(folder);
		final List<Path> files=new ArrayList<>();
		final List<String> filenames=new ArrayList<>();
		try {
			Files.walkFileTree(path, new SimpleFileVisitor<Path>(){
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					if(!attrs.isDirectory()){
						files.add(file);
						String s = file.toAbsolutePath().toString().replaceFirst(staticResourceConfiguration.getStaticResources(), "");
						//System.out.println(file.toAbsolutePath());
						//System.out.println(s);
						filenames.add(s);
					}
					return FileVisitResult.CONTINUE;
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

		model.addAttribute("filenames", filenames);
		return "zeitschrift_files";
	}
	*/

	@RequestMapping(value = "/{zeitschriftId}", method = RequestMethod.GET)
	public String zeigeZeitschrift(@PathVariable String zeitschriftId, Model model) {
		Zeitschrift one = repo.findOne(zeitschriftId);
		model.addAttribute("one", one);
		//System.out.println(one.getAusgaben().iterator().next());

		return "zeitschrift";
	}

	@RequestMapping(value = "/{zeitschriftId}/{ausgabeId}", method = RequestMethod.GET)
	public String zeigeAusgabe(
			@PathVariable String zeitschriftId,
			@PathVariable String ausgabeId,
			Model model) {

		model.addAttribute("ausgabeId", ausgabeId);
		Zeitschrift zeitschrift = repo.findOne(zeitschriftId);

		model.addAttribute("zeitschrift", zeitschrift);

		Ausgabe ausgabe = ausgabenRepo.findOne(ausgabeId);
		model.addAttribute("ausgabe", ausgabe);

		return "ausgabe";
	}
}
