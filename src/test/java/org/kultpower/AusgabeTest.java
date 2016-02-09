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
@Ignore
public class AusgabeTest {

	@Autowired
	AusgabenRepository repository;

	@Test
	public void sichern() {

		Ausgabe ausgabe = new Ausgabe();
		repository.save(ausgabe);

	}

}
