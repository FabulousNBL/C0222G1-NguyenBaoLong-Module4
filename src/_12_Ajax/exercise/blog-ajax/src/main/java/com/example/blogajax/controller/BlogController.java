package com.example.blogajax.controller;

import com.example.blogajax.model.Blog;
import com.example.blogajax.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping
    public ResponseEntity<Page<Blog>> getAll(Pageable pageable) {
        return new ResponseEntity<>(iBlogService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<List<Blog>> findByName(@PathVariable("title") String title, Pageable pageable) {
        List<Blog> blogs = iBlogService.searchByTitle(title, pageable);

        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }


    @GetMapping("/loadMore/{size}")
    private ResponseEntity<?> showListBlog(@RequestParam(name = "page", defaultValue = "0") int page, @PathVariable("size") int size) {
        Sort sort = Sort.by("title").ascending();
        Page<Blog> list = iBlogService.findAll(PageRequest.of(page, size, sort));
        return new ResponseEntity<>(list.getContent(), HttpStatus.OK);
    }

}
