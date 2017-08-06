package io.khasang.teamnote.service;

import io.khasang.teamnote.entity.Document;

public interface DocumentService {
    /**
     * Add document to DB
     *
     * @param document - document for creation
     * @return created document
     */
    Document addDocument(Document document);
}
