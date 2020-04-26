package Words;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(Type.PARTICLE)
public class Particle extends Word {

}
