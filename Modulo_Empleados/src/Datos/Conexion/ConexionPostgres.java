package Datos.Conexion;

import java.sql.*;
import javax.naming.spi.DirStateFactory;
import javax.swing.text.StyledEditorKit;


 
public class ConexionPostgres {
    /*Variables de conexion*/  
    public String DB, Host,Port,User,Pass;
    public Boolean ExisteConexion = false;
      
    private String url ;
    private Connection  conexion = null;
 
//ejecución de  sql y retorno de resultados 
 Statement sentencia;

 //obtener filas que retorne la ejecución de la consulta sql
 ResultSet resultado;
    StringBuilder sqlFull = new StringBuilder();
 
 public Boolean Conectar () {
    
     try {
         url = "jdbc:postgresql://"+Host+":"+Port+"/"+DB; 
         System.out.println(" url: " + url);
         Class.forName("org.postgresql.Driver"); 
        
             conexion = DriverManager.getConnection( url, User, Pass);
            
             
       ExisteConexion = true;
       System.out.println("hay conexion");
     
     } catch (Exception e) {
         ExisteConexion = false; 
          System.out.println("Problemas conexion");
     }  
     
 return ExisteConexion;
 }
  
 public void cerrarConexion() throws SQLException{
     conexion.close();
   
 }
 
 
 public ResultSet sqlExecute(String sql) throws SQLException{
    return sqlExecutePrivate(sql);
 }
 
     public void add(String line){
               sqlFull.append(line);
      }
 
public ResultSet sqlExecute() throws SQLException{
    return sqlExecutePrivate(sqlFull.toString());

}
 
private ResultSet sqlExecutePrivate(String sql) throws SQLException{
 Statement st = conexion.createStatement();
      
     if (st.execute(sql)){
             return st.getResultSet();
         }else {
             return null;
         }
 }        
}