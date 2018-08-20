package capitalistserver.model.builds;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "house")
@NoArgsConstructor
@Getter
@Setter
public class House implements Build {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",length = 19)
    private long id;
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
