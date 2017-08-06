package io.khasang.teamnote.dao.impi;

import io.khasang.teamnote.dao.DocumentDao;
import io.khasang.teamnote.entity.Document;

//@Repository("documentDao")
public class DocumentDaoImpl extends BasicDaoImpl<Document> implements DocumentDao{

    public DocumentDaoImpl(Class<Document> entityClass) {
        super(entityClass);
    }
}
