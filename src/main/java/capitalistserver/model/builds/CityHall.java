package capitalistserver.model.builds;

import capitalistserver.model.cityManagment.Tender;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CityHall implements Build {

    private double budget = 1000000d;
    List<Tender> tenders = new ArrayList<Tender>();
}
