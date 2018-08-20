package capitalistserver.repository;

import capitalistserver.model.territory.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("countryRepository")
public interface CountryRepository extends JpaRepository<Country, Long> {
}