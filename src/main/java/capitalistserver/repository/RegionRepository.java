package capitalistserver.repository;

import capitalistserver.model.territory.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("regionRepository")
public interface RegionRepository extends JpaRepository<Region, Long> {
}