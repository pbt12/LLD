package Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private String userName;
    private String userId;
//    private List<Question> questions;
//    private List<Answer> answers;


    User(String userName){
        this.userName = userName;
        this.userId = String.valueOf(UUID.randomUUID());`
        votes = new ArrayList<>();
        userReputation = new UserReputation();
    }



}
