package org.kultpower;

import org.kultpower.entities.Ausgabe;
import org.kultpower.entities.Zeitschrift;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sebastian on 28.01.16.
 */
@Repository
public interface AusgabenRepository extends CrudRepository<Ausgabe, String> {


	Ausgabe findByZeitschriftAndShortname(String zeitschrift, String shortname);


}
