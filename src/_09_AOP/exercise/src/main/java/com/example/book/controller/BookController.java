package com.example.book.controller;

import com.example.book.model.Book;
import com.example.book.model.Detail;
import com.example.book.service.book.IBookService;
import com.example.book.service.detail.IDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    @Autowired
    private IBookService iBookService;

    @Autowired
    private IDetailService detailService;

    @GetMapping
    public String home(@PageableDefault (value = 2) Pageable pageable, Model model){
        model.addAttribute("bookList",iBookService.findAll(pageable));
        return "/send-back";
    }

    @GetMapping("/borrow/{id}")
    public String borrow(@PathVariable("id") int id, Model model){
        model.addAttribute("book", iBookService.findById(id));
        return "/borrow";
    }

    @PostMapping("/borrow")
    public String borrow(Book book){
        Book borrowBook = iBookService.findById(book.getId());
        borrowBook.setAmount(borrowBook.getAmount()-1);
        iBookService.save(borrowBook);
        String codeDetail = String.format("%5s", (int)((Math.random()*99999))).replaceAll(" ", "0");
        Detail detailBorrow = new Detail(codeDetail,borrowBook);
        detailService.save(detailBorrow);
        return "redirect:/";
    }

    @GetMapping("/detail")
    public String detail(@PageableDefault (value = 2) Pageable pageable, Model model){
        model.addAttribute("detailList",detailService.findAll(pageable));
        return "/detail";
    }

    @GetMapping("/return")
    public String giveBack(String id){
        Detail detail=detailService.findById(id);
        Book bookBorrow = iBookService.findById(detail.getBook().getId());
        bookBorrow.setAmount(bookBorrow.getAmount()+1);
        iBookService.save(bookBorrow);
        detailService.delete(detail);
        return "redirect:/";
    }

    @ExceptionHandler(Exception.class)
    public String handeleException(){
        return "/error";
    }

}
