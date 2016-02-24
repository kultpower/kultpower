package org.kultpower;

import org.kultpower.entities.Interview;
import org.kultpower.entities.Zeitschrift;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sebastian on 28.01.16.
 */
@Repository
public interface InterviewRepository extends CrudRepository<Interview, String> {


	@EntityGraph(value = "Interview.texte", type = EntityGraph.EntityGraphType.LOAD)
	Interview findById(String id);

}
