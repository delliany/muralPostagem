package com.quikdev.muralPostagem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quikdev.muralPostagem.dto.PostDTO;
import com.quikdev.muralPostagem.model.Comment;
import com.quikdev.muralPostagem.model.Post;
import com.quikdev.muralPostagem.repository.CommentRepository;
import com.quikdev.muralPostagem.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CommentRepository commentRepository;

	public PostService() {
		super();
	}

	public PostDTO getPostById(Long postId) {
		List<Comment> commentList = new ArrayList<>();
		Post post = new Post();

		post = postRepository.findById(postId).get();
		commentList = commentRepository.findAllByIdPost(postId);
		post.setCommentList(commentList);
		post = setViewAtPost(post);

		return new PostDTO(post.getId(), UserService.userMuralPostagem, commentList, post.getTitle(),
				post.getDescription(), post.getPhoto(), post.getLikes(), post.getDislikes(), post.getViews());
	}

	public List<PostDTO> getAllPost() {
		List<PostDTO> postDTOList = new ArrayList<>();
		List<Post> postList = postRepository.findAll();

		postList.forEach(item -> {
			List<Comment> commentList = new ArrayList<>();
			commentList = commentRepository.findAllByIdPost(item.getId());

			PostDTO dto = new PostDTO(item.getId(), UserService.userMuralPostagem, commentList, item.getTitle(),
					item.getDescription(), item.getPhoto(), item.getLikes(), item.getDislikes(), item.getViews());

			postDTOList.add(dto);
		});

		return postDTOList;
	}

	public List<PostDTO> getAllPostByUser(Long userId) {
		List<PostDTO> postDTOList = new ArrayList<>();
		List<Post> postList = postRepository.findAllByIdUser(userId);

		postList.forEach(item -> {
			PostDTO dto = new PostDTO(item.getId(), item.getUser(), item.getCommentList(), item.getTitle(),
					item.getDescription(), item.getPhoto(), item.getLikes(), item.getDislikes(), item.getViews());

			postDTOList.add(dto);
		});

		return postDTOList;
	}

	public void addPost(Post post) {
		postRepository.saveAndFlush(post);
	}

	public void editPost(Post post) {
		postRepository.saveAndFlush(post);
	}

	public void deletePost(Long postId) {
		postRepository.deleteById(postId);
	}

	public Post setLikeAtPost(Post post) {
		Long totalLikes = post.getLikes() + 1;
		post.setLikes(totalLikes);

		return postRepository.saveAndFlush(post);
	}

	public Post setDislikeAtPost(Post post) {
		Long totalDislikes = post.getDislikes() + 1;
		post.setDislikes(totalDislikes);

		return postRepository.saveAndFlush(post);
	}

	public Post setViewAtPost(Post post) {
		Long totalViews = post.getViews() + 1;
		post.setViews(totalViews);

		return postRepository.saveAndFlush(post);
	}
}
