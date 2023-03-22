/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loader_tabele_asig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import proiect_asigurari_bd2.Connectare_BD;
import tabele_asig.Functie;

/**
 *
 * @author gingh
 */
public class FunctieLoader {
    
    
    public static List<Functie> load() throws ClassNotFoundException{
        List<Functie> listafunctie = new ArrayList<Functie>();

            try (Connection conn = Connectare_BD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM functie");
				ResultSet rs = pstmt.executeQuery();) {
			Functie functie=null;
                    while (rs.next()) {
				
				functie= new Functie();
                                functie.setCod_functie(rs.getInt("cod_functie"));
                                functie.setDenumire_functie(rs.getString("denumire_functie"));
				
				listafunctie.add(functie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listafunctie;
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



