package org.kultpower.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sebastian on 11.01.16.
 */
@Transactional
public interface PowerplayTestberichtDao extends CrudRepository<PowerplayTestbericht, Integer> {

	PowerplayTestbericht findByName(String name);

}
