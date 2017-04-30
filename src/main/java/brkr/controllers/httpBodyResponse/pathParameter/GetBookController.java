package brkr.controllers.httpBodyResponse.pathParameter;

import brkr.model.Book;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetBookController {

    @RequestMapping(value = "/books/{title}", method = RequestMethod.GET)
    @ResponseBody
    public String getBookByTitle(@PathVariable("title") String title) {
        return "The requested book's title: " + title;
    }

    @RequestMapping(value = "/books/xml/{author}/{title}", method = RequestMethod.GET, produces = "application/xml")
    @ResponseBody
    public Book getBookByArtistAndTitle(
            @PathVariable("author") String author,
            @PathVariable("title") String title) {
        return new Book(author, title);
    }

    @RequestMapping(value = "/books/json/{author}/{title}/{chapter}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Book getBookByArtistAndTitleAndChapter(
            @PathVariable("author") String author,
            @PathVariable("title") String title,
            @PathVariable("chapter") int chapter) {
        return new Book(author, title, chapter);
    }

}
