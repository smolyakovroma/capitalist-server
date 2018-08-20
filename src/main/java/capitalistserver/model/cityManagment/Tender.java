package capitalistserver.model.cityManagment;

import capitalistserver.model.builds.Build;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tender {

    private TenderType tenderType;
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
