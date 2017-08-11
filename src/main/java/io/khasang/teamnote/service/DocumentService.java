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
     * Find ebtity at database
     * @param id = uniq id  at db for specific document
     * @return document
     */
    Document getById(long id);

    /**
     * Delete document from db
     * @param id = uniq id from db
     * @return deleted document
     */
    Document delete(long id);

    /**
     * Receive all entities by spicific type
     *
     * @return list from document
     */
    List<Document> getList();

    /**
     * Update specify document
     * @param document = document for update
     * @return updated document
     */
    Document update(Document document);
}
