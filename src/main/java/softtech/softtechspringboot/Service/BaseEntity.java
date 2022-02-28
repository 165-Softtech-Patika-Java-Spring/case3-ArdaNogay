package softtech.softtechspringboot.Service;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@Data
public abstract class BaseEntity implements Cloneable, Serializable {
}
