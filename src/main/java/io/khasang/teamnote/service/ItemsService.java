package io.khasang.teamnote.service;

import io.khasang.teamnote.entity.Items;

import java.util.List;

/**
 * @author gothmog on 29.08.2017.
 */
public interface ItemsService {

    Items findById(long id);

    List<Items> findAll();

    List<Items> findAllByUserId(long id);

    Items saveItems(Items items);

    Items deleteById(long id);
}
