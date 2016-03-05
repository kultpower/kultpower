package org.kultpower;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kultpower.entities.Ausgabe;
import org.kultpower.entities.Zeitschrift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = KultpowerApplication.class)
@WebAppConfiguration
public class AusgabeTest {

	@Autowired
	AusgabenRepository repository;

	@Autowired
	ZeitschriftenRepository zeitschriftenRepository;

	@Test
	@Ignore
	public void lesen() {

		Iterable<Ausgabe> all = repository.findAll();

		Assert.assertThat(all, Matchers.notNullValue());
	}


	@Test
	public void lesen2() {
		Zeitschrift powerplay = zeitschriftenRepository.findOne("powerplay");
		Ausgabe ausgabe = repository.findByZeitschriftAndShortname(powerplay, "1990-12");

		Assert.assertThat(ausgabe, Matchers.notNullValue());

		System.out.println(ausgabe);
	}
}
