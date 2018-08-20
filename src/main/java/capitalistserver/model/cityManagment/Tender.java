package capitalistserver.model.cityManagment;

import capitalistserver.model.builds.Build;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tender")
@NoArgsConstructor
@Getter
@Setter
public class Tender {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 19)
    private long id;
    private TenderType tenderType;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "build_fk", nullable = false)
    private Build build;
    private double budget;
    private TenderStatus tenderStatus = TenderStatus.POSTED;

    public Tender(TenderType tenderType, Build build, double budget) {
        this.tenderType = tenderType;
        this.build = build;
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Tender{" +
                "tenderType=" + tenderType +
                ", build=" + build +
                ", budget=" + budget +
                ", tenderStatus=" + tenderStatus +
                '}';
    }
}
