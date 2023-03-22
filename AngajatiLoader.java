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
import tabele_asig.Angajati;


public class AngajatiLoader {
    
    public static List<Angajati> load() throws ClassNotFoundException{
        List<Angajati> listaangajati = new ArrayList<Angajati>();

            try (Connection conn = Connectare_BD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM angajati");
				ResultSet rs = pstmt.executeQuery();) {
			Angajati angajati=null;
                    while (rs.next()) {
				
				angajati=new Angajati();
                                angajati.setCod_angajat(rs.getInt("cod_angajat"));
                                angajati.setNume_angajat(rs.getString("nume_angajat"));
				angajati.setPrenume_angajat(rs.getString("prenume_angajat"));
                                angajati.setCond_functie_angajat(rs.getInt("cod_functie_angajat"));
                                angajati.setData_nastere_angajat(rs.getDate("data_nastere_angajat"));
                                angajati.setAdresa_angajat(rs.getString("adresa_angajat"));
                                angajati.setTelefon_angajat(rs.getString("telefon_angajat"));
                                angajati.setEmail_angajat(rs.getString("email_angajat"));
                                angajati.setSalariu_angajat(rs.getFloat("salariu_angajat"));
				listaangajati.add(angajati);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaangajati;
	}
    
    public static List<Angajati> loadAscendent() throws ClassNotFoundException{
        List<Angajati> listaangajati = new ArrayList<Angajati>();

            try (Connection conn = Connectare_BD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM angajati order by salariu_angajat ASC");
				ResultSet rs = pstmt.executeQuery();) {
			Angajati angajati=null;
                    while (rs.next()) {
				
				angajati=new Angajati();
                                angajati.setCod_angajat(rs.getInt("cod_angajat"));
                                angajati.setNume_angajat(rs.getString("nume_angajat"));
				angajati.setPrenume_angajat(rs.getString("prenume_angajat"));
                                angajati.setCond_functie_angajat(rs.getInt("cod_functie_angajat"));
                                angajati.setData_nastere_angajat(rs.getDate("data_nastere_angajat"));
                                angajati.setAdresa_angajat(rs.getString("adresa_angajat"));
                                angajati.setTelefon_angajat(rs.getString("telefon_angajat"));
                                angajati.setEmail_angajat(rs.getString("email_angajat"));
                                angajati.setSalariu_angajat(rs.getFloat("salariu_angajat"));
				listaangajati.add(angajati);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaangajati;
	}
    
    public static List<Angajati> loadDescendent() throws ClassNotFoundException{
        List<Angajati> listaangajati = new ArrayList<Angajati>();

            try (Connection conn = Connectare_BD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM angajati order by salariu_angajat DESC");
				ResultSet rs = pstmt.executeQuery();) {
			Angajati angajati=null;
                    while (rs.next()) {
				
				angajati=new Angajati();
                                angajati.setCod_angajat(rs.getInt("cod_angajat"));
                                angajati.setNume_angajat(rs.getString("nume_angajat"));
				angajati.setPrenume_angajat(rs.getString("prenume_angajat"));
                                angajati.setCond_functie_angajat(rs.getInt("cod_functie_angajat"));
                                angajati.setData_nastere_angajat(rs.getDate("data_nastere_angajat"));
                                angajati.setAdresa_angajat(rs.getString("adresa_angajat"));
                                angajati.setTelefon_angajat(rs.getString("telefon_angajat"));
                                angajati.setEmail_angajat(rs.getString("email_angajat"));
                                angajati.setSalariu_angajat(rs.getFloat("salariu_angajat"));
				listaangajati.add(angajati);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaangajati;
	}
    
    
    
    public static void insertAngajati(Angajati a1) throws ClassNotFoundException, SQLException{
            try {
                Connection conn = Connectare_BD.getConnection();
                    PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ANGAJATI(cod_angajat, nume_angajat, prenume_angajat, cod_functie_angajat, data_nastere_angajat, adresa_angajat, telefon_angajat, email_angajat, salariu_angajat)"
                            + " VALUES (?,?,?,?,?,?,?,?,?)");
                
                        pstmt.setInt(1,a1.getCod_angajat());
                        pstmt.setString(2,a1.getNume_angajat());
                        pstmt.setString(3, a1.getPrenume_angajat());
                        pstmt.setInt(4,a1.getCond_functie_angajat());
                        pstmt.setDate(5, (Date) a1.getData_nastere_angajat());
                        pstmt.setString(6, a1.getAdresa_angajat());
                        pstmt.setString(7, a1.getTelefon_angajat());
                        pstmt.setString(8, a1.getEmail_angajat());
                        pstmt.setFloat(9, a1.getSalariu_angajat());
                        
                        pstmt.executeUpdate();
                        System.out.println("INSERT cu succes");
                }
            catch (SQLException e) {
                e.printStackTrace();
                
            }
            
        }
    
    public static void deleteAngajati(int id) throws ClassNotFoundException, SQLException{
            try {Connection conn = Connectare_BD.getConnection();
                    PreparedStatement pstmt = conn.prepareStatement("DELETE FROM angajati where cod_angajat=?;");
                    pstmt.setInt(1,id);
                    pstmt.executeUpdate();
                    System.out.println("Stergerea s-a efectuat cu succes!");
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void updateAngajati(Angajati a2, int id) throws ClassNotFoundException, SQLException{
            try {Connection conn = Connectare_BD.getConnection();
                    PreparedStatement pstmt = conn.prepareStatement("UPDATE angajati SET cod_angajat=?, nume_angajat=?, prenume_angajat=?, cond_functie_angajat=?, data_nastere_angajat=?, "
                            + "adresa_angajat=?, telefon_angajat=?, email_angajat=?, salariu_angajat=? where cod_angajat=?;");
                
                        pstmt.setInt(1, a2.getCod_angajat());
                        pstmt.setString(2,a2.getNume_angajat());
                        pstmt.setString(3, a2.getPrenume_angajat());
                        pstmt.setInt(4, a2.getCond_functie_angajat());
                        pstmt.setDate(5, (Date) a2.getData_nastere_angajat());
                        pstmt.setString(6, a2.getAdresa_angajat());
                        pstmt.setString(7, a2.getTelefon_angajat());
                        pstmt.setString(8, a2.getEmail_angajat());
                        pstmt.setFloat(9, a2.getSalariu_angajat());
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

