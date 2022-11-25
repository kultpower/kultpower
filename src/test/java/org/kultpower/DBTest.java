package org.kultpower;

import com.google.common.base.Stopwatch;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kultpower.entities.Zeitschrift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Iterator;

@SpringBootTest(classes = KultpowerApplication.class)
@WebAppConfiguration
public class DBTest {

	@Autowired
	ZeitschriftenRepository zeitschriftenRepository;

	@Test
	public void loadZeitschrift() {

		Stopwatch timer = Stopwatch.createStarted();

		Zeitschrift powerplay = zeitschriftenRepository.findById("powerplay").get();

		System.out.println("Method took: " + timer.stop());

		Assertions.assertThat(powerplay).isNotNull();
		Assertions.assertThat(powerplay.getAusgaben()).isNotNull().isNotEmpty();

		System.out.println(powerplay);

	}

	@Test
	public void testPerformance() {
		performanceLoad("powerplay");
		performanceLoad("amigajoker");
		performanceLoad("asm");
		performanceLoad("videogames");
		performanceLoad("amigamagazin");
		performanceLoad("clubnintendo");

	}

	private void performanceLoad(String z) {
		Stopwatch timer = Stopwatch.createStarted();
		zeitschriftenRepository.findById(z).get();
		System.out.println(z + ": Method took " + timer.stop());
	}


	@Test
	public void loadAlleZeitschriften() {

		long startTime = System.currentTimeMillis();

		Iterable<Zeitschrift> all = zeitschriftenRepository.findAll();

		long endTime = System.currentTimeMillis();
		System.out.println("loadAlleZeitschriften: That took " + (endTime - startTime) + " milliseconds");


		Iterator<Zeitschrift> zeitschriftIterator = all.iterator();
		while (zeitschriftIterator.hasNext()) {
			Zeitschrift zeitschrift = zeitschriftIterator.next();
			Assertions.assertThat(zeitschrift).isNotNull();
			Assertions.assertThat(zeitschrift.getAusgaben()).isNotNull().isNotEmpty();

		}


	}

}
