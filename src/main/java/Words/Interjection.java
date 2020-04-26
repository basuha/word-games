package Words;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(Type.INTERJECTION)
public class Interjection extends Word {

}
