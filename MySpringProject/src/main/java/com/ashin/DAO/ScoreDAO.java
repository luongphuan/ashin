package com.ashin.DAO;

import com.ashin.model.Connect;
import com.ashin.model.ScoreBoard;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by anluo on 4/16/2017.
 */
public class ScoreDAO {
    public ScoreBoard showScore(int idStudent,int semester){
        try {
            ScoreBoard sb = new ScoreBoard();
            PreparedStatement ps = Connect
                    .getPreparedStatement("SELECT * from CHITIETBANGDIEM where MA_HS=? AND HOC_KY=?");
            ps.setInt(1,idStudent);
            ps.setInt(2,semester);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sb.setIdSubject(rs.getInt(1));
                sb.setIdClass(rs.getInt(2));
                sb.setIdStudent(rs.getInt(3));
                sb.setOralScore(rs.getInt(4));
                sb.setFifteenMinutesScore(rs.getInt(5));
                sb.setFortyfiveMinutesScore(rs.getInt(6));
                sb.setFinalScore(rs.getInt(7));
                sb.setTotalScore(rs.getInt(8));
                sb.setSemester(rs.getInt(9));
            }
            return sb;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        ScoreDAO sd = new ScoreDAO();
        System.out.println(sd.showScore(1,1).getTotalScore());
    }
}
