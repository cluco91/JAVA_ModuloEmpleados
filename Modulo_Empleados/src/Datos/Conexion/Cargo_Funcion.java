package Datos.Conexion;

import static Datos.Conexion.modConexionDB.DB_Empleados;
import java.sql.ResultSet;

public class Cargo_Funcion {

    /*Atributos de Cargo_Funcion*/
    private String id_cargo;
    private String id_funcion;
    
    /*Metodos*/
    public boolean Insertar_CargoFuncion(){
        try {
           DB_Empleados.sqlExecute();
            String consulta = "INSERT INTO emp_t_cargos_funciones (id_cargo,id_funcion) VALUES ('"+getId_cargo()+"','"+getId_funcion()+"');";
            ResultSet rs_cargo_funcion;
            rs_cargo_funcion = DB_Empleados.sqlExecute(consulta);
            return true;                       
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }    
    /*Listar*/
    public ResultSet Listar_CargoFuncion(){
            try {
           DB_Empleados.sqlExecute();           
            String consulta = "SELECT * FROM emp_t_cargos_funciones";
            ResultSet rs_cf;
            rs_cf = DB_Empleados.sqlExecute(consulta);                   
        return DB_Empleados.sqlExecute(consulta);
            } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    /*Eliminar en Cargo_Funcion en base al Cargo*/    
    public boolean Eliminar_CargosFunciones(){
           try {
           DB_Empleados.sqlExecute();
            String consulta = "DELETE FROM emp_t_cargos_funciones WHERE id_cargo='"+id_cargo+"';";
            ResultSet rs_cargo_funciones;
            rs_cargo_funciones = DB_Empleados.sqlExecute(consulta);
            return true;                       
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }   
    }
    
    /*Eliminar en Cargo_Funcion en base a la Funcion*/
    public boolean Eliminar_CargoFunciones2(){
        try{
            DB_Empleados.sqlExecute();
            String consulta = "DELETE FROM emp_t_cargos_funciones WHERE id_funcion='"+id_funcion+"';";
            ResultSet rs_cargo_funciones;
            rs_cargo_funciones = DB_Empleados.sqlExecute(consulta);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
   
    public ResultSet BuscaCargoFuncion (String ValorBuscado, String CampoBuscado, Boolean BusquedaParcial){
       /*Consulta -> 
        TipoBusqueda->*/ 
       String Consulta, TipoBusqueda;
       String Busqueda = " LIKE ";
       if (BusquedaParcial == true){
           TipoBusqueda = "%";
       }else{
           TipoBusqueda = "";
       }
       Consulta = "SELECT * FROM emp_t_cargos_funciones WHERE "+CampoBuscado+Busqueda+"'"+ValorBuscado+TipoBusqueda+"';";
        ResultSet Resultado;
        //System.out.println(""+Consulta);
        try {
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
     * @return the id_funcion
     */
    public String getId_funcion() {
        return id_funcion;
    }

    /**
     * @param id_funcion the id_funcion to set
     */
    public void setId_funcion(String id_funcion) {
        this.id_funcion = id_funcion;
    }
   
    
    
}
