package io.khasang.teamnote.dao.impl;

import io.khasang.teamnote.dao.ItemsDao;
import io.khasang.teamnote.entity.Items;
import io.khasang.teamnote.entity.User;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * @author gothmog on 29.08.2017.
 */
public class ItemsDaoImpl extends BasicDaoImpl<Items> implements ItemsDao{

    @PersistenceContext
    private EntityManager entityManager;

    public ItemsDaoImpl(Class<Items> entityClass) {
        super(entityClass);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Items> findAllByUserId(long userId) {
        User user = new User();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Items> criteriaQuery = builder.createQuery(Items.class);
        Root<Items> itemsRoot = criteriaQuery.from(Items.class);
        itemsRoot.fetch("user", JoinType.LEFT);
        itemsRoot.fetch("user_id", JoinType.LEFT);
        criteriaQuery.select(itemsRoot).distinct(true);

        Predicate criteria = builder.conjunction();
        if (userId != 0){
            Predicate predicate = builder.equal(itemsRoot.get("user_id"),userId);
            criteria = builder.and(criteria,predicate);
        }
        criteriaQuery.where(criteria);
        List<Items> result = entityManager.createQuery(criteriaQuery).getResultList();
        return result;
    }
}
