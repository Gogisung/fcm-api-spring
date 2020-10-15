package fcmtest.androidapi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class FcmGroupMessage {

    @Id @GeneratedValue
    @Column(name = "message_id")
    private Long id;

    private String groupName;
    private String messageTitle;
    private String messageBody;
    private LocalDateTime sendDate;

//    @ManyToMany(mappedBy = "fcmGroupMessages")
//    private List<FcmGroup> fcmGroups = new ArrayList<>();
}
