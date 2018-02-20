package codechallenge;

/**
 * Created by terrell on 12/1/16.
 */
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    @Autowired
    BookDao dao;//will inject dao from xml file

    /*It displays a form to input data, here "command" is a reserved request attribute
     *which is used to display object data into form
     */
    @RequestMapping("/bookform")
    public ModelAndView showform(){
        return new ModelAndView("bookform","command",new Book());
    }
    /*It saves object into database. The @ModelAttribute puts request data
     *  into model object. You need to mention RequestMethod.POST method
     *  because default request is GET*/
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("book") Book book){
        dao.save(book);
        return new ModelAndView("redirect:/viewbook");//will redirect to viewbook request mapping
    }
    /* It provides list of books in model object */
    @RequestMapping("/viewbook")
    public ModelAndView viewbook(){
        List<Book> list=dao.getBooks();
        return new ModelAndView("viewbook","list",list);
    }
    /* It displays object data into form for the given id.
     * The @PathVariable puts URL data into variable.*/
    @RequestMapping(value="/editbook/{id}")
    public ModelAndView edit(@PathVariable int id){
        Book book=dao.getBookById(id);
        return new ModelAndView("bookeditform","command",book);
    }
    /* It updates model object. */
    @RequestMapping(value="/editsave",method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("book") Book book){
        dao.update(book);
        return new ModelAndView("redirect:/viewbook");
    }
    /* It deletes record for the given id in URL and redirects to /viewbook */
    @RequestMapping(value="/deletebook/{id}",method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id){
        dao.delete(id);
        return new ModelAndView("redirect:/viewbook");
    }

}