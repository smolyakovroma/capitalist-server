package capitalistserver.model.territory;

import capitalistserver.model.builds.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cell")
@NoArgsConstructor
@Getter
@Setter
public class Cell {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",length = 19)
    private long id;
    private long x;
    private long y;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "build_fk", nullable = false)
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
