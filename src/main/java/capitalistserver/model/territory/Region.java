package capitalistserver.model.territory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "region")
@NoArgsConstructor
@Getter
@Setter
public class Region {
    private String title;
    private long x;
    private long y;
    private int rows, cols;

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
