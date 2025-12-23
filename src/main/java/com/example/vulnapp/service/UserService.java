
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
        String query = "SELECT role FROM users WHERE username = '" + username + "'";

        PreparedStatement pstmt = conn.prepareStatement(query); 
        
        ResultSet rs = stmt.executeQuery(pstmt);
        if (rs.next()) {
            return rs.getString("role");
        }
        return null;
    }
}
