package Datos.Conexion;

import static Datos.Conexion.modConexionDB.DB_Empleados;
import java.sql.ResultSet;

public class Funcion {

    /*Atributos*/
    private String id_funcion;
    private String nombre_funcion;
    
    /*Metodos*/
    public boolean Insertar_Funciones(){
        try {
           DB_Empleados.sqlExecute();
            String consulta = "INSERT INTO emp_t_funciones (id_funcion,nombre_funcion) VALUES ('"+id_funcion+"','"+nombre_funcion+"');";
            ResultSet rs_funciones;
            rs_funciones = DB_Empleados.sqlExecute(consulta);
            return true;                       
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }    
    /*Listar*/
    public ResultSet Listar_Funciones(){
            try {
           DB_Empleados.sqlExecute();           
            String consulta = "SELECT * FROM emp_t_funciones";
            ResultSet rs_funciones;
            rs_funciones = DB_Empleados.sqlExecute(consulta);                   
        return DB_Empleados.sqlExecute(consulta);
            } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    /*ELIMINAR*/
    public boolean Eliminar_Funciones(){
           try {
           DB_Empleados.sqlExecute();
            String consulta = "DELETE FROM emp_t_funciones WHERE id_funcion='"+id_funcion+"';";
            ResultSet rs_funciones;
            rs_funciones = DB_Empleados.sqlExecute(consulta);
            return true;                       
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }   
    }
    /*ACTUALIZAR*/
    public boolean Actualizar_Funciones(String Campo, String Valor){
           try {
           DB_Empleados.sqlExecute();      
            String consulta = "UPDATE emp_t_funciones SET "+Campo+"='"+Valor+"' WHERE id_funcion='"+id_funcion+"';";
            ResultSet rs_funciones;
            rs_funciones = DB_Empleados.sqlExecute(consulta);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public ResultSet BuscaFuncion (String ValorBuscado, String CampoBuscado, Boolean BusquedaParcial){
       /*Consulta -> 
        TipoBusqueda->*/ 
       String Consulta, TipoBusqueda;
       String Busqueda = " LIKE ";
       if (BusquedaParcial == true){
           TipoBusqueda = "%";
       }else{
           TipoBusqueda = "";
       }
       Consulta = "SELECT * FROM emp_t_funciones WHERE "+CampoBuscado+Busqueda+"'"+ValorBuscado+TipoBusqueda+"';";
        ResultSet Resultado;
        //System.out.println(""+Consulta);
        try {
            return DB_Empleados.sqlExecute(Consulta);
        }catch(Exception e){
            
            return null;
        }
    }
    public String getId_funcion() {
        return id_funcion;
    }

    public void setId_funcion(String id_funcion) {
        this.id_funcion = id_funcion;
    }

    public String getNombre_funcion() {
        return nombre_funcion;
    }

    public void setNombre_funcion(String nombre_funcion) {
        this.nombre_funcion = nombre_funcion;
    }
}