package Entities;


import java.util.UUID;

public class Answer extends Post{
    private String answerId;
    public Answer(User postedBy, String content){
        super(content, postedBy);
        answerId = UUID.randomUUID().toString();
    }

}
