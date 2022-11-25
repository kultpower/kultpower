package org.kultpower;

import au.com.bytecode.opencsv.CSVReader;

import org.junit.jupiter.api.Test;
import org.kultpower.entities.Ausgabe;
import org.kultpower.entities.Zeitschrift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sebastian on 29.04.16.
 */
@SpringBootTest(classes = KultpowerApplication.class)
//@ActiveProfiles("hsqldb")
public class DatabaseReadFromCSV {

	@Autowired
	ZeitschriftenRepository zeitschriftenRepository;

	@Autowired
	JpaTransactionManager txManager;

	@Test
	public void read() throws IOException {


		Map<String, Zeitschrift> zeitschriftenNachId = new HashMap<>();
		String [] nextLine;

		CSVReader readerZeitschriften = new CSVReader(new FileReader("src/test/resources/data/csv/zeitschriften.csv"), '	');
		while ((nextLine = readerZeitschriften.readNext()) != null) {
			try {
				if (nextLine[0].startsWith("#")) {
					continue;
				}
				/*
				for (int i=0; i<nextLine.length; i++) {
					System.out.print(nextLine[i] + "	" );
				}
				*/
				System.out.println();
				Zeitschrift z = new Zeitschrift();
				z.getAusgaben();
				z.setId(nextLine[0]);
				z.setName(nextLine[1]);
				zeitschriftenNachId.put(nextLine[0], z);

			} catch (Exception e) {
				e.printStackTrace();;
			}
		}

		CSVReader readerAusgaben = new CSVReader(new FileReader("src/test/resources/data/csv/ausgaben.csv"), '	');
		//UUID	coverfile	zeitschrift	short	jahr	nummer

		while ((nextLine = readerAusgaben.readNext()) != null) {
			try {
				if (nextLine[0].startsWith("#")) {
					continue;
				}

				String id = nextLine[0];
				String coverfile = nextLine[1];
				String zeitschriftId = nextLine[2];
				String shortname = nextLine[3];
				Integer jahr = Integer.parseInt(nextLine[4]);
				Integer nummer = Integer.parseInt(nextLine[5]);

				Ausgabe a = new Ausgabe();
				a.setId(id);
				a.setCoverfile(coverfile);
				a.setShortname(shortname);
				a.setJahr(jahr);
				a.setNummer(nummer);

				Zeitschrift z = zeitschriftenNachId.get(zeitschriftId);
				a.setZeitschrift(z);
				z.getAusgaben().add(a);

			} catch (Exception e) {
				System.out.println("Fehler: " + e.getMessage() + "\n" + Arrays.toString(nextLine));
			}
		}


		for(String zeitschriftId : zeitschriftenNachId.keySet()) {

			DefaultTransactionDefinition def = new DefaultTransactionDefinition();
			def.setName("rootTransaction");
			def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
			TransactionStatus status = txManager.getTransaction(def);

			Zeitschrift z = zeitschriftenNachId.get(zeitschriftId);
			System.out.println(z);
			zeitschriftenRepository.save(z);

			txManager.commit(status);

		}




	}
}
