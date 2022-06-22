package blog.controller;


import blog.model.Blog;
import blog.model.BlogDTO;

import blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/")
    private String showListBlog(Model model) {
        model.addAttribute("blogList", blogService.findAll());
        return "/index";
    }

    @GetMapping("/create")
    private String showFormCreate(Model model) {
        model.addAttribute("blogDTO", new BlogDTO());
        return "/create";
    }

    @PostMapping("/create")
    private String create(BlogDTO blogDTO) {
        blogService.create(blogDTO.getContent());
        int id = blogService.findAllBlogDetail().size();
        blogService.create(blogDTO.getTitle(), blogDTO.getCreateDay(),id);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    private String showDelete(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    private String delete(Blog blog) {
        blogService.delete(blog.getId());
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    private String showUpdate(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    private String update(BlogDTO blogDTO, Blog blog) {
        blogService.update(blogDTO.getTitle(), blogDTO.getContent(), blogDTO.getCreateDay(), blog.getId());
        return "redirect:/";
    }
}
