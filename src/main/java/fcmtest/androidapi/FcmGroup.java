package fcmtest.androidapi;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class FcmGroup {

    @Id @GeneratedValue
//    @Column(name = "group_id")
    private Long id;
    private String groupName;
//    private List<GroupToken> groupTokens = new ArrayList<>();

}
