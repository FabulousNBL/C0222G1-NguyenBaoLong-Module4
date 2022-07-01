package com.example.blogajax.controller;

import com.example.blogajax.model.Blog;
import com.example.blogajax.model.BlogDTO;
import com.example.blogajax.model.BlogDetail;
import com.example.blogajax.model.Category;
import com.example.blogajax.service.IBlogDetailService;
import com.example.blogajax.service.IBlogService;
import com.example.blogajax.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private IBlogDetailService blogDetailRepository;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/list-blog")
    private String showListBlog(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("title").ascending();
        Page<Blog> list = iBlogService.findAll(PageRequest.of(page, 2, sort));
        model.addAttribute("blogList", list);
        return "/blog/blog";
    }

    @GetMapping("/create")
    private String showFormCreate(Model model) {
        model.addAttribute("blogDTO", new BlogDTO());
        model.addAttribute("category", iCategoryService.findAllCategory());
        return "/create";
    }

    @PostMapping("/create")
    private ResponseEntity<?> create(@RequestBody BlogDTO blogDTO) {
        blogDetailRepository.create(blogDTO.getContent());
        int id = blogDetailRepository.findAllBlogDetail().size();
        iBlogService.create(blogDTO.getTitle(), blogDTO.getCreateDay(), id, blogDTO.getCategory());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}/delete")
    private String showDelete(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    private String delete(Blog blog) {
        iBlogService.delete(blog.getId());
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    private String showUpdate(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        model.addAttribute("category", iCategoryService.findAllCategory());
        return "/edit";
    }

    @PostMapping("/edit")
    private ResponseEntity<?> update(@RequestBody BlogDTO blogDTO, Blog blog) {

        iBlogService.update(blogDTO.getTitle(), blogDTO.getCreateDay(), blog.getCategory().getId(), blog.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")

    private String search(@RequestParam(name = "page", defaultValue = "0") int page, String title, Model model) {
        model.addAttribute("blogList", iBlogService.searchByTitle(title, PageRequest.of(page, 2)));
        return "/blog/blog";
    }

    @GetMapping("/")
    public ResponseEntity<List<Category>> home(Model model) {
        List<Category> list = iCategoryService.findAllCategory();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/create-category")
    public String createCategory(Model model) {
        model.addAttribute("category", new Category());
        return "/create-category";
    }

    @PostMapping("/create-category")
    public String createCategory(Category category) {
        iCategoryService.createCategory(category.getType());
        return "redirect:/";
    }

    @GetMapping("{id}/edit-category")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("category", iCategoryService.findById(id));
        return "/edit-category";
    }

    @PostMapping("/edit-category")
    public String edit(Category category) {
        iCategoryService.update(category.getType(), category.getId());
        return "redirect:/";
    }

    @GetMapping("{idCategory}/blog")
    public ResponseEntity<Page<Blog>> blog(@RequestParam(name = "page", defaultValue = "0") int page, @PathVariable("idCategory") int id, Model model) {
        model.addAttribute("category", iCategoryService.findById(id));


        Sort sort = Sort.by("title").ascending();
        Page<Blog> list = iBlogService.list(id, PageRequest.of(page, 2, sort));
        model.addAttribute("blogList", list);
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @GetMapping("{id}/delete-category")
    public String deleteCategory(@PathVariable("id") int id, Model model) {
        model.addAttribute("category", iCategoryService.findById(id));
        return "/delete-category";
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<BlogDetail> detail(@PathVariable("id") int id) {
        BlogDetail detail = blogDetailRepository.findBlogDetailById(id);
        if (detail == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(detail, HttpStatus.OK);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable("id") int id,
                                  @RequestBody Blog blog) {

        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setId(id);
        iBlogService.update(blog);


//        blogService.update(blog.getTitle(),blog.getCreateDay(),blog.getCategory().getId(),blog.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
