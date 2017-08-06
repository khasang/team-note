package io.khasang.teamnote.service.impl;

import io.khasang.teamnote.dao.DocumentDao;
import io.khasang.teamnote.entity.Document;
import io.khasang.teamnote.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("documentService")
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentDao documentDao;

    @Override
    public Document addDocument(Document document) {
        return documentDao.create(document);
    }
}
