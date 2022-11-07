/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project1;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAOfactory {

    private DataSource ds = null;

    public DAOfactory() {

        try {

            Context envContext = new InitialContext();
            Context initContext = (Context) envContext.lookup("java:/comp/env");
            ds = (DataSource) initContext.lookup("jdbc/db_pool");

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    Connection getConnection() {

        Connection c = null;

        try {

            if (ds != null) {
                c = ds.getConnection();
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return c;

    }
    
    public Rate getRate() {
        return new Rate(this);
    }
    public Menu getMenu() {
        return new Menu(this);
    }

    
    
}