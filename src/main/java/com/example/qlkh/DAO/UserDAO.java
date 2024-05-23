package com.example.qlkh.DAO;


import com.example.qlkh.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends DAO{
    public User checkLogin(String user, String pass){

        String sql = "SELECT * FROM user AS u WHERE u.username = ? AND u.password = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
            }
        }catch (SQLException e){

        }
        return null;
    }
    public boolean updatePassword(String email, String newPassword)  {
        boolean check = true;
        String sql = "UPDATE user SET password = ? WHERE email = ?";
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, newPassword);
            statement.setString(2, email);
            statement.executeUpdate();
            check = true;
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
            check = false;
        }

        return check;
    }
}
