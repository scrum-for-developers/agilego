package de.codecentric.psd.worblehat.web.controller;

import de.codecentric.psd.worblehat.domain.Book;
import de.codecentric.psd.worblehat.domain.BookService;
import de.codecentric.psd.worblehat.web.formdata.BookDataFormData;
import de.codecentric.psd.worblehat.web.formdata.UserBookListData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller class for the book table result.
 */
@Controller
@RequestMapping("/userBookList")
public class UserBookListController {

	private BookService bookService;

	@Autowired
	public UserBookListController(BookService bookService) {
		this.bookService = bookService;
	}

    @RequestMapping(method = RequestMethod.GET)
    public String setupForm(ModelMap modelMap) {
        modelMap.addAttribute("books", new ArrayList<>());
        modelMap.addAttribute("userBookListData", new UserBookListData(""));
        modelMap.addAttribute("email", "");
        return "userBookList";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String showBooks(@ModelAttribute("email") @Valid UserBookListData userBookListData,
                                ModelMap modelMap) {
        final List<Book> books = bookService.findBookByBorrowerSortedByDate(userBookListData.getEmail());
        modelMap.addAttribute("books", books);

        return "userBookList";
    }

}
