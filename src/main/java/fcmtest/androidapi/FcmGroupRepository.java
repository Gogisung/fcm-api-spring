package fcmtest.androidapi;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class FcmGroupRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(FcmGroup fcmGroup) {
        em.persist(fcmGroup);
        return fcmGroup.getId();
    }

    public FcmGroup find(Long id){
        return em.find(FcmGroup.class, id);
    }

}
