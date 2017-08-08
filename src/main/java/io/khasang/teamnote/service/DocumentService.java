package io.khasang.teamnote.service;

import io.khasang.teamnote.entity.Document;

import java.util.List;

public interface DocumentService {
    /**
     * Add document to DB
     *
     * @param document - document for creation
     * @return created document
     */
    Document addDocument(Document document);

    /**
     * Find document at database
     *
     * @param id = uniq id at db for specific document
     * @return document
     */
    Document getById(long id);

    /**
     * Delete role from DB
     *
     * @param id = uniq id role from DB
     * @return deleted role
     */
    Document delete(long id);

    /**
     * Receive all documents by specific type
     *
     * @return list from document
     */
    List<Document> getList();

    /**
     * Update specify document
     *
     * @param document = document for update
     * @return updated document
     */
    Document update(Document document);
}
