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
    @SequenceGenerator(name = "Comment" ,sequenceName = "COMMENT_ID_SEQ",allocationSize = 1)
    @GeneratedValue(generator = "Comment")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_USER",length = 70,nullable = false)
    private Long userId;

    @Column(name = "ID_PRODUCT",length = 70,nullable = true)
    private Long productId;

    @Column(name = "MESSAGE",length = 500,nullable = true)
    private String message;

}
