package Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Question extends Post{
    private String questionId;
    private List<Answer> answers;

    Question(String content, User postedBy){
        super(content, postedBy);
        questionId = String.valueOf(UUID.randomUUID());
        answers = new ArrayList<>();
    }

    public void addAnswer(Answer answer){
        answers.add(answer);
        super.
    }

}
