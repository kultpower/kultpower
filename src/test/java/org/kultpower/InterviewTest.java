package org.kultpower;

import com.google.common.base.Stopwatch;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kultpower.entities.Interview;
import org.kultpower.entities.InterviewText;
import org.kultpower.entities.Zeitschrift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Iterator;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = KultpowerApplication.class)
@WebAppConfiguration
public class InterviewTest {

	@Autowired
	InterviewRepository interviewRepository;

	@Test
	public void load() {

		Stopwatch timer = Stopwatch.createStarted();

		Interview one = interviewRepository.findById("michael_hengst_2001-03");

		System.out.println("Method took: " + timer.stop());

		Assert.assertThat("Objekt muss geladen sein", one, Matchers.notNullValue());

		System.out.println(one);

		Set<InterviewText> texte = one.getTexte();
		Assert.assertThat("Texte dürfen nicht null sein", texte, Matchers.notNullValue());
		Assert.assertThat("Texte-Anzahl muss > 0 sein", texte.size(), Matchers.greaterThan(0));

		System.out.println(texte);


	}


}
