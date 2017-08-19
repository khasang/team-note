package io.khasang.teamnote.service;

import io.khasang.teamnote.entity.Message;

import java.util.List;

public interface MessageService {
    /**
     * Add message to DB
     *
     * @param message - message for creation
     * @return created message
     */
    Message addMessage(Message message);

    /**
     * Find message at database
     *
     * @param id = uniq id at db for specific message
     * @return message
     */
    Message getById(long id);

    /**
     * Delete document from DB
     *
     * @param id = uniq id message from DB
     * @return deleted message
     */
    Message delete(long id);

    /**
     * Receive all messages by specific type
     *
     * @return list from message
     */
    List<Message> getList();

    /**
     * Update specify message
     *
     * @param message = message for update
     * @return updated message
     */
    Message update(Message message);
}
