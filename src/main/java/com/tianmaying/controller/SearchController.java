package com.tianmaying.controller;

import com.tianmaying.model.Blog;
import com.tianmaying.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {
    BlogService blog;
    @GetMapping("/search")
    public List<Blog> search(@RequestParam("key") String key, Model model) {
        List<Blog> list = blog.findBlogsByKey(key);
        model.addAttribute("Blog List",list);
        return list;
    }
}
