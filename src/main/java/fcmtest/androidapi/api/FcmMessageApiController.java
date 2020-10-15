package fcmtest.androidapi.api;

import fcmtest.androidapi.service.FcmGroupService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FcmMessageApiController {

    private final FcmGroupService fcmGroupService;

    static class CreateFcm

    @Data
    static class CreateFcmResponse {
        private Long id;

        public CreateFcmResponse(Long id) {
            this.id = id;
        }
    }


}
