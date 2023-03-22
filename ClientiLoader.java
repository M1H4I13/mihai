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
import tabele_asig.Clienti;


public class ClientiLoader {
    
    
    public static List<Clienti> load() throws ClassNotFoundException{
        List<Clienti> listaclient = new ArrayList<Clienti>();

            try (Connection conn = Connectare_BD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM client");
				ResultSet rs = pstmt.executeQuery();) {
			Clienti client=null;
                    while (rs.next()) {
				
				client= new Clienti();
                                client.setCod_client(rs.getInt("cod_client"));
                                client.setNume_client(rs.getString("nume_client"));
				client.setPrenume_client(rs.getString("prenume_client"));
                                client.setCNP_client(rs.getString("CNP_client"));
                                client.setData_nastere_client(rs.getDate("data_nastere_client"));
                                client.setStare_civila_client(rs.getString("stare_civila_client"));
                                client.setAdresa_client(rs.getString("adresa_client"));
                                client.setTelefon_client(rs.getString("telefon_client"));
				listaclient.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaclient;
	}
    
    public static List<Clienti> loadAscendent() throws ClassNotFoundException{
        List<Clienti> listaclient = new ArrayList<Clienti>();

            try (Connection conn = Connectare_BD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM client order by prenume_client ASC");
				ResultSet rs = pstmt.executeQuery();) {
			Clienti client=null;
                    while (rs.next()) {
				
				client=new Clienti();
                                client.setCod_client(rs.getInt("cod_client"));
                                client.setNume_client(rs.getString("nume_client"));
				client.setPrenume_client(rs.getString("prenume_client"));
                                client.setCNP_client(rs.getString("CNP_client"));
                                client.setData_nastere_client(rs.getDate("data_nastere_client"));
                                client.setStare_civila_client(rs.getString("stare_civila_client"));
                                client.setAdresa_client(rs.getString("adresa_client"));
                                client.setTelefon_client(rs.getString("telefon_client"));
				listaclient.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaclient;
	}
    
    public static List<Clienti> loadDescendent() throws ClassNotFoundException{
        List<Clienti> listaclient = new ArrayList<Clienti>();

            try (Connection conn = Connectare_BD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM client order by prenume_client DESC");
				ResultSet rs = pstmt.executeQuery();) {
			Clienti client=null;
                    while (rs.next()) {
				
				client=new Clienti();
                                client.setCod_client(rs.getInt("cod_client"));
                                client.setNume_client(rs.getString("nume_client"));
				client.setPrenume_client(rs.getString("prenume_client"));
                                client.setCNP_client(rs.getString("CNP_client"));
                                client.setData_nastere_client(rs.getDate("data_nastere_client"));
                                client.setStare_civila_client(rs.getString("stare_civila_client"));
                                client.setAdresa_client(rs.getString("adresa_client"));
                                client.setTelefon_client(rs.getString("telefon_client"));
				listaclient.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaclient;
	}
    
    
    
    public static void insertClient(Clienti a1) throws ClassNotFoundException, SQLException{
            try {
                Connection conn = Connectare_BD.getConnection();
                    PreparedStatement pstmt = conn.prepareStatement("INSERT INTO client(cod_client, nume_client, prenume_client, CNP_client, data_nastere_client, stare_civila_client, adresa_client, telefon_client)"
                            + " VALUES (?,?,?,?,?,?,?,?)");
                
                        pstmt.setInt(1,a1.getCod_client());
                        pstmt.setString(2,a1.getNume_client());
                        pstmt.setString(3, a1.getPrenume_client());
                        pstmt.setString(4,a1.getCNP_client());
                        pstmt.setDate(5, (Date) a1.getData_nastere_client());
                        pstmt.setString(6, a1.getStare_civila_client());
                        pstmt.setString(7, a1.getAdresa_client());
                        pstmt.setString(8, a1.getTelefon_client());
                        
                        pstmt.executeUpdate();
                        System.out.println("INSERT cu succes");
                }
            catch (SQLException e) {
                e.printStackTrace();
                
            }
            
        }
    
    public static void deleteClient(int id) throws ClassNotFoundException, SQLException{
            try {Connection conn = Connectare_BD.getConnection();
                    PreparedStatement pstmt = conn.prepareStatement("DELETE FROM client where cod_client=?;");
                    pstmt.setInt(1,id);
                    pstmt.executeUpdate();
                    System.out.println("Stergerea s-a efectuat cu succes!");
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void updateClient(Clienti a2, int id) throws ClassNotFoundException, SQLException{
            try {Connection conn = Connectare_BD.getConnection();
                    PreparedStatement pstmt = conn.prepareStatement("UPDATE client SET cod_client=?, nume_client=?, prenume_client=?, CNP_client=?, data_nastere_client=?, "
                            + "stare_civila_client=?, adresa_client=?, telefon_client=? where cod_client=?;");
                
                        pstmt.setInt(1,a2.getCod_client());
                        pstmt.setString(2,a2.getNume_client());
                        pstmt.setString(3, a2.getPrenume_client());
                        pstmt.setString(4,a2.getCNP_client());
                        pstmt.setDate(5, (Date) a2.getData_nastere_client());
                        pstmt.setString(6, a2.getStare_civila_client());
                        pstmt.setString(7, a2.getAdresa_client());
                        pstmt.setString(8, a2.getTelefon_client());
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

