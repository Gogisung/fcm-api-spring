package fcmtest.androidapi.service;

import fcmtest.androidapi.domain.FcmGroup;
import fcmtest.androidapi.domain.FcmGroupMessage;
import fcmtest.androidapi.repository.FcmMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FcmMessageService {

    private final FcmMessageRepository fcmMessageRepository;

    @Transactional
    public Long join(FcmGroupMessage fcmGroupMessage) {
        fcmMessageRepository.save(fcmGroupMessage);
        return fcmGroupMessage.getId();
    }



}
