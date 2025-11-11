package com.webboard.controller;

import com.webboard.entity.Post;
import com.webboard.entity.User;
import com.webboard.service.PostService;
import com.webboard.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
    
    private static final int PAGE_SIZE = 10;
    
    @Autowired
    private PostService postService;
    
    @Autowired
    private CommentService commentService;
    
    // 게시글 목록 (홈)
    @GetMapping("")
    public String listPosts(@RequestParam(defaultValue = "1") int page, Model model) {
        List<Post> posts = postService.getAllPosts(page, PAGE_SIZE);
        int totalCount = postService.getPostCount();
        int totalPages = (totalCount + PAGE_SIZE - 1) / PAGE_SIZE;
        
        model.addAttribute("posts", posts);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "posts/list";
    }
    
    // 게시글 작성 페이지
    @GetMapping("/create")
    public String createPage(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/auth/login";
        }
        return "posts/create";
    }
    
    // 게시글 작성 처리
    @PostMapping("/create")
    public String createPost(@RequestParam String title,
                            @RequestParam String content,
                            HttpSession session,
                            RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/auth/login";
        }
        
        try {
            Post post = Post.builder()
                    .userId(user.getUserId())
                    .title(title)
                    .content(content)
                    .views(0)
                    .build();
            postService.createPost(post);
            redirectAttributes.addFlashAttribute("message", "게시글이 작성되었습니다.");
            return "redirect:/posts";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "게시글 작성 실패: " + e.getMessage());
            return "redirect:/posts/create";
        }
    }
    
    // 게시글 상세 조회
    @GetMapping("/{postId}")
    public String viewPost(@PathVariable Integer postId, Model model) {
        Post post = postService.getPostById(postId);
        if (post == null) {
            return "redirect:/posts";
        }
        
        model.addAttribute("post", post);
        model.addAttribute("comments", commentService.getCommentsByPostId(postId));
        return "posts/view";
    }
    
    // 게시글 수정 페이지
    @GetMapping("/{postId}/edit")
    public String editPage(@PathVariable Integer postId, 
                          HttpSession session,
                          Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/auth/login";
        }
        
        Post post = postService.getPostById(postId);
        if (post == null || !post.getUserId().equals(user.getUserId())) {
            return "redirect:/posts";
        }
        
        model.addAttribute("post", post);
        return "posts/edit";
    }
    
    // 게시글 수정 처리
    @PostMapping("/{postId}/edit")
    public String editPost(@PathVariable Integer postId,
                          @RequestParam String title,
                          @RequestParam String content,
                          HttpSession session,
                          RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/auth/login";
        }
        
        Post post = postService.getPostById(postId);
        if (post == null || !post.getUserId().equals(user.getUserId())) {
            return "redirect:/posts";
        }
        
        try {
            post.setTitle(title);
            post.setContent(content);
            postService.updatePost(post);
            redirectAttributes.addFlashAttribute("message", "게시글이 수정되었습니다.");
            return "redirect:/posts/" + postId;
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "게시글 수정 실패: " + e.getMessage());
            return "redirect:/posts/" + postId + "/edit";
        }
    }
    
    // 게시글 삭제
    @GetMapping("/{postId}/delete")
    public String deletePost(@PathVariable Integer postId,
                            HttpSession session,
                            RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/auth/login";
        }
        
        Post post = postService.getPostById(postId);
        if (post == null || !post.getUserId().equals(user.getUserId())) {
            return "redirect:/posts";
        }
        
        try {
            postService.deletePost(postId);
            redirectAttributes.addFlashAttribute("message", "게시글이 삭제되었습니다.");
            return "redirect:/posts";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "게시글 삭제 실패: " + e.getMessage());
            return "redirect:/posts/" + postId;
        }
    }
}
