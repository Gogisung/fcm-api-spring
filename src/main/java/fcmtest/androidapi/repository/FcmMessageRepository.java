package fcmtest.androidapi.repository;


import fcmtest.androidapi.domain.FcmGroupMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
@Transactional
public class FcmMessageRepository {

    private final EntityManager em;

    public void save(FcmGroupMessage fcmGroupMessage) {
        em.persist(fcmGroupMessage);
    }

}
