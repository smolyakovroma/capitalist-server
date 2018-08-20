package capitalistserver.model.builds;

import capitalistserver.model.cityManagment.Tender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cityHall")
@NoArgsConstructor
@Getter
@Setter
public class CityHall implements Build {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",length = 19)
    private long id;
    private double budget = 1000000d;
    @OneToMany(mappedBy = "tender", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    List<Tender> tenders = new ArrayList<Tender>();
}
