package softtech.softtechspringboot.Entity;

import lombok.Getter;
import lombok.Setter;
import softtech.softtechspringboot.Service.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "COMMENT")
public class Comment extends BaseEntity {

    @Id
    @SequenceGenerator(name = "Comment" ,sequenceName = "COMMENT_ID_SEQ",allocationSize = 1)
    @GeneratedValue(generator = "Comment")
    private Long id;

    @Column(name = "ID_USER",length = 70,nullable = false)
    private Long userId;

    @Column(name = "ID_PRODUCT",length = 70,nullable = true)
    private Long productId;

    @Column(name = "MESSAGE",length = 500,nullable = true)
    private String message;

}
