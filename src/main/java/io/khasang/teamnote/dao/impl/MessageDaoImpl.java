package io.khasang.teamnote.dao.impl;

import io.khasang.teamnote.dao.MessageDao;
import io.khasang.teamnote.entity.Message;

public class MessageDaoImpl extends BasicDaoImpl<Message> implements MessageDao {
    
    public MessageDaoImpl(Class<Message> entityClass) {
        super(entityClass);
    }
}
