package fcmtest.androidapi.api;

import fcmtest.androidapi.domain.FcmGroup;
import fcmtest.androidapi.domain.FcmToken;
import fcmtest.androidapi.service.FcmGroupService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FcmGroupApiController {

    private final FcmGroupService fcmGroupService;


    @PostMapping("/api/fcmGroup")
    public CreateFcmGroupResponse saveFcmGroupV1(@RequestBody @Valid CreateFcmGroupRequest request) {
        FcmGroup fcmGroup1 = new FcmGroup();
        fcmGroup1.setGroupName(request.getGroupName());
        fcmGroup1.setCreateDate(LocalDateTime.now());
//        fcmGroup1.setFcmTokens(request.getFcmTokens());

        //fcm 토큰 생성
        FcmGroup.createFcmToken();

        Long id = fcmGroupService.join(fcmGroup1);
//        fcmNotification("create", "gogoTest", request.getFcmTokens());
        return new CreateFcmGroupResponse(id);
    }

    @RequestMapping("https://fcm.googleapis.com/fcm/notification")
    @ResponseBody
    public CreateFcmNotificationResponse fcmNotification(@RequestBody @Valid String operation, String notificationKeyName, List<FcmToken> registrationIds) {
        return new CreateFcmNotificationResponse();
    }

//    @Data
//    static class CreateFcmNotificationRequest {
//        private String operation;
//        private String notificationKeyName;
//        private List<String> registrationIds;
//    }

    @Data
    static class CreateFcmNotificationResponse {
        private String notificationKey;

//        public CreateFcmNotificationResponse(String notificationKey) {
//            this.notificationKey = notificationKey;
//        }

        public CreateFcmNotificationResponse() {

        }
    }


    @Data
    static class CreateFcmGroupRequest {
        private String groupName;
        private LocalDateTime createDate;
        private List<FcmToken> fcmTokens;
    }

    @Data
    static class CreateFcmGroupResponse {
        private Long id;

        public CreateFcmGroupResponse(Long id) {
            this.id = id;
        }
    }


}
