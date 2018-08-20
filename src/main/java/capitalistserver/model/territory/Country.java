package capitalistserver.model.territory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "country")
@NoArgsConstructor
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",length = 19)
    private long id;
    private String title;
    @OneToMany(mappedBy = "region", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
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
