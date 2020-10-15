package fcmtest.androidapi.repository;

import fcmtest.androidapi.domain.FcmGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class FcmGroupRepository {

    private final EntityManager em;

    public void save(FcmGroup fcmGroup) {
        em.persist(fcmGroup);
    }

    public FcmGroup findOne(Long id) {
        return em.find(FcmGroup.class, id);
    }

    public List<FcmGroup> findAll() {
        return em.createQuery("select f from FcmGroup f", FcmGroup.class).getResultList();
//        QFcmGroup fcmGroup = QFcmGroup.fcmGroup;
//
//        JPAQueryFactory query = new JPAQueryFactory(em);
//        return query
//                .select(fcmGroup)
//                .from(fcmGroup);


    }

}
