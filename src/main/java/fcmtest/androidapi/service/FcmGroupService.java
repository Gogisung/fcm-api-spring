package fcmtest.androidapi.service;

import fcmtest.androidapi.domain.FcmGroup;
import fcmtest.androidapi.repository.FcmGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FcmGroupService {

    private final FcmGroupRepository fcmGroupRepository;

    /**
     * FCM 그룹 등록
     */
    @Transactional
    public Long join(FcmGroup fcmGroup) {
        fcmGroupRepository.save(fcmGroup);
        return fcmGroup.getId();
    }
    /**
     * FCM 조회
     */
    public List<FcmGroup> findFcmGroup() {
        return fcmGroupRepository.findAll();
    }

    public FcmGroup findOne(Long groupId) {
        return fcmGroupRepository.findOne(groupId);
    }

}
