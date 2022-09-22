package com.quikdev.muralPostagem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quikdev.muralPostagem.model.Comment;
import com.quikdev.muralPostagem.model.DeleteType;
import com.quikdev.muralPostagem.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	public CommentService() {
		super();
	}

	public void addCommentAtPost(Comment comment) {
		commentRepository.saveAndFlush(comment);
	}
	
	public void editCommentAtPost(Comment comment) {
		commentRepository.saveAndFlush(comment);
	}
	
	public Comment deleteCommentAtPost(Comment comment) {
		if (comment.getPost().getUser().getId() == comment.getUser().getId()) {
			comment.setDeleteType(DeleteType.OWNER);
			comment.setLabelDeleteType(DeleteType.OWNER.label);
		}else {
			comment.setDeleteType(DeleteType.USER);
			comment.setLabelDeleteType(DeleteType.USER.label);
		}
		
		return commentRepository.saveAndFlush(comment);
	}
}
