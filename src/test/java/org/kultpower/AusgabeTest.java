package org.kultpower;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kultpower.entities.Ausgabe;
import org.kultpower.entities.Zeitschrift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;


@SpringBootTest(classes = KultpowerApplication.class)
@WebAppConfiguration
public class AusgabeTest {

	@Autowired
	AusgabenRepository repository;

	@Autowired
	ZeitschriftenRepository zeitschriftenRepository;

	@Test
	public void lesen() {

		Iterable<Ausgabe> all = repository.findAll();

		Assertions.assertThat(all)
			.isNotNull()
			.isNotEmpty();
		}


	@Test
	public void lesen2() {
		Zeitschrift powerplay = zeitschriftenRepository.findById("powerplay").get();
		Ausgabe ausgabe = repository.findByZeitschriftAndShortname(powerplay, "1990-12");

		Assertions.assertThat(ausgabe)
			.isNotNull()
			;
	}
}
