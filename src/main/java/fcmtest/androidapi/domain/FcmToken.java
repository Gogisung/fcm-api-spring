package fcmtest.androidapi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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

    @NotEmpty
    private String registration_id;

    //생성 메서드
//    public static FcmToken createFcmToken(List<String> registrationId) {
//        FcmToken fcmToken = new FcmToken();
//        fcmToken.setRegistration_id(registrationId);
//        return fcmToken;
//    }
}
