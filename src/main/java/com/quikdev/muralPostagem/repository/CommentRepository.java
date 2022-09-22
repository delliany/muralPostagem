package com.quikdev.muralPostagem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quikdev.muralPostagem.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	@Query("SELECT comm FROM Comment comm inner join comm.post cp WHERE cp.id = :postId")
	List<Comment> findAllByIdPost(@Param("postId") long postId);

}
