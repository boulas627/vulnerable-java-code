
package com.example.vulnapp.service;

import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.*;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {

    @Autowired
    private DataSource dataSource;

    public String findUser(String username) throws Exception {
        Connection conn = dataSource.getConnection();
        Statement stmt = conn.createStatement();
        String query = "SELECT role FROM users WHERE username = ?";

        PreparedStatement pstmt = conn.prepareStatement(query); 
        
        pstmt.setString(1, username); 
        # setString() will ensure that a string value is passed into the prepared statement
        
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getString("role");
        }
        return null;
    }
}
