package de.codecentric.psd.worblehat.web.controller;

import de.codecentric.psd.worblehat.domain.BookService;
import de.codecentric.psd.worblehat.web.formdata.ReturnAllBooksFormData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import de.codecentric.psd.worblehat.web.formdata.ReturnSingleBookFormData;
/**
 * Controller class for the
 */
@Controller
@RequestMapping("/returnSingleBook")
public class ReturnSingleBookController {

	private BookService bookService;

	@Autowired
	public ReturnSingleBookController(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public void prepareView(ModelMap modelMap) {
		modelMap.put("returnSingleBookFormData", new ReturnSingleBookFormData());
	}

	@RequestMapping(method = RequestMethod.POST)
	public String returnAllBooks(
			@ModelAttribute("returnSingleBookFormData") @Valid ReturnSingleBookFormData formData,
			BindingResult result) {
		if (result.hasErrors()) {
			return "returnSingleBook";
		} else {
			bookService.returnSingleBook(formData.getBook());
			return "userBookList";
		}
	}

}
