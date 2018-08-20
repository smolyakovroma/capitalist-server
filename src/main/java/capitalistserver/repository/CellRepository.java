package capitalistserver.repository;

import capitalistserver.model.territory.Cell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("cellRepository")
public interface CellRepository extends JpaRepository<Cell, Long> {
}
