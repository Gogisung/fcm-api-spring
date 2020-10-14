package fcmtest.androidapi;

import fcmtest.androidapi.domain.FcmGroup;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FcmGroupRepositoryTest {

//    @Autowired FcmGroupRepository fcmGroupRepository;
//
//    @Test
//    @Transactional
//    @Rollback(value = false)
//    public void testFCM() throws Exception {
//        //given
//        FcmGroup fcmGroup = new FcmGroup();
//        fcmGroup.setGroupName("에이전트1");
//
//        //when
//        Long saveId = fcmGroupRepository.save(fcmGroup);
//        FcmGroup findFcmGroup = fcmGroupRepository.find(saveId);
//
//        //then
//        assertEquals(findFcmGroup.getId(), fcmGroup.getId());
//
//
//    }



}