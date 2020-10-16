package fcmtest.androidapi.api;

import fcmtest.androidapi.domain.FcmGroupMessage;
import fcmtest.androidapi.service.FcmGroupService;
import fcmtest.androidapi.service.FcmMessageService;
import jdk.jfr.Frequency;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class FcmMessageApiController {

    private final FcmMessageService fcmMessageService;

    @PostMapping("/api/fcmMessage")
    public CreateFcmMessageResponse saveFcmMessage(@RequestBody @Valid CreateFcmMessageRequest request) {
        FcmGroupMessage fcmGroupMessage = new FcmGroupMessage();
        fcmGroupMessage.setGroupName(request.getGroupName());
        fcmGroupMessage.setMessageTitle(request.getMessageTitle());
        fcmGroupMessage.setMessageBody(request.getMessageBody());
        fcmGroupMessage.setSendDate(LocalDateTime.now());

        /**
         *
         * {
         *     groupName:"",
         *     messageTitle:"",
         *     messageBody: "",
         *     sendDate: ""
         * }
         * */

//        fcmNotification(request.);


        Long id =fcmMessageService.join(fcmGroupMessage);

        return new CreateFcmMessageResponse(id);
    }
//
//    @RequestMapping("https://fcm.googleapis.com/fcm/notification")
//    @ResponseBody
//    public void fcmNotification(@RequestBody @Valid String operation, String notificationKeyName, String registrationIds) {
//        System.out.println("operation = " + operation);
//        System.out.println("notificationKeyName = " + notificationKeyName);
//        System.out.println("registrationIds = " + registrationIds);
////        CreateFcmNotificationResponse response = new CreateFcmNotificationResponse();
//
////        return ;
//    }





    @Data
    static class CreateFcmMessageRequest {
        private String groupName;
        private String messageTitle;
        private String messageBody;
    }

    @Data
    static class CreateFcmMessageResponse {
        private Long id;

        public CreateFcmMessageResponse(Long id) {
            this.id = id;
        }
    }


}
