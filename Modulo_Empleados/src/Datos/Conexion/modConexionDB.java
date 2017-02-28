package Datos.Conexion;

import Datos.Conexion.ConexionPostgres;

public  class modConexionDB {
     public static  ConexionPostgres DB_Empleados = new ConexionPostgres(); 
       
    public static void conexionDB(){
    
       DB_Empleados.Host = "localhost";
       DB_Empleados.Port = "5432";
       DB_Empleados.DB = "db_empleados2";
       DB_Empleados.User = "postgres";
       DB_Empleados.Pass = "ipciisa";
       DB_Empleados.Conectar();
        
   
    }
    
}
