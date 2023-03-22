package loader_tabele_asig;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proiect_asigurari_bd2.Connectare_BD;
import tabele_asig.Beneficiar;


public class BeneficiarLoader {
    

    public static List<Beneficiar> load() throws ClassNotFoundException{
        List<Beneficiar> listabeneficiar = new ArrayList<Beneficiar>();

            try (Connection conn = Connectare_BD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM beneficiar");
				ResultSet rs = pstmt.executeQuery();) {
			Beneficiar beneficiar=null;
                    while (rs.next()) {
				
				beneficiar=new Beneficiar();
                                beneficiar.setCod_benef(rs.getInt("cod_benef"));
                                beneficiar.setNume_benef(rs.getString("nume_benef"));
				beneficiar.setPrenume_benef(rs.getString("prenume_benef"));
                                beneficiar.setCNP_benef(rs.getString("CNP_benef"));
                                beneficiar.setData_nastere_benef(rs.getDate("data_nastere_benef"));
                                beneficiar.setStare_civila_benef(rs.getString("stare_civila_benef"));
                                beneficiar.setAdresa_benef(rs.getString("adresa_benef"));
                                beneficiar.setTelefon_benef(rs.getString("telefon_benef"));
				listabeneficiar.add(beneficiar);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listabeneficiar;
	}
    
    public static List<Beneficiar> loadAscendent() throws ClassNotFoundException{
        List<Beneficiar> listabeneficiar = new ArrayList<Beneficiar>();

            try (Connection conn = Connectare_BD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM beneficiar order by prenume_benef ASC");
				ResultSet rs = pstmt.executeQuery();) {
			Beneficiar beneficiar=null;
                    while (rs.next()) {
				
				beneficiar=new Beneficiar();
                                beneficiar.setCod_benef(rs.getInt("cod_benef"));
                                beneficiar.setNume_benef(rs.getString("nume_benef"));
				beneficiar.setPrenume_benef(rs.getString("prenume_benef"));
                                beneficiar.setCNP_benef(rs.getString("CNP_benef"));
                                beneficiar.setData_nastere_benef(rs.getDate("data_nastere_benef"));
                                beneficiar.setStare_civila_benef(rs.getString("stare_civila_benef"));
                                beneficiar.setAdresa_benef(rs.getString("adresa_benef"));
                                beneficiar.setTelefon_benef(rs.getString("telefon_benef"));
				listabeneficiar.add(beneficiar);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listabeneficiar;
	}
    
    public static List<Beneficiar> loadDescendent() throws ClassNotFoundException{
        List<Beneficiar> listabeneficiar = new ArrayList<Beneficiar>();

            try (Connection conn = Connectare_BD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM beneficiar order by prenume_benef DESC");
				ResultSet rs = pstmt.executeQuery();) {
			Beneficiar beneficiar=null;
                    while (rs.next()) {
				
				beneficiar=new Beneficiar();
                                beneficiar.setCod_benef(rs.getInt("cod_benef"));
                                beneficiar.setNume_benef(rs.getString("nume_benef"));
				beneficiar.setPrenume_benef(rs.getString("prenume_benef"));
                                beneficiar.setCNP_benef(rs.getString("CNP_benef"));
                                beneficiar.setData_nastere_benef(rs.getDate("data_nastere_benef"));
                                beneficiar.setStare_civila_benef(rs.getString("stare_civila_benef"));
                                beneficiar.setAdresa_benef(rs.getString("adresa_benef"));
                                beneficiar.setTelefon_benef(rs.getString("telefon_benef"));
				listabeneficiar.add(beneficiar);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listabeneficiar;
	}
    
    
    
    public static void insertBeneficiar(Beneficiar a1) throws ClassNotFoundException, SQLException{
            try {
                Connection conn = Connectare_BD.getConnection();
                    PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Beneficiar(cod_benef, nume_benef, prenume_benef, CNP_benef, data_nastere_benef, stare_civila_benef, adresa_benef, telefon_benef)"
                            + " VALUES (?,?,?,?,?,?,?,?)");
                
                        pstmt.setInt(1,a1.getCod_benef());
                        pstmt.setString(2,a1.getNume_benef());
                        pstmt.setString(3, a1.getPrenume_benef());
                        pstmt.setString(4,a1.getCNP_benef());
                        pstmt.setDate(5, (Date) a1.getData_nastere_benef());
                        pstmt.setString(6, a1.getStare_civila_benef());
                        pstmt.setString(7, a1.getAdresa_benef());
                        pstmt.setString(8, a1.getTelefon_benef());
                        
                        pstmt.executeUpdate();
                        System.out.println("INSERT cu succes");
                }
            catch (SQLException e) {
                e.printStackTrace();
                
            }
            
        }
    
    public static void deleteBeneficiar(int id) throws ClassNotFoundException, SQLException{
            try {Connection conn = Connectare_BD.getConnection();
                    PreparedStatement pstmt = conn.prepareStatement("DELETE FROM Beneficiar where cod_beneficiar=?;");
                    pstmt.setInt(1,id);
                    pstmt.executeUpdate();
                    System.out.println("Stergerea s-a efectuat cu succes!");
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void updateBeneficiar(Beneficiar a2, int id) throws ClassNotFoundException, SQLException{
            try {Connection conn = Connectare_BD.getConnection();
                    PreparedStatement pstmt = conn.prepareStatement("UPDATE angajati SET cod_benef=?, nume_benef=?, prenume_benef=?, CNP_benef=?, data_nastere_benef=?, "
                            + "stare_civila_benef=?, adresa_benef=?, telefon_benef=? where cod_benef=?;");
                
                         pstmt.setInt(1,a2.getCod_benef());
                        pstmt.setString(2,a2.getNume_benef());
                        pstmt.setString(3, a2.getPrenume_benef());
                        pstmt.setString(4,a2.getCNP_benef());
                        pstmt.setDate(5, (Date) a2.getData_nastere_benef());
                        pstmt.setString(6, a2.getStare_civila_benef());
                        pstmt.setString(7, a2.getAdresa_benef());
                        pstmt.setString(8, a2.getTelefon_benef());
                        //pstmt.setInt(10,id);
                        
                        pstmt.executeUpdate();
                        System.out.println("UPDATE cu succes");
                        
                }
            catch (SQLException e) {
                e.printStackTrace();
        }
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

