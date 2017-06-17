package com.ashin.DAO;

import com.ashin.model.Comment;
import com.ashin.model.Connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by trile on 4/16/2017.
 */
public class CommentDAO {
    private static final int NUM_PAGES =5;
    public static ArrayList<Comment> getComments() {
        ArrayList<Comment> cmts = new ArrayList<Comment>();
        if (cmts.size() == 0) {
            try {
                PreparedStatement ps = Connect
                        .getPreparedStatement("select * from cmt");
//                String sql = "select * from cmt";
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int idCmt = rs.getInt(1);
                    int idTopic = rs.getInt(2);
                    String userID = rs.getString(3);
                    String content = rs.getString(4);
                    Timestamp d = rs.getTimestamp(5);

                    cmts.add(new Comment(idCmt, content, d, userID, idTopic));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cmts;
    }

    public static ArrayList<Comment> comments = getComments();

    public static ArrayList<Comment> getCmtOfTopic(int idTopic){
        ArrayList<Comment> cmts = new ArrayList<Comment>();
        for(int i =0; i<comments.size();i++){
            if(idTopic == comments.get(i).getIdTopic()){
                cmts.add(comments.get(i));
            }
        }
        return cmts;
    }

    public static int addComment1(Comment c) {
//        String sql = "insert into cmt(ID_TOPIC, USERNAME, NOI_DUNG, THOI_GIAN) values(?,?,?,now());";
//        Connection cnt = Connect.open();;
        PreparedStatement ps = Connect
                .getPreparedStatement("insert into cmt(ID_TOPIC, USERNAME, NOI_DUNG, THOI_GIAN) values(?,?,?,now())");
        int result = 0;
        try {
            int i;
//            PreparedStatement ps = cnt.prepareStatement(sql);
            ps.setInt(1, c.getIdTopic());
            ps.setString(2, c.getUserID());
            ps.setString(3, c.getContent());
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

    public static Comment getCmt(int id) {
        Comment c = null;
        for (Comment cmt : comments) {
            if (cmt.getIdCmt() == id) {
                c = cmt;
                break;
            }
        }
        return c;
    }

    public static int editComment(Comment c) throws SQLException {
//        String sql = "UPDATE CMT SET NOI_DUNG=?, THOI_GIAN= NOW() WHERE CMT.ID_CMT =?";
//        Connection cnt = Connect.open();;

        PreparedStatement ps = Connect
                .getPreparedStatement("UPDATE CMT SET NOI_DUNG=?, THOI_GIAN= NOW() WHERE CMT.ID_CMT =?");
        int tmp = 0;
//        PreparedStatement stmt = cnt.prepareStatement(sql);
        ps.setString(1, c.getContent());
        ps.setInt(2, c.getIdCmt());
        for (int i = 0; i < comments.size(); i++) {
            if (c.getIdCmt() == comments.get(i).getIdCmt() && c.getUserID().equals(comments.get(i).getUserID())) {
                tmp = ps.executeUpdate();
                break;
            }
        }
        return tmp;
    }

    public static int size() {
        return comments.size();
    }

    public static int pageNum(){
        int result=0;
        result = size()/5;
        if(size() % 5 != 0){
            result++;
        }
        return result;
    }

    public static Comment deleteComment(Comment comment) throws SQLException {
        Comment c = null;
//        Connection cnt = Connect.open();;
//        Statement stmt = cnt.createStatement();
//        String sql = "delete from cmt where ID_CMT=" + comment.getIdCmt();
        PreparedStatement ps = Connect
                .getPreparedStatement("delete from cmt where ID_CMT=" +comment.getIdCmt());
        for (int i = 0; i < comments.size(); i++) {
            if (comment.getIdCmt() == comments.get(i).getIdCmt()) {
                c = comments.remove(i);
                ps.execute();
                break;
            }
        }
        return c;
    }

    public ArrayList<Comment> getCommentPerPage(int page){
        Connection cnt = Connect.open();
        String sql ="";
        ArrayList<Comment> cmts = new ArrayList<>();
        if(page == pageNum()){
            sql = "SELECT * FROM CMT LIMIT 0,"+ size()%NUM_PAGES;
        } else{
            sql = "SELECT * FROM CMT LIMIT "+(size() - page*NUM_PAGES)+","+NUM_PAGES;
        }
        try {
            PreparedStatement stmt = cnt.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                int idCmt = rs.getInt(1);
                int idTopic = rs.getInt(2);
                String userID = rs.getString(3);
                String content = rs.getString(4);
                Timestamp d = rs.getTimestamp(5);

                cmts.add(new Comment(idCmt, content, d, userID, idTopic));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cmts;
    }
//    public ArrayList<Comment> getPageComment(int page){
//        ArrayList<Comment> comments = new ArrayList<>();
//        if(page < pageNum()) {
//            comments = getCommentPerPage(((size()/NUM_PAGES) - page)*NUM_PAGES);
//        }
//        return comments;
//    }

    public ArrayList<Comment> getPagePerComment(int a){
        return null;
    }

    public static void main(String[] args) throws SQLException {
//        CommentDAO c = new CommentDAO();
//        Comment cmt = c.deleteComment(2);

//        Comment c2 = new Comment(12, "Alo cai con c4aa24aaax", Calendar.getInstance().getTime(), "HS002", 4);
//        System.out.println(c.addComment(c2));

//        System.out.println(cmt.toString());
//        Comment cmt = c.getCmt(3);
        // Comment cmt = c.deleteComment();
        //  System.out.println(cmt.toString());
//        int a = c.addComment(c2);

        //  boolean a = c.editComment(c2);
//        System.out.println(c.getComments().get(1));
//        System.out.println(a);
//        System.out.println(c.size());
//        System.out.println(size());
//        System.out.println(pageNum());
//        System.out.println(c.getCommentPerPage(5).size());
    }
}
