package io.khasang.teamnote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import io.khasang.teamnote.model.FileBucket;
import io.khasang.teamnote.entity.Items;
import io.khasang.teamnote.service.ItemsService;
import io.khasang.teamnote.model.FileValidator;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * @author gothmog on 06.09.2017.
 */
@Controller
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    private ItemsService itemsService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private FileValidator fileValidator;

    @InitBinder("fileBucket")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(fileValidator);
    }

    @RequestMapping(value = {"/items"}, method = RequestMethod.GET)
    public String listItems(ModelMap modelMap){
        modelMap.addAttribute("hello", "FileUpload SpringMVC Hibernate");
        return "items";    }


    @RequestMapping(value = {"/upload"}, method = RequestMethod.GET)
    public String addItems(ModelMap modelMap){
        FileBucket fileBucket = new FileBucket();
        modelMap.addAttribute("fileBucket", fileBucket);

        List<Items> itemsList = itemsService.getList();
        modelMap.addAttribute("items", itemsList);
        return "itemslist";
    }

    @RequestMapping(value = {"/upload"}, method = RequestMethod.POST)
    public String uploadItems(@Valid FileBucket fileBucket, BindingResult result, ModelMap modelMap) throws IOException{
        if (result.hasErrors()){
            System.out.println("validation errors");
            List<Items> itemsList = itemsService.getList();
            modelMap.addAttribute("items", itemsList);
            return "itemslist";
        } else {
            System.out.println("Fetching file");
            saveItems(fileBucket);
            return "redirect:/items/upload";
        }
    }

    @RequestMapping(value = {"/download-items-{itemsId}"}, method = RequestMethod.GET)
    public String downloadItems(@PathVariable long itemsId, HttpServletResponse response) throws IOException{
        Items items = itemsService.getById(itemsId);
        response.setContentType(items.getType());
        response.setContentLength(items.getContentFile().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + items.getName() + "\"");

        FileCopyUtils.copy(items.getContentFile(), response.getOutputStream());
        return "redirect:/items/upload";
    }

    @RequestMapping(value = {"/delete-items-{itemsId}"}, method = RequestMethod.GET)
    public String deleteItems(@PathVariable long itemsId){
        itemsService.delete(itemsId);
        return "redirect:/items/upload";
    }

    private void saveItems(FileBucket fileBucket) throws IOException{
        Items itemsFile = new Items();
        MultipartFile multipartFile = fileBucket.getFile();
        itemsFile.setName(multipartFile.getOriginalFilename());
        itemsFile.setDescription(fileBucket.getDescription());
        itemsFile.setType(multipartFile.getContentType());
        itemsFile.setContentFile(multipartFile.getBytes());
        itemsService.addItems(itemsFile);
    }
}
