package fcmtest.androidapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class FcmGroup {

    @Id @GeneratedValue
    @Column(name = "group_id")
    private Long id;

    @NotEmpty
    private String groupName;

    @JsonIgnore
    private LocalDateTime createDate;

//    @OneToMany(mappedBy = "fcmGroup")
//    private List<FcmToken> fcmTokens = new ArrayList<>();
    private String fcmTokens;

//    @ManyToMany
//    @JoinTable(name = "message_group",
//            joinColumns = @JoinColumn(name = "message_id"),
//            inverseJoinColumns = @JoinColumn(name = "group_id"))
//    private List<FcmMessage> fcmMessages = new ArrayList<>();

    //연관관계 메서드
//    public void addFcmToken(FcmToken fcmToken) {
//        fcmTokens.add(fcmToken);
//        fcmToken.setFcmGroup(this);
//    }

    //생성 메서드
//    public static FcmGroup createFcmToken(String groupName, FcmToken... fcmTokens) {
//        FcmGroup fcmGroup = new FcmGroup();
//        fcmGroup.setGroupName(groupName);
//        for (FcmToken fcmToken : fcmTokens) {
//            fcmGroup.addFcmToken(fcmToken);
//        }
//        fcmGroup.setCreateDate(LocalDateTime.now());
//        return fcmGroup;
//    }
}
