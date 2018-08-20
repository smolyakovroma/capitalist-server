package capitalistserver.model.territory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "country")
@NoArgsConstructor
@Getter
@Setter
public class Country {
    private String title;
    private List<Region> regions = new ArrayList<Region>();

    public Country(String title) {
        this.title = title;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }
}
