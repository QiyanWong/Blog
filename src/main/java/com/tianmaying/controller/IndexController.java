package com.tianmaying.controller;

import com.tianmaying.model.Blog;
import com.tianmaying.model.User;
import com.tianmaying.service.BlogService;
import com.tianmaying.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {
    UserService user;
    BlogService blog;
    @GetMapping("/{username}")
    public List<Blog> getByPage(@PathVariable("username") String username,
                                @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        return getByPage(username,page,size);
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

}
