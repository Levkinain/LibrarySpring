package ru.library.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.library.service.serviceimpl.LibraryServiceImpl;

@Controller
@RequestMapping("/*")
public class LibraryController {

    private static final Logger logger = Logger.getLogger(UserController.class);
    private LibraryServiceImpl libraryService;
    @Autowired
    public void setLibraryService(LibraryServiceImpl libraryService){
        this.libraryService = libraryService;
    }

@RequestMapping(value = "/library", method = RequestMethod.GET)
    public String getAll(Model model){
        model.addAttribute("library",libraryService.getAll());
        return "library";
}
}
