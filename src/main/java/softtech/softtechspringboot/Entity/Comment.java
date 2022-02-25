package softtech.softtechspringboot.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "COMMENT")
public class Comment {

    @Id
    @SequenceGenerator(name = "Comment" ,sequenceName = "COMMENT_ID_SEQ")
    @GeneratedValue(generator = "Comment")
    private Long id;

    @Column(name = "ID_USER",length = 70,nullable = false,unique = true)
    private Long userId;

    @Column(name = "ID_PRODUCT",length = 70,nullable = false,unique = true)
    private Long productId;

    @Column(name = "MESAGE",length = 500,nullable = false)
    private String message;

}
