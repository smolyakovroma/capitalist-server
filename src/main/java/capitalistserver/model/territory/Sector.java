package capitalistserver.model.territory;

import capitalistserver.model.builds.Build;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sector")
@NoArgsConstructor
@Getter
@Setter
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",length = 19)
    private long id;
    private String title;
    private long x;
    private long y;
    private int rows, cols;
    private SectorType sectorType;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "build_fk", nullable = false)
    private Build cityHall;

    @OneToMany(mappedBy = "cell", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Cell> cells = new ArrayList<Cell>();

    public Sector(String title, long x, long y, SectorType sectorType) {
        this.title = title;
        this.x = x;
        this.y = y;
        this.sectorType = sectorType;
    }


    @Override
    public String toString() {
        return "Sector{" + title + " " + x +
                " " + y +
                " " + sectorType + "}";
    }


}
