package fcmtest.androidapi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tokens")
@Getter @Setter
public class FcmToken {

    @Id @GeneratedValue
    @Column(name = "token_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private FcmGroup fcmGroup;

}
