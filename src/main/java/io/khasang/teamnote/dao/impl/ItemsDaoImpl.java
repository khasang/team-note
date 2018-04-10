package io.khasang.teamnote.dao.impl;

import io.khasang.teamnote.dao.ItemsDao;
import io.khasang.teamnote.entity.Items;

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


    @Override
    public List<Items> findAllByItemsId(long itemsId) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Items> criteriaQuery = builder.createQuery(Items.class);
        Root<Items> itemsRoot = criteriaQuery.from(Items.class);
        itemsRoot.fetch("items", JoinType.LEFT);
        itemsRoot.fetch("items_id", JoinType.LEFT);
        criteriaQuery.select(itemsRoot).distinct(true);

        Predicate criteriaPredicate = builder.conjunction();
        if (itemsId !=0){
            Predicate predicate = builder.equal(itemsRoot.get("items_id"),itemsId);
            criteriaPredicate = builder.and(criteriaPredicate, predicate);
        }
        criteriaQuery.where(criteriaPredicate);
        List<Items> result = entityManager.createQuery(criteriaQuery).getResultList();
        return result;
    }
}
