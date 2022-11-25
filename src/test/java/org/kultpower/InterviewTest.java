package org.kultpower;

import com.google.common.base.Stopwatch;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kultpower.entities.Interview;
import org.kultpower.entities.InterviewText;
import org.kultpower.entities.Zeitschrift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Iterator;
import java.util.Set;

@SpringBootTest(classes = KultpowerApplication.class)
@WebAppConfiguration
public class InterviewTest {

	@Autowired
	InterviewRepository interviewRepository;

	@Test
	public void load() {

		Stopwatch timer = Stopwatch.createStarted();

		Interview one = interviewRepository.findById("michael_hengst_2001-03").get();

		System.out.println("Method took: " + timer.stop());

		Assertions.assertThat(one).isNotNull();

		System.out.println(one);

		Set<InterviewText> texte = one.getTexte();
		Assertions.assertThat(texte).isNotNull().isNotEmpty();

		System.out.println(texte);


	}


}
