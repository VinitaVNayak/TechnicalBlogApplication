package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import technicalblog.model.User;
import technicalblog.services.PostService;
import technicalblog.services.UserService;

@Controller
public class UserController {

    @Autowired
    private PostService postservice;

    @Autowired
    private UserService userservice;

    @RequestMapping("users/login")
    public String login() {
        return "users/login";
    }

    @RequestMapping("users/registration")
    public String registration() {
        return "users/registration";
    }


    
    
    @RequestMapping(value= "users/login",method=RequestMethod.POST)
    public String loginUser(User user){
        if(userservice.login(user)) {
            return "redirect:/posts";
        }
        else
            return "users/login";

    }
    @RequestMapping(value= "users/logout",method=RequestMethod.POST)
    public String logout(Model model){

        model.addAttribute("posts",postservice.getAllPost());
        return "index";
    }

    @RequestMapping(value= "users/registration",method=RequestMethod.POST)
    public String registerUser(User user){
        return "users/login";

    }



}