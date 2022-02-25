package softtech.softtechspringboot.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "PRODUCT")
public class Product {

    @Id
    @SequenceGenerator(name = "Product",sequenceName = "PRODUCT_ID_SEQ")
    @GeneratedValue(generator = "Product")
    private Long id;

    @Column(name = "NAME",length = 70,nullable = false)
    private String name;

    @Column(name = "PRICE",precision =19 ,scale = 2,nullable = false)
    private Integer price;

}

