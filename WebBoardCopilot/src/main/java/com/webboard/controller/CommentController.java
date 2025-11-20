package com.webboard.controller;

import com.webboard.entity.Comment;
import com.webboard.entity.User;
import com.webboard.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/comments")
public class CommentController {
    
    @Autowired
    private CommentService commentService;
    
    // 댓글 작성
    @PostMapping("/create")
    public String createComment(@RequestParam Integer postId,
                               @RequestParam String content,
                               HttpSession session,
                               RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            redirectAttributes.addFlashAttribute("error", "로그인이 필요합니다.");
            return "redirect:/auth/login";
        }
        
        try {
            Comment comment = Comment.builder()
                    .postId(postId)
                    .userId(user.getUserId())
                    .content(content)
                    .build();
            commentService.createComment(comment);
            redirectAttributes.addFlashAttribute("message", "댓글이 작성되었습니다.");
            return "redirect:/posts/" + postId;
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "댓글 작성 실패: " + e.getMessage());
            return "redirect:/posts/" + postId;
        }
    }
    
    // 댓글 수정
    @PostMapping("/{commentId}/edit")
    public String editComment(@PathVariable Integer commentId,
                             @RequestParam Integer postId,
                             @RequestParam String content,
                             HttpSession session,
                             RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/auth/login";
        }
        
        Comment comment = commentService.getCommentById(commentId);
        if (comment == null || !comment.getUserId().equals(user.getUserId())) {
            redirectAttributes.addFlashAttribute("error", "권한이 없습니다.");
            return "redirect:/posts/" + postId;
        }
        
        try {
            comment.setContent(content);
            commentService.updateComment(comment);
            redirectAttributes.addFlashAttribute("message", "댓글이 수정되었습니다.");
            return "redirect:/posts/" + postId;
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "댓글 수정 실패: " + e.getMessage());
            return "redirect:/posts/" + postId;
        }
    }
    
    // 댓글 삭제
    @GetMapping("/{commentId}/delete")
    public String deleteComment(@PathVariable Integer commentId,
                               @RequestParam Integer postId,
                               HttpSession session,
                               RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/auth/login";
        }
        
        Comment comment = commentService.getCommentById(commentId);
        if (comment == null || !comment.getUserId().equals(user.getUserId())) {
            redirectAttributes.addFlashAttribute("error", "권한이 없습니다.");
            return "redirect:/posts/" + postId;
        }
        
        try {
            commentService.deleteComment(commentId);
            redirectAttributes.addFlashAttribute("message", "댓글이 삭제되었습니다.");
            return "redirect:/posts/" + postId;
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "댓글 삭제 실패: " + e.getMessage());
            return "redirect:/posts/" + postId;
        }
    }
}
