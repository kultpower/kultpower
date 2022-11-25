package org.kultpower.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sebastian on 11.01.16.
 */
public interface PowerplayTestberichtDao extends CrudRepository<PowerplayTestbericht, Integer> {

	PowerplayTestbericht findByName(String name);

}
