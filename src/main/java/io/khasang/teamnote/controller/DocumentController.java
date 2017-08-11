package io.khasang.teamnote.controller;

import io.khasang.teamnote.entity.Document;
import io.khasang.teamnote.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/document")
public class DocumentController {
    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @RequestMapping(
            value = "/add",
            method = RequestMethod.PUT,
            produces = "application/json; charset=utf-8")
    @ResponseBody
    public Document addDocument(@RequestBody Document document){
        return documentService.addDocument(document);
    }

    @RequestMapping(
            value = "/all",
            method = RequestMethod.GET)
    @ResponseBody
    public List<Document> getDocuments(){
        return documentService.getList();
    }

    @RequestMapping(
            value = "/get/{id}",
            method = RequestMethod.GET)
    @ResponseBody
    public Document getById(@PathVariable(value = "id") String inputId){
        return documentService.getById(Long.parseLong(inputId));
    }

    @RequestMapping(
            value = "/update",
            method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseBody
    public Document update(@RequestBody Document document){
        return documentService.update(document);
    }

    @RequestMapping(
            value = "/delete/{id}",
            method = RequestMethod.DELETE)
    @ResponseBody
    public Document delete(@PathVariable(value = "id") String inputId){
        return documentService.delete(Long.parseLong(inputId));
    }

}
