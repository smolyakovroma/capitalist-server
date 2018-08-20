package capitalistserver.model.builds;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class House implements Build {
    private int currentTenants = 0;
    private int limitTenants = 10;

    public boolean increaseTenants(int tenants){
        if(tenants == 0){
            Random random = new Random();
            tenants = random.nextInt(3);
            if(currentTenants+tenants>limitTenants){
                return false;
            }else {
                currentTenants+=tenants;
                return true;
            }
        }else {
            if(currentTenants+tenants>limitTenants){
                return false;
            }else {
                currentTenants+=tenants;
                return true;
            }
        }
    }
}
