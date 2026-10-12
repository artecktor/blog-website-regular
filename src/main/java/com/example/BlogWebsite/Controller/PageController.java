package com.example.BlogWebsite.Controller;

import com.example.BlogWebsite.Service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.example.BlogWebsite.DTO.BlogSaveDTO;
import com.example.BlogWebsite.DTO.CommentSaveDTO;
import com.example.BlogWebsite.DTO.UserSaveDTO;
import com.example.BlogWebsite.Model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

@Controller
public class PageController {
    private final CommentService commentService;
    private final BlogService blogService;
    private final ApplicationUserService applicationUserService;
    private final PageViewCounterService pageViewCounterService;
    private final TagService tagService;
    private final CategoryService categoryService;


    public PageController(CommentService commentService, BlogService blogService, ApplicationUserService applicationUserService, PageViewCounterService pageViewCounterService, TagService tagService, CategoryService categoryService) {
        this.commentService = commentService;
        this.blogService = blogService;
        this.applicationUserService = applicationUserService;
        this.pageViewCounterService = pageViewCounterService;
        this.tagService = tagService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String home(Model model) {
        long views = pageViewCounterService.incrementAndGet();
        model.addAttribute("pageViews", views);
        return "home";
    }

    @GetMapping("/{name}")
    public String home2(@PathVariable String name, HttpSession httpSession) {
        httpSession.setAttribute("userId", 100L);
        httpSession.setAttribute("date", LocalDate.now());
        httpSession.setAttribute("name", name);
        return "home";
    }

    @GetMapping("/se")
    @ResponseBody
    public String se(HttpSession httpSession) {
        return (String)  httpSession.getAttribute("name");
    }

//    @GetMapping("/blog")
//    public String blog(int id, Model model) {
//        Blog blog = blogService.findById(id);
//
//        blogService.incrementViewCounter(id);
//
//        model.addAttribute("blog", blog);
//
//        return "blog";
//    }

    @GetMapping("/blog/{slug}")
    public String blog(@PathVariable String slug, Model model) {
        Blog blog = blogService.findBySlug(slug);
        model.addAttribute("blog", blog);
        return "blog";
    }


    @GetMapping("/search")
    public String categoryPage() {
        return "search";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/users")
    public String saveUser(UserSaveDTO userSaveDTO) {
        ApplicationUser user = userSaveDTO.convertToApplicationUser();
        user.setRole(Role.USER);
        applicationUserService.save(user);
        return "redirect:/";
    }

    @PostMapping("/blogs")
    public String saveBlog(BlogSaveDTO blogSaveDTO) {
        Blog blog = blogSaveDTO.convertToBlog();
        blogService.save(blog);
        return "redirect:/admin/blogs";
    }


//    @PostMapping("/login")
//    public String login(
//            String email,
//            String password,
//            RedirectAttributes redirectAttributes
//    ) {
//
//        ApplicationUser user =
//                applicationUserService.findByEmailAndPassword(email, password);
//
//        if (user == null) {
//
//            redirectAttributes.addFlashAttribute(
//                    "loginError",
//                    "ایمیل یا رمز عبور اشتباه است"
//            );
//
//            return "redirect:/login";
//        }
//
//        return "redirect:/";
//    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/admin/users")
    public String adminUsers() {
        return "adminUser";
    }

    @GetMapping("/admin/comments")
    public String adminComments() {
        return "adminComment";
    }

    @GetMapping("/admin/blogs")
    public String adminBlogs() {
        return "adminBlog";
    }

    @GetMapping("/admin/blog-edit")
    public String adminBlogEdit() {
        return "adminBlogEdit";
    }

    @GetMapping("/admin/tags")
    public String adminTags() {
        return "adminTaxonomy";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

//    @PostMapping("/comments/save")
//    public String saveFromForm(CommentSaveDTO dto) {
//        Comment comment = dto.convertToComment();
//
//        Blog blog = blogService.findById(dto.getBlogId());
//
//        ApplicationUser user =
//                applicationUserService.findByEmailAndPassword(
//                        dto.getEmail(),
//                        dto.getPassword()
//                );
//
//        comment.setBlog(blog);
//        comment.setUser(user);
//
//        commentService.save(comment);
//
//        return "redirect:/blog?id=" + blog.getId();
//    }

    @PostMapping("/comments/save")
    public String saveFromForm(CommentSaveDTO dto) {

        System.out.println("blogId: " + dto.getBlogId());
        System.out.println("email: " + dto.getEmail());
        System.out.println("password: " + dto.getPassword());

        Blog blog = blogService.findById(dto.getBlogId());

        ApplicationUser user =
                applicationUserService.findByEmailAndPassword(
                        dto.getEmail(),
                        dto.getPassword()
                );

        System.out.println("blog: " + blog);
        System.out.println("user: " + user);

        Comment comment = dto.convertToComment();

        comment.setBlog(blog);
        comment.setUser(user);

        commentService.save(comment);

        return "redirect:/blog?id=" + blog.getId();
    }
}
