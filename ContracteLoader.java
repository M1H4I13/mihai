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
import tabele_asig.Contracte;

/**
 *
 * @author gingh
 */
public class ContracteLoader {
    
    
    public static List<Contracte> load() throws ClassNotFoundException{
        List<Contracte> listacontracte = new ArrayList<Contracte>();

            try (Connection conn = Connectare_BD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM contracte");
				ResultSet rs = pstmt.executeQuery();) {
			Contracte contract=null;
                    while (rs.next()) {
				
				contract= new Contracte();
                                contract.setCod_contract(rs.getInt("cod_contract"));
                                contract.setAsigurat(rs.getInt("asigurat"));
				contract.setBeneficiar(rs.getInt("beneficiar"));
                                contract.setContractant(rs.getInt("contractant"));
                                contract.setNr_pers_asig(rs.getInt("nr_persoane_asig"));
                                contract.setNr_minori_asig(rs.getInt("nr_minori_asig"));
                                contract.setData_incepere(rs.getDate("data_incepere"));
                                contract.setData_incheiere(rs.getDate("data_incheiere"));
                                contract.setSuma_asigurata(rs.getInt("suma_asigurata"));
                                contract.setPret_platit(rs.getInt("pret_platit"));
                                contract.setCod_serviciu(rs.getInt("cod_serviciu"));
				listacontracte.add(contract);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listacontracte;
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

