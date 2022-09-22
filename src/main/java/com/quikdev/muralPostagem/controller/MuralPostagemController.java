package com.quikdev.muralPostagem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quikdev.muralPostagem.dto.PostDTO;
import com.quikdev.muralPostagem.model.Comment;
import com.quikdev.muralPostagem.model.Post;
import com.quikdev.muralPostagem.model.User;
import com.quikdev.muralPostagem.service.CommentService;
import com.quikdev.muralPostagem.service.PostService;
import com.quikdev.muralPostagem.service.UserService;

@RestController
@RequestMapping("/mural-postagem")
public class MuralPostagemController {

	@Autowired
	private PostService postService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private UserService userService;

	@PostMapping("/logar-usuario")
	public User loginUser(@RequestBody User user) {
		return userService.login(user);
	}

	@PutMapping("/editar-usuario")
	public User editUser(@RequestBody User user) {
		return userService.editUser(user);
	}

	@GetMapping("/listar-todos-posts")
	public List<PostDTO> getAllPost() {
		return postService.getAllPost();
	}

	@GetMapping("/listar-posts-usuario/{userId}")
	public List<PostDTO> getAllPostByUser(@PathVariable Long userId) {
		return postService.getAllPostByUser(userId);
	}
	
	@GetMapping("/post/{postId}")
	public PostDTO getPostById(@PathVariable Long postId) {
		return postService.getPostById(postId);
	}

	@PostMapping("/novo-post")
	public void addPost(@RequestBody Post post) {
		postService.addPost(post);
	}

	@PutMapping("/editar-post")
	public void editPost(@RequestBody Post post) {
		postService.editPost(post);
	}

	@DeleteMapping("/deletar-post/{postId}")
	public void deletePost(@PathVariable Long postId) {
		postService.deletePost(postId);
	}

	@PostMapping("/novo-comentario")
	public void addComment(@RequestBody Comment comment) {
		commentService.addCommentAtPost(comment);
	}

	@PutMapping("/deletar-comentario")
	public Comment deleteComment(@RequestBody Comment comment) {
		return commentService.deleteCommentAtPost(comment);
	}
	
	@PutMapping("/curtir-post")
	public Post setLikeAtPost(@RequestBody Post post) {
		return postService.setLikeAtPost(post);
	}
	
	@PutMapping("/descurtir-post")
	public Post setDislikeAtPost(@RequestBody Post post) {
		return postService.setDislikeAtPost(post);
	}
	
}
