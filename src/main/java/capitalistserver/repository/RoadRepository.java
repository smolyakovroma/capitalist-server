package capitalistserver.repository;

import capitalistserver.model.builds.Road;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roadRepository")
public interface RoadRepository extends JpaRepository<Road, Long> {
}
