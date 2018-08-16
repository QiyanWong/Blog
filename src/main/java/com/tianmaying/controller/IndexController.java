package com.tianmaying.controller;

import com.tianmaying.model.Blog;
import com.tianmaying.model.User;
import com.tianmaying.service.BlogService;
import com.tianmaying.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class IndexController {
  @Autowired
  private UserService userService;

  @Autowired
  private BlogService blogService;
    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/{username:[a-z0-9_]+}")
    @ResponseBody
    public List<Blog> userProfile(@PathVariable String username) {
      User user =  userService.findByName(username);
      return blogService.findBlogs(user);

    }
}
