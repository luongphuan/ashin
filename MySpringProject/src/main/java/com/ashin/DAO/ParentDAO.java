package com.ashin.DAO;

import com.ashin.model.Connect;
import com.ashin.model.Parent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Khuong on 2017-06-05.
 */
public class ParentDAO {
    public ArrayList<Parent> showListParents(int idClass){
        ArrayList<Parent> list = new ArrayList<Parent>();
        try{
            PreparedStatement ps = Connect.getPreparedStatement("Select * from phuhuynh where MA_LOP=?");
            ps.setInt(1,idClass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Parent pa = new Parent();
                pa.setIdParent(rs.getInt(1));
                pa.setName(rs.getString(2));
                pa.setSex(rs.getString(6));
                pa.setDateBorn(rs.getDate(3));
                pa.setAddress(rs.getString(5));
                list.add(pa);
            }
            return list;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public Parent showInformationParent(int idPa){
        try {
            Parent pa = new Parent();
            PreparedStatement ps = Connect
                    .getPreparedStatement("SELECT * from PHUHUYNH where MA_PH=?");
            ps.setInt(1,idPa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pa.setIdParent(rs.getInt(1));
                pa.setName(rs.getString(2));
                pa.setSex(rs.getString(3));
                pa.setDateBorn(rs.getDate(4));
                pa.setAddress(rs.getString(5));
                pa.setUser(rs.getString(6));
            }
            return pa;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        ParentDAO pd = new ParentDAO();
        ArrayList<Parent> list = new ArrayList<Parent>();
        list = pd.showListParents(1);
        for (Parent parent:list){
            System.out.println(parent.getIdParent()+" "+parent.getName()+" "
            +parent.getSex()+" "+parent.getDateBorn()+" "+parent.getAddress());
        }


    }


}

