package Datos.Conexion;

import static Datos.Conexion.modConexionDB.DB_Empleados;
import java.sql.ResultSet;

public class Cargo {

    /*Atributos*/
    private String id_cargo;
    private String nombre_cargo;
    
    /*Metodos*/
    public boolean Insertar_Cargos(){
        try {
           DB_Empleados.sqlExecute();
            String consulta = "INSERT INTO emp_t_cargos (id_cargo,nombre_cargo) VALUES ('"+id_cargo+"','"+nombre_cargo+"');";
            ResultSet rs_cargos;
            rs_cargos = DB_Empleados.sqlExecute(consulta);
            return true;                       
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }    
    /*Listar*/
    public ResultSet Listar_Cargos(){
            try {
           DB_Empleados.sqlExecute();           
            String consulta = "SELECT * FROM emp_t_cargos";
            ResultSet rs_cargos;
            rs_cargos = DB_Empleados.sqlExecute(consulta);                   
        return DB_Empleados.sqlExecute(consulta);
            } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    /*ELIMINAR*/
    public boolean Eliminar_Cargos(){
           try {
           DB_Empleados.sqlExecute();
            String consulta = "DELETE FROM emp_t_cargos WHERE id_cargo='"+id_cargo+"';";
            ResultSet rs_cargos;
            rs_cargos = DB_Empleados.sqlExecute(consulta);
            return true;                       
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }   
    }
    /*ACTUALIZAR*/
    public boolean Actualizar_Cargos(String Campo, String Valor){
           try {
           DB_Empleados.sqlExecute();      
            String consulta = "UPDATE emp_t_cargos SET "+Campo+"='"+Valor+"' WHERE id_cargo='"+id_cargo+"';";
            ResultSet rs_cargos;
            rs_cargos = DB_Empleados.sqlExecute(consulta);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    
    public ResultSet BuscaCargo (String ValorBuscado, String CampoBuscado, Boolean BusquedaParcial){
       /*Consulta -> 
        TipoBusqueda->*/ 
       String Consulta, TipoBusqueda;
       String Busqueda = " LIKE ";
       if (BusquedaParcial == true){
           TipoBusqueda = "%";
       }else{
           TipoBusqueda = "";
       }
       Consulta = "SELECT * FROM emp_t_cargos WHERE "+CampoBuscado+Busqueda+"'"+ValorBuscado+TipoBusqueda+"';";
        try {
            return DB_Empleados.sqlExecute(Consulta);
        }catch(Exception e){    
            return null;
        }
    }
    
    public ResultSet BuscarCargo_2 (String ValorBuscado){
        String Consulta;
        ValorBuscado = ValorBuscado + "%";
        Consulta = "SELECT * FROM emp_t_cargos WHERE id_cargo LIKE '"+ValorBuscado+"' OR nombre_cargo LIKE '"+ ValorBuscado+"'";
        try{
            return DB_Empleados.sqlExecute(Consulta);
        }catch(Exception e){
            return null;
        }
    }
    /**
     * @return the id_cargo
     */
    public String getId_cargo() {
        return id_cargo;
    }

    /**
     * @param id_cargo the id_cargo to set
     */
    public void setId_cargo(String id_cargo) {
        this.id_cargo = id_cargo;
    }

    /**
     * @return the nombre_cargo
     */
    public String getNombre_cargo() {
        return nombre_cargo;
    }

    public void setNombre_cargo(String nombre_cargo) {
        this.nombre_cargo = nombre_cargo;
    }
}