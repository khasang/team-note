package io.khasang.teamnote.service.impl;

import io.khasang.teamnote.dao.MessageDao;
import io.khasang.teamnote.entity.Message;
import io.khasang.teamnote.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("messageService")
public class MessageServiceImpl implements MessageService{

    @Autowired
    protected MessageDao messageDao;


    @Override
    public Message addMessage(Message message) {
        return messageDao.create(message);
    }

    @Override
    public Message getById(long id) {
        return messageDao.getById(id);
    }

    @Override
    public Message delete(long id) {
        Message messageForDelete = messageDao.getById(id);
        return messageDao.delete(messageForDelete);
    }

    @Override
    public List<Message> getList() {
        return messageDao.getList();
    }

    @Override
    public Message update(Message message) {
        return messageDao.update(message);
    }
}
