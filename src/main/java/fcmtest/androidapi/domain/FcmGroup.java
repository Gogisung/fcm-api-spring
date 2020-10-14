package fcmtest.androidapi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class FcmGroup {

    @Id @GeneratedValue
    @Column(name = "group_id")
    private Long id;

    private String groupName;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "fcmGroup")
    private List<FcmToken> groupTokens = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "message_group",
            joinColumns = @JoinColumn(name = "message_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<FcmGroupMessage> fcmGroupMessages = new ArrayList<>();

}
