package capitalistserver.model.territory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "region")
@NoArgsConstructor
@Getter
@Setter
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",length = 19)
    private long id;
    private String title;
    private long x;
    private long y;
    private int rows, cols;
    @OneToMany(mappedBy = "sector", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    List<Sector> sectors = new ArrayList<Sector>();

    public Region(String title, long x, long y) {
        this.title = title;
        this.x = x;
        this.y = y;
    }

    public List<Sector> getSectors() {
        return sectors;
    }

    public void setSectors(List<Sector> sectors) {
        this.sectors = sectors;
    }
}
