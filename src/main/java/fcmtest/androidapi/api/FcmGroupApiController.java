package fcmtest.androidapi.api;

import fcmtest.androidapi.domain.FcmGroup;
import fcmtest.androidapi.service.FcmGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class FcmGroupApiController {

    private final FcmGroupService fcmGroupService;


    @PostMapping("/api/fcmGroup")
    public CreateFcmGroupResponse saveFcmGroupV1(@RequestBody @Valid FcmGroup fcmGroup) {
        Long id = fcmGroupService.join(fcmGroup);
        return new CreateFcmGroupResponse(id);
    }

    static class CreateFcmGroupResponse {
        private Long id;

        public CreateFcmGroupResponse(Long id) {
            this.id = id;
        }
    }

}
