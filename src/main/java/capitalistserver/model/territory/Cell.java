package capitalistserver.model.territory;

import capitalistserver.model.builds.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cell")
@NoArgsConstructor
@Getter
@Setter
public class Cell {

    private long x;
    private long y;
    private Build build;
    private CellType cellType;

    public Cell(long x, long y, CellType cellType) {
        this.x = x;
        this.y = y;
        this.cellType = cellType;
    }

    @Override
    public String toString() {

        if (build instanceof House) {
            return "T";
        } else if (build instanceof CityHall) {
            return "H";
        } else if (build instanceof Road) {
            return "+";
        } else if (build instanceof Debris) {
            return "D";
        } else {
            return "X";
        }

    }
}
