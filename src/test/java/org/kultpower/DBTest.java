package org.kultpower;

import com.google.common.base.Stopwatch;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kultpower.entities.Zeitschrift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Iterator;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = KultpowerApplication.class)
@WebAppConfiguration
public class DBTest {

	@Autowired
	ZeitschriftenRepository zeitschriftenRepository;

	@Test
	public void loadZeitschrift() {

		Stopwatch timer = Stopwatch.createStarted();

		Zeitschrift powerplay = zeitschriftenRepository.findById("powerplay");

		System.out.println("Method took: " + timer.stop());

		Assert.assertThat("Zeitschrift-Objekt muss geladen sein", powerplay, Matchers.notNullValue());
		Assert.assertThat("Ausgaben-Set darf nicht null sein", powerplay.getAusgaben(), Matchers.notNullValue());
		Assert.assertThat("mindestens eine Ausgabe", powerplay.getAusgaben().size(), Matchers.greaterThan(0));

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
		zeitschriftenRepository.findOne(z);
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
			Assert.assertThat("Zeitschrift-Objekt muss geladen sein", zeitschrift, Matchers.notNullValue());
			Assert.assertThat("Ausgaben-Set darf nicht null sein " + zeitschrift.getName(), zeitschrift.getAusgaben(), Matchers.notNullValue());
			Assert.assertThat("mindestens eine Ausgabe " + zeitschrift.getName(), zeitschrift.getAusgaben().size(), Matchers.greaterThan(0));

		}


	}

}
