package org.kultpower;

import org.kultpower.entities.Interview;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by sebastian on 28.01.16.
 */
@Repository
public interface InterviewRepository extends CrudRepository<Interview, String> {


	@EntityGraph(value = "Interview.texte", type = EntityGraph.EntityGraphType.LOAD)
	Optional<Interview> findById(String id);

	List<Interview> findAllByOrderByDatumAsc();

}
