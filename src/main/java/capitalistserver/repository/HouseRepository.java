package capitalistserver.repository;

import capitalistserver.model.builds.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("houseRepository")
public interface HouseRepository extends JpaRepository<House, Long> {
}