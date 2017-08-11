package io.khasang.teamnote.service.impl;

import io.khasang.teamnote.dao.DocumentDao;
import io.khasang.teamnote.entity.Document;
import io.khasang.teamnote.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service("documentService")
public class DocumentServiceImpl implements DocumentService{
    @Autowired
    private DocumentDao documentDao;

    @Override
    public Document addDocument(Document document) {
        return documentDao.create(document);
    }

    @Override
    public Document getById(long id) {
        return documentDao.getById(id);
    }

    @Override
    public Document delete(long id) {
        Document documentFordelete = documentDao.getById(id);
        return documentDao.delete(documentFordelete);
    }

    @Override
    public List<Document> getList() {
        return documentDao.getList();
    }

    @Override
    public Document update(Document document) {
        return documentDao.update(document);
    }
}
