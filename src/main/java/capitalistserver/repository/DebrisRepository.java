package capitalistserver.repository;

import capitalistserver.model.builds.Debris;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("debrisRepository")
public interface DebrisRepository extends JpaRepository<Debris, Long> {
}
