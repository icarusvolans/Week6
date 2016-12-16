package springBootApp.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CategoryDAO extends CrudRepository<Category, Long> {
}
