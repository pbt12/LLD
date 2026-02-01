package Entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Post {
    private int voteCount;
    private String content;
    private List<Comment> comments;
    private User postedBy;
    List<User> observers;
    public Post(String content, User postedBy){
        this.content = content;
        this.postedBy = postedBy;
        comments = new ArrayList<>();
        voteCount = 0;
        this.observers = new ArrayList<>();
    }

    public void vote(VoteType voteType){
        voteCount = voteCount + voteType.getVoteValue();
    }

    public void addToObservers(User observerUserId){
        observers.add(observerUserId);
    }

    public void notifyObservers(){
        observers.forEach(observer -> observer.onPostEvent());
    }

    //getters and setters
    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(User postedBy) {
        this.postedBy = postedBy;
    }
}
