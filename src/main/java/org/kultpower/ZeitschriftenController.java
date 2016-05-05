package org.kultpower;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.kultpower.entities.Ausgabe;
import org.kultpower.entities.Zeitschrift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.history.Revision;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityManager;
import java.util.Iterator;
import java.util.List;

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
		Zeitschrift one = repo.findById(zeitschriftId);

		if (one==null) {
			throw new ZeitschriftNotFoundException();
		}
		model.addAttribute("one", one);

		/*
		System.out.println("calling repo.findRevisions:");
		List<Revision<Integer, Zeitschrift>> revisionList = repo.findRevisions(zeitschriftId).getContent();
		System.out.println("finished executing repo.findRevisions");
		System.out.println(revisionList.size());
		model.addAttribute("revisionList", revisionList);

		List<Revision<Integer, Zeitschrift>> revisionList2 = new ArrayList<>();
		for (Revision<Integer, Zeitschrift> rev : revisionList) {
			System.out.println("calling AuditQuery for revision " + rev.getRevisionNumber() + ":");
			AuditReader reader = AuditReaderFactory.get(entityManager);
			AuditQuery query = reader.createQuery()
					.forEntitiesAtRevision(Zeitschrift.class, rev.getRevisionNumber());
			Zeitschrift z = (Zeitschrift) query.getSingleResult();
			System.out.println("finished executing AuditQuery");
			//System.out.println("calling repo.findById:");
			//load with all related objects via entity graph:
			//z = repo.findById(z.getId());
			//System.out.println("finished executing repo.findById");
			Revision<Integer, Zeitschrift> newRevision = new Revision<>(rev.getMetadata(), z);
			revisionList2.add(newRevision);
		}
		model.addAttribute("revisionList2", revisionList2);

		model.addAttribute("this", this);
		*/
		return "zeitschrift";
	}

	@RequestMapping(value = "/{zeitschriftId}/revisions", method = RequestMethod.GET)
	public String zeigeZeitschriftRevisions(
			@PathVariable String zeitschriftId,
			Model model) {

		List<Revision<Integer, Zeitschrift>> revisionList = repo.findRevisions(zeitschriftId).getContent();
		model.addAttribute("revisionList", revisionList);

		return "zeitschrift_revisions";
	}

	@RequestMapping(value = "/{zeitschriftId}/revisions/{revision}", method = RequestMethod.GET)
	public String zeigeZeitschriftNachRevision(
			@PathVariable String zeitschriftId,
			@PathVariable Integer revision,
			Model model) {

		AuditReader reader = AuditReaderFactory.get(entityManager);
		AuditQuery query = reader.createQuery()
				.forEntitiesAtRevision(Zeitschrift.class, revision);
		query.add(AuditEntity.property("id").eq(zeitschriftId));

		Zeitschrift z = (Zeitschrift) query.getSingleResult();

		if (z==null) {
			throw new ZeitschriftNotFoundException();
		}
		model.addAttribute("one", z);

		return "zeitschrift";
	}

	@RequestMapping(value = "/{zeitschriftId}/{ausgabeShortname}", method = RequestMethod.GET)
	public String zeigeAusgabe(
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

	public String getText() {
		String s = "System.currentTimeMillis(): " + System.currentTimeMillis();
		System.out.println(s);
		return "" + s;
	}
}
