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
    @SequenceGenerator(name = "Product",sequenceName = "PRODUCT_ID_SEQ",allocationSize = 1)
    @GeneratedValue(generator = "Product")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME",length = 70,nullable = true)
    private String name;

    @Column(name = "PRICE",precision =19 ,scale = 2,nullable = true)
    private Integer price;

}

