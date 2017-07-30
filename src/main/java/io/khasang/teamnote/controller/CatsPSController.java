package io.khasang.teamnote.controller;

import io.khasang.teamnote.db.dao.impl.ImplCatDao;
import io.khasang.teamnote.model.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * for implementation PreparedStatement
 * @author gothmog on 28.07.2017.
 */
@Controller
public class CatsPSController {

    @Autowired
    ImplCatDao implCatDao;
    /**
     * It displays a form to input data, here "command" is a reserved request attribute
     * which is used to display object data into form
     */
    @RequestMapping(value = "cat", method = RequestMethod.GET)
    public ModelAndView cat(){
        return new ModelAndView("catsps/cat", "command", new Cat());
    }


    @RequestMapping(value="/save",method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("cat") Cat cat){
        implCatDao.createCat(cat);
        return new ModelAndView("redirect:viewcat");
    }
    /**
     *  It provides list of cat in model object
     * @return
     */
    @RequestMapping("/viewcat")
    public ModelAndView viewCat(){
        List<Cat> list = implCatDao.getAllCats();
        return new ModelAndView("catsps/viewcat", "list", list);
    }

    /**
    * It displays object data into form for the given id.
    * The @PathVariable puts URL data into variable.
     */
    @RequestMapping(value="/editcat/{id}")
    public ModelAndView edit(@PathVariable int id){
        Cat cat= implCatDao.getCatById(id);
        return new ModelAndView("catsps/catedit","command",cat);
    }
    /**
     * It updates model object.
     * @param cat
     * @return
     */
    @RequestMapping(value = "/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("cat") Cat cat){
        implCatDao.updateCat(cat);
        return new ModelAndView("redirect:/viewcat");
    }

    /**
     * It deletes record for the given id in URL and redirects to /viewcat
     * @param id
     * @return
     */
    @RequestMapping(value="/deletecat/{id}",method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id){
        implCatDao.deleteCat(id);
        return new ModelAndView("redirect:/viewcat");
    }
}
