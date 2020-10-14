package fcmtest.androidapi.service;

import fcmtest.androidapi.domain.FcmGroup;
import fcmtest.androidapi.repository.FcmGroupRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class FcmGroupServiceTest {

    @Autowired
    FcmGroupService fcmGroupService;

    @Autowired
    FcmGroupRepository fcmGroupRepository;

    @Test
    public void AddGroup() throws Exception {
        //givne
        FcmGroup fcmGroup = new FcmGroup();
        fcmGroup.setGroupName("에이전트11");

        //when
        Long joinId = fcmGroupService.join(fcmGroup);


        //then

        assertEquals(fcmGroup, fcmGroupRepository.findOne(joinId));
    }
}