package com.gupta.littlelouder.services;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.gupta.littlelouder.services.bean.Comment;
import com.gupta.littlelouder.services.json.CommentJSON;
import com.gupta.littlelouder.services.model.CommentData;

@Path("comment")
public class CommentService {

	@POST
	@Path("new")
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	public Response newComment(
			@QueryParam("userid") String uid,
			@QueryParam("postid") String pid,
			@QueryParam("message") String message) {
		
		int userId = Integer.parseInt(uid);
		int postId = Integer.parseInt(pid);
		
		String send = "";
		
		Comment cmt = new Comment(message, userId, postId);
		
		new CommentData().addComment(cmt);
		
		ArrayList<Comment> comment = new CommentData().allComment(postId);
		
		send = new CommentJSON().constructJSON(comment);
		
		return Response.ok(send).header("Access-Control-Allow-Origin", "*").build();
	}
	
	@POST
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	public Response allComment(@QueryParam("postid") String pid) {
		
		int postId = Integer.parseInt(pid);
		
		String send = "";
		
		ArrayList<Comment> comment = new CommentData().allComment(postId);
		
		send = new CommentJSON().constructJSON(comment);
		
		return Response.ok(send).header("Access-Control-Allow-Origin", "*").build();
	}
	
}
