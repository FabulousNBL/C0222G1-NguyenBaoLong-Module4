package blog.blog.controller;



import blog.blog.model.Blog;
import blog.blog.model.BlogDTO;
import blog.blog.model.Category;
import blog.blog.repository.IBlogDetailRepository;
import blog.blog.service.IBlogService;
import blog.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private IBlogDetailRepository blogDetailRepository;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/list-blog")
    private String showListBlog(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("title").ascending();
        Page<Blog> list = blogService.findAll(PageRequest.of(page, 2, sort));
        model.addAttribute("blogList", list);
        return "/index";
    }

    @GetMapping("/create")
    private String showFormCreate(Model model) {
        model.addAttribute("blogDTO", new BlogDTO());
        model.addAttribute("category",iCategoryService.findAllCategory());
        return "/create";
    }

    @PostMapping("/create")
    private String create(BlogDTO blogDTO) {
        blogDetailRepository.create(blogDTO.getContent());
        int id = blogDetailRepository.findAllBlogDetail().size();
        blogService.create(blogDTO.getTitle(), blogDTO.getCreateDay(),id,blogDTO.getId());
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
        model.addAttribute("category",iCategoryService.findAllCategory());
        return "/edit";
    }

    @PostMapping("/edit")
    private String update(BlogDTO blogDTO, Blog blog) {
        blogService.update(blogDTO.getTitle(), blogDTO.getCreateDay(),blog.getCategory().getId(), blog.getId());
        return "redirect:/list-blog";
    }

    @GetMapping("/search")

    private String search(String title, Model model){
        model.addAttribute("blogList", blogService.searchByTitle(title));
        return "/list";
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("categoryList", iCategoryService.findAllCategory());
        return "/menu";
    }

    @GetMapping("/create-category")
    public String createCategory(Model model){
        model.addAttribute("category", new Category());
        return "/create-category";
    }

    @PostMapping("/create-category")
    public String createCategory(Category category){
        iCategoryService.createCategory(category.getType());
        return "redirect:/";
    }

    @GetMapping("{id}/edit-category")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute("category", iCategoryService.findById(id));
        return "/edit-category";
    }

    @PostMapping("/edit-category")
    public String edit(Category category){
        iCategoryService.update(category.getType(),category.getId());
        return "redirect:/";
    }

    @GetMapping("{idCategory}/blog")
    public String blog(@PathVariable(value = "idCategory", required = false) Integer id, Model model){
        model.addAttribute("category", iCategoryService.findById(id));
        return "/list";
    }

    @GetMapping("{id}/delete-category")
    public String deleteCategory(@PathVariable("id") int id, Model model){
        model.addAttribute("category", iCategoryService.findById(id));
        return "/delete-category";
    }

    @PostMapping("/delete-category")
    public String removeCategory(Category category){
        iCategoryService.delete(category.getId());
        return "redirect:/";
    }
}
