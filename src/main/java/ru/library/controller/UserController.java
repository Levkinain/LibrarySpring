package ru.library.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.library.entity.User;
import ru.library.service.serviceimpl.UsersServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/*")
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);
    private  UsersServiceImpl userService;

    @Autowired
    public void setUserService(UsersServiceImpl userService){
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String index(){
        return  "index";
    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public String getAllUsers(Model model){
        model.addAttribute("allUsers",userService.getAll());
        return "listOfUsers";

    }

  /*  @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        return "login";
    }*/

    /*@GetMapping(value = "/user/{login}")
    public String getByLogin(@ModelAttribute("user") User user , Model model){
        model.addAttribute("user",userService.findUserByLogin(user));
        return "showUser";
    }*/

    /*@PostMapping(value = "/addUser")
    @ResponseBody
    public String addUser(@ModelAttribute("user") User user ){
        String messages;
        if(userService.insert(user)==true){
            messages = "The user successfully added";
        }else{
            messages = "The user the user is not added";
        }
        return messages;
    }*/

    /*@PostMapping(value = "/selectAll")
    @ResponseBody
    public String addUser(@ModelAttribute("user") User user ){
        String messages;
        if(userService.insert(user)==true){
            messages = "The user successfully added";
        }else{
            messages = "The user the user is not added";
        }
        return messages;
    }

*/

    @PostMapping("/delete/{login}")
    public String deleteByLogin(@PathVariable("login") String login) {
       User user = userService.findUserByLogin(login);
        if (user!=null){
            logger.info(" The user is successfully deleted");
            userService.delete(user);
        }else{
            logger.info(" The user cannot be deleted");
        }
        return "redirect:/users";
    }

}
