package Entities;

public interface Votable {
//    private List<Vote> votes;
//    private int upVoteCnt;
//    private int downVoteCnt;
    void vote(User user, VoteType voteType);
}
