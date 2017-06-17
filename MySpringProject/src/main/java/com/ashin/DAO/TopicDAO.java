package com.ashin.DAO;


import com.ashin.model.Connect;
import com.ashin.model.Topic;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by trile on 4/16/2017.
 */
public class TopicDAO {

    public static ArrayList<Topic> getTopics() {
        ArrayList<Topic> listTopics = new ArrayList<Topic>();

        if (listTopics.size() == 0) {
            try {
//                Connection cnt = Connect.open();;
//                Statement stmt = cnt.createStatement();
//                String sql = "select * from topic";
                PreparedStatement ps = Connect
                        .getPreparedStatement("select * from topic");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int idTopic = rs.getInt(1);
                    String userID = rs.getString(2);
                    Date d = rs.getDate(3);
                    String topicName = rs.getString(4);
                    String content = rs.getString(5);
//                    int numOfComments = rs.getInt(6);
                    //Comment c = new Comment(idCmt, content, d, userID, idTopic);
                    listTopics.add(new Topic(idTopic, userID, d, topicName, content));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listTopics;
    }

    public static ArrayList<Topic> topics = getTopics();

    public static int createTopic(Topic t) {
        int result = 0;
//        String sql = "INSERT INTO TOPIC(USERNAME, THOI_GIAN, CHU_DE, NOI_DUNG, SO_CMT) VALUES (?,now(),?,?,0)";
//        Connection cnt = Connect.open();;
        PreparedStatement ps = Connect
                .getPreparedStatement("INSERT INTO TOPIC(USERNAME, THOI_GIAN, CHU_DE, NOI_DUNG, SO_CMT) VALUES (?,now(),?,?,0)");

        try {
            int i;
            ps.setString(1, t.getUserID());
            ps.setString(2, t.getTopicName());
            ps.setString(3, t.getContent());
            i = ps.executeUpdate();
            if (i > 0) {
                result = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }

        return result;
    }

    public static int editTopic(Topic tp) {
        int tmp = 0;
        PreparedStatement ps = Connect
                .getPreparedStatement("UPDATE TOPIC SET NOI_DUNG=?, THOI_GIAN=NOW() WHERE ID_TOPIC=?");

        try {
            ps.setString(1, tp.getContent());
            ps.setInt(2, tp.getIdTopic());
            for (int i = 0; i < topics.size(); i++) {
                if (tp.getIdTopic() == topics.get(i).getIdTopic() && tp.getUserID().equals(topics.get(i).getUserID())) {
                    tmp = ps.executeUpdate();
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tmp;
    }

    public static Topic deleteTopic(Topic tp) {
        Topic topic = null;
        PreparedStatement ps = Connect
                .getPreparedStatement("delete from topic where ID_topic="+tp.getIdTopic());
        try {
            for (int i = 0; i < topics.size(); i++) {
                if (tp.getIdTopic() == topics.get(i).getIdTopic()) {
                    topic = topics.remove(i);
                    ps.executeUpdate();
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topic;
    }

    public Topic getATopic(int id) {
        Topic topic = null;
        for (Topic t : topics) {
            if(t.getIdTopic()==id){
                topic = t;
                break;
            }
        }

        return topic;
    }
    public int size() {
        return topics.size();
    }

    public static void main(String[] args) {
        TopicDAO t = new TopicDAO();

        Topic t1 = new Topic("HS001", Calendar.getInstance().getTime(), "XXXXx", "yyyyyyy");
        int a = t.createTopic(t1);

        System.out.println(a);
    }

}
