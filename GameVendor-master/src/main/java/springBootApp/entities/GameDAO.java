package springBootApp.entities;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface GameDAO extends CrudRepository<Game, Long> {
    List<Game> findByCategoryId(long categoryId);

    @Query("SELECT g FROM Game g WHERE g.gameTitle LIKE ?1%")
    List<Game> findByNameStartsWith(String name);

    List<Game> findByVendorId(long vendorId);

}
