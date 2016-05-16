package com.gupta.littlelouder.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.gupta.littlelouder.services.bean.Post;
import com.gupta.littlelouder.services.json.PostJSON;
import com.gupta.littlelouder.services.json.VoteJSON;
import com.gupta.littlelouder.services.model.PostData;


@Path("post")
public class PostService {
	
	@POST
	@Path("new")
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	public Response newPost(
			@QueryParam("userid") String uid,
			@QueryParam("status") String status) {
		
		int userId = Integer.parseInt(uid);
		String send = "";
		boolean like = false;
		Post post = new Post(status, userId);
		
		new PostData().addPost(post);
		
		post = new PostData().latestPost();
		like = new PostData().checkVote(post.getPostId(), userId);
		
		if(post.getStatus().equals(status) && post.getUserId() == userId) {
			send = new PostJSON().constructJSON(post, true, like);		
		}
		else {
			send = new PostJSON().constructJSON(post, false, like);		
		}

		return Response.ok(send).header("Access-Control-Allow-Origin", "*").build();
		
	}

	@POST
	@Path("latest")
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	public Response latestPost(@QueryParam("userid") String uid) {
		
		int userId = Integer.parseInt(uid);
		String send = "";
		boolean like = false;
		
		Post post = new PostData().latestPost();
		like = new PostData().checkVote(post.getPostId(), userId);

		send = new PostJSON().constructJSON(post, true, like);	
		
		return Response.ok(send).header("Access-Control-Allow-Origin", "*").build();
		
	}

	@POST
	@Path("like")
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	public Response like(
			@QueryParam("userid") String uid,
			@QueryParam("postid") String pid) {
		
		int userId = Integer.parseInt(uid);
		int postId = Integer.parseInt(pid);
		String send = "";
		int upVote = 0;
		
		upVote = new PostData().like(postId, userId);
		
		if(upVote == 0) {
			send = new VoteJSON().constructJSON(upVote, false, false);
		}
		else {
			send = new VoteJSON().constructJSON(upVote, true, true);			
		}

		return Response.ok(send).header("Access-Control-Allow-Origin", "*").build();
		
	}

	@POST
	@Path("dislike")
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	public Response disLike(
			@QueryParam("userid") String uid,
			@QueryParam("postid") String pid) {
		
		int userId = Integer.parseInt(uid);
		int postId = Integer.parseInt(pid);
		String send = "";
		int upVote = 0;
		
		upVote = new PostData().disLike(postId, userId);
		
		if(upVote == 0) {
			send = new VoteJSON().constructJSON(upVote, true, false);
		}
		else {
			send = new VoteJSON().constructJSON(upVote, false, true);			
		}

		return Response.ok(send).header("Access-Control-Allow-Origin", "*").build();
		
	}

}
