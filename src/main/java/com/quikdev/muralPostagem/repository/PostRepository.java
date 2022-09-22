package com.quikdev.muralPostagem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quikdev.muralPostagem.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	@Query("SELECT post FROM Post post inner join post.user pe WHERE pe.id = :userId")
	List<Post> findAllByIdUser(@Param("userId") long userId);
//	
//	@Query("SELECT post.likes FROM Post post WHERE post.id = :postId")
//	Long findLikesByPost(@Param("postId") long postId);
//	
//	@Query("SELECT post.dislikes FROM Post post WHERE post.id = :postId")
//	Long findDislikesByPost(@Param("postId") long postId);
//	
//	@Query("SELECT post.views FROM Post post WHERE post.id = :postId")
//	Long findViewsByPost(@Param("postId") long postId);
	

}
