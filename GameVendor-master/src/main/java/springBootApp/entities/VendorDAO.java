package springBootApp.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface VendorDAO extends CrudRepository<Vendor, Long> {
}
