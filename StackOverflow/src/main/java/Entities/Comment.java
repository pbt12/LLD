package Entities;

import java.util.UUID;

public class Comment {
    private String content;
    private String commentId;
    private String postedBy;
    private int voteCount;

    public Comment(String content, String postedBy){
        this.content = content;
        this.postedBy = postedBy;
        voteCount = 0;
        this.commentId = UUID.randomUUID().toString();
    }

    public void vote(VoteType voteType){
        voteCount += voteType.getVoteValue();
    }

}
