package com.ashin.model;


import com.example.demo.DAO.CommentDAO;

import java.util.ArrayList;
import java.util.Date;

public class Topic {
    private int idTopic;
    private String userID;
    private Date time;
    private String topicName;
    private String content;
    private static ArrayList<Comment> cmts;

    public Topic() {
    }

    public Topic(String userID, Date time, String topicName, String content){
        this.userID = userID;
        this.time = time;
        this.topicName = topicName;
        this.content = content;
    }

    public Topic(int idTopic, String userID, Date time, String topicName, String content) {
        this.idTopic = idTopic;
        this.userID = userID;
        this.time = time;
        this.topicName = topicName;
        this.content = content;
        cmts = CommentDAO.getComments();
    }

    public int getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(int idTopic) {
        this.idTopic = idTopic;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public void numOfComment(){

    }

    public void addComment(Comment c) {
        if (c.getIdTopic() == this.idTopic) {
            cmts.add(c);
        }
    }

    public void deleteComment(Comment c) {
        for (int i = 0; i < cmts.size(); i++) {
            if (c.getIdCmt() == cmts.get(i).getIdCmt()) {
                cmts.remove(i);
                System.out.println("Done!");
            } else {
                System.out.println("Fail!");
            }
        }
    }

    public void updateTopic(int idTopic, String userID, Date time, String topicName, String content) {
        if (this.idTopic == idTopic && this.userID == userID) {
            this.time = time;
            this.topicName = topicName;
            this.content = content;
        }
    }

    public Topic insertTopic(int idTopic, String userID, Date d, String topicName, String content) {
        return new Topic(idTopic, userID, d, topicName, content);
    }

}
