package com.tap.daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.tap.dao.userDao;
import com.tap.dbutils.DBUtils;
import com.tap.model.User;


public class userDaoImpl implements userDao {

	
	private Connection connection;

	public userDaoImpl() //constructor
	{
		try {
			 connection = DBUtils.myConnect();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
    @Override
    public int insertUser(User user) {
        int result = 0;
        
        String addUser = "INSERT INTO user (username, password, email, address, role) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = connection.prepareStatement(addUser);
            if (user != null) { // Check if user is not null
                pstmt.setString(1, user.getUsername());
                pstmt.setString(2, user.getPassword());
                pstmt.setString(3, user.getEmail());
                pstmt.setString(4, user.getAddress());
                pstmt.setString(5, user.getRole());

                result = pstmt.executeUpdate();
            } else {
                System.out.println("User object is null in insertUser method.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    @Override
    public List<User> getAlluserData() {
        List<User> userList = new ArrayList<>();
        Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery","root","12345");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String query = "SELECT * FROM user";

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                User user=new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setRole(rs.getString("role"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return userList;
    }

    @Override
    public User getUser(String email) {
        User user = null;
        Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery","root","12345");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String query = "SELECT * FROM user WHERE email = ?";

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setRole(rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }

    @Override
    public int deleteUserById(int user_id) {
        int result = 0;
        Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery","root","12345");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String query = "DELETE FROM user WHERE user_id = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, user_id);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    @Override
    public int updateUserById(String password, int user_id) {
        int result = 0;
        Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery","root","12345");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String query = "UPDATE user SET password = ? WHERE user_id = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, password);
            pstmt.setInt(2, user_id);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
