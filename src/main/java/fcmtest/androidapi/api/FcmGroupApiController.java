package fcmtest.androidapi.api;

import fcmtest.androidapi.domain.FcmGroup;
import fcmtest.androidapi.domain.FcmToken;
import fcmtest.androidapi.service.FcmGroupService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class FcmGroupApiController {

    private final FcmGroupService fcmGroupService;

    public  List<FcmGroup> allFcmGroups() {
        return fcmGroupService.findFcmGroup();
    }

    @GetMapping("/api/fcmGroup")
    public Result fcmGroupsV2() {
        List<FcmGroup> findFcmGroup = fcmGroupService.findFcmGroup();
        List<fcmGroupDto> collet = findFcmGroup.stream()
                .map(m -> new fcmGroupDto(m.getGroupName(), m.getFcmTokens()))
                .collect(Collectors.toList());
        return new Result(collet.size(), collet);
    }


    @Data
    @AllArgsConstructor
    static class Result<T> {
        private int count;
        private T data;
    }

    @Data
    @AllArgsConstructor
    static class fcmGroupDto {
        private String groupName;
        private String fcmTokens;
    }


    @PostMapping("/api/fcmGroup")
    public CreateFcmGroupResponse saveFcmGroupV1(@RequestBody @Valid CreateFcmGroupRequest request) {
        FcmGroup fcmGroup1 = new FcmGroup();
        fcmGroup1.setGroupName(request.getGroupName());
        fcmGroup1.setFcmTokens(request.getFcmTokens());
        fcmGroup1.setCreateDate(LocalDateTime.now());

        //fcm 토큰 생성
//        FcmGroup.createFcmToken(request.getGroupName(), request.getFcmTokens());
//
//        fcmNotification(
//                "create",
//                "gogosing123",
//                "dN3_gcmdQSOk8VjX1pxDRO:APA91bGhVA0IQk9hHueJx17J5SSvFKJ7jheOpTTpTWryGOAjuDz1PoRQR5s4Yb4_WmYRx7dO-ksvzSMNFuhq0HBRZIFkx7SbZMdsUkW70Mcof-QHepgEHvAwgIkHUhSPvU5X79cOlgbZ");
//        Long id = fcmGroupService.join(fcmGroup1);
//        fcmNotification("create", "gogoTest", request.getFcmTokens());
        Long id = fcmGroupService.join(fcmGroup1);

        return new CreateFcmGroupResponse(id);
    }





    @Data
    static class CreateFcmGroupRequest {
        private String groupName;
        private LocalDateTime createDate;
        private String fcmTokens;
    }

    @Data
    static class CreateFcmGroupResponse {
        private Long id;

        public CreateFcmGroupResponse(Long id) {
            this.id = id;
        }
    }

    @RequestMapping("https://fcm.googleapis.com/fcm/notification")
    @ResponseBody
    public void fcmNotification(@RequestBody @Valid String operation, String notificationKeyName, String registrationIds) {
        System.out.println("operation = " + operation);
        System.out.println("notificationKeyName = " + notificationKeyName);
        System.out.println("registrationIds = " + registrationIds);
//        CreateFcmNotificationResponse response = new CreateFcmNotificationResponse();

//        return ;
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

        public CreateFcmNotificationResponse(String notificationKey) {
            this.notificationKey = notificationKey;
        }
    }




}
