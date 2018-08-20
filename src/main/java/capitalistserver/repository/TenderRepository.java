package capitalistserver.repository;

import capitalistserver.model.cityManagment.Tender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tenderRepository")
public interface TenderRepository extends JpaRepository<Tender, Long> {
}