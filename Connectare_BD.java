/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiect_asigurari_bd2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author gingh
 */
public class Connectare_BD {
    
    public static final String DB_URL = "jdbc:mysql://localhost:3306/asigurari";
    public static final String USER = "root";
    public static final String PASS = "";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String QUERY = "SELECT nume_angajat, prenume_angajat FROM angajati";
    
    public static Connection getConnection () throws SQLException, ClassNotFoundException{
        Class.forName(DRIVER);
        Connection conn=DriverManager.getConnection(DB_URL, USER, PASS);
        
        return conn;
    }
    
    
    public static void closeResultSet(ResultSet rs){
        if(rs!=null){
            try{
                rs.close();
            } catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static void closePreparedStatement(PreparedStatement pstmt){
        if(pstmt!=null){
            try{
                pstmt.close();
            } catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static void closeConnection(Connection conn){
        if(conn!=null){
            try{
                conn.close();
            } catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    
    public static void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs){
        
        closeResultSet(rs);
        closePreparedStatement(pstmt);
        closeConnection(conn);
        
    }
    
    
}