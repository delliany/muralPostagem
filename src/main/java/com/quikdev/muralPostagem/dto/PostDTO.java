package com.quikdev.muralPostagem.dto;

import java.util.ArrayList;
import java.util.List;

import com.quikdev.muralPostagem.model.Comment;
import com.quikdev.muralPostagem.model.User;

public class PostDTO {

	private Long id;
	private User user;
	private List<Comment> commentList = new ArrayList<>();
	private String title;
	private String description;
	private byte[] photo;
	private Long likes;
	private Long dislikes;
	
	public PostDTO(Long id, User user, List<Comment> commentList, String title, String description, byte[] photo,
			Long likes, Long dislikes, Long views) {
		super();
		this.id = id;
		this.user = user;
		this.commentList = commentList;
		this.title = title;
		this.description = description;
		this.photo = photo;
		this.likes = likes;
		this.dislikes = dislikes;
		this.views = views;
	}

	private Long views;
	
	public PostDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Long getLikes() {
		return likes;
	}

	public void setLikes(Long likes) {
		this.likes = likes;
	}

	public Long getDislikes() {
		return dislikes;
	}

	public void setDislikes(Long dislikes) {
		this.dislikes = dislikes;
	}

	public Long getViews() {
		return views;
	}

	public void setViews(Long views) {
		this.views = views;
	}

}
