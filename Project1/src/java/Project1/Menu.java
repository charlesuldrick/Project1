/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project1;

/**
 *
 * @author chu19
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Menu {
    
    private final DAOfactory daoFactory;
    
    private final String QUERY_SESSION_LIST = "SELECT * FROM currency ORDER BY description";
    

    Menu(DAOfactory aThis) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String getCurrencyListAsHTML() {
        
        StringBuilder s = new StringBuilder();

        Connection conn = daoFactory.getConnection();
        
        PreparedStatement ps = null;
        
        ResultSet rs = null;

        try {

            ps = conn.prepareStatement(QUERY_SESSION_LIST);
            
            boolean hasresults = ps.execute();

            if (hasresults) {

                rs = ps.getResultSet();
                
                s.append("<select name=\"target_currency\" id=\"target_currency\">");
                
                while (rs.next()) {
                    
                    String id = rs.getString("id");
                    
                    String description = rs.getString("description");
                    
                    s.append("<option value=\"").append(id).append("\">");
                    
                    s.append(description);
                    
                    s.append("</option>");
                                        
                }
                
                s.append("</select>");

            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {

            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                }
                catch (Exception e) { e.printStackTrace(); }
            }
            if (ps != null) {
                try {
                    ps.close();
                    ps = null;
                }
                catch (Exception e) { e.printStackTrace(); }
            }
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                }
                catch (Exception e) { e.printStackTrace(); }
            }

        }
        
        return s.toString();
        
    }
}
