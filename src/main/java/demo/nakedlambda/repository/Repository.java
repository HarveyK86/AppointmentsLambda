package demo.nakedlambda.repository;

import demo.nakedlambda.entity.Entity;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface Repository<E extends Entity> extends CrudRepository<E, Long> {

  List<String> getPaths();

}