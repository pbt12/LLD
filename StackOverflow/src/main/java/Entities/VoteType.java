package Entities;

public enum VoteType {
    UP_VOTE(1),
    DOWN_VOTE(-1);
    private final int voteValue;
    VoteType(int voteValue){
        this.voteValue = voteValue;
    }
    public int getVoteValue(){
        return voteValue;
    }
}
