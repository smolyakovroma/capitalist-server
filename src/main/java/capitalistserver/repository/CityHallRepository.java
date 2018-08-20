package capitalistserver.repository;

import capitalistserver.model.builds.CityHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("cityHallRepository")
public interface CityHallRepository extends JpaRepository<CityHall, Long> {
}