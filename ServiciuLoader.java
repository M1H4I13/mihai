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
import tabele_asig.Serviciu;

/**
 *
 * @author gingh
 */
public class ServiciuLoader {
    
    
    public static List<Serviciu> load() throws ClassNotFoundException{
        List<Serviciu> listaserviciu = new ArrayList<Serviciu>();

            try (Connection conn = Connectare_BD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM serviciu");
				ResultSet rs = pstmt.executeQuery();) {
			Serviciu serviciu=null;
                    while (rs.next()) {
				
				serviciu= new Serviciu();
                                serviciu.setCod_serviciu(rs.getInt("cod_serviciu"));
                                serviciu.setTip_asigurare(rs.getString("tip_asigurare"));
                                serviciu.setCod_angajat(rs.getInt("cod_angajat"));
				
				listaserviciu.add(serviciu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaserviciu;
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



