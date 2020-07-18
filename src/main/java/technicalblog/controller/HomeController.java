package technicalblog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import technicalblog.model.Post;
import technicalblog.services.PostService;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class HomeController {
    @Autowired
    private PostService postservice;

    @RequestMapping("/")
    public String getAllPosts(Model model){

        model.addAttribute("posts",postservice.getAllPost());
        return "index";
    }
}
