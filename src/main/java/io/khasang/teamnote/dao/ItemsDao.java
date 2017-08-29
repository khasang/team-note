package io.khasang.teamnote.dao;

import io.khasang.teamnote.entity.Items;

import java.util.List;

/**
 * @author gothmog on 29.08.2017.
 */
public interface ItemsDao extends BasicDao<Items>{
    List<Items> findAllByUserId(long userId);
}
