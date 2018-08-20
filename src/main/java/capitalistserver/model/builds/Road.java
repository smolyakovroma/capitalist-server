package capitalistserver.model.builds;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "road")
@NoArgsConstructor
@Getter
@Setter
public class Road implements Build {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",length = 19)
    private long id;
    private int speed = 5;
}
