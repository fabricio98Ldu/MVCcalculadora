/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.intsuperior.modelo;

import java.sql.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Corei5
 */
public class conexion {
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user ="root";
    private static final String pass ="123456";
    private static final String url ="jdbc:mysql://localhost:3306/factura";

    public conexion() {
        conn=null;
        try{
            Class.forName( driver );
            conn=DriverManager.getConnection(url,user,pass);
            if(conn != null){
                System.out.println("Conexion establecida");
            }
            
        } catch (ClassNotFoundException | SQLException e){
            System.out.println("error en la conexion  " + e);
        }  
    }
    // este metodo retorna la conexion
    public Connection getConnection(){
        return conn;
    }
    // este metodo nos desconecta a la BD
    public void desconectar(){
        conn=null;
        if(conn == null){
            System.out.print("conexion terminada");
        }
    }
    
    public void ver(){
        Statement st;
        ResultSet rs;
        try{
            st=conn.createStatement();
            rs=st.executeQuery("select * from usuarios");
            while(rs.next()){
                System.out.println(rs.getInt("idusuarios")+ " "+rs.getString("nombreU"));
            }
            conn.close();
        }catch (Exception e){
            
        }
        
    }
    


    
}
