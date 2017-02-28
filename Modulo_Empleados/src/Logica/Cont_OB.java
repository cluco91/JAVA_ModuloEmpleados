
package Logica;

import Datos.Conexion.Cargo;
import Datos.Conexion.Cargo_Funcion;
import Datos.Conexion.Funcion;
import java.sql.ResultSet;
import java.sql.SQLException;

/*La clase Controladora de Operaciones Basicas*/

public class Cont_OB {
    
    static Cargo C = new Cargo();
    static Funcion F = new Funcion();
    static Cargo_Funcion CF = new Cargo_Funcion();
    
    /*Metodo de Insertar Cargo*/
    public  boolean Insertar_C (String IDC, String NC){
        /*Setear Variables*/
        C.setId_cargo(IDC);
        C.setNombre_cargo(NC);
        /*Condicion para insertar Cargo*/
        if (C.Insertar_Cargos() == true){
            return true;
        }else{
            return false;
        }
    }
    /*Metodo de Insertar Funcion*/
    public  boolean Insertar_F (String IDF, String NF){
        /*Setear Variables*/
        F.setId_funcion(IDF);
        F.setNombre_funcion(NF);
        /*Condicion para insertar Funcion*/
        if (F.Insertar_Funciones() == true){
            return true;
        }else{
            return false;
        }
    }
    /*Metodo de Insertar Cargo y Funcion*/
    public  boolean Insertar_CF (String IDC, String IDF){
        /*Setear Variables*/
        CF.setId_cargo(IDC);
        CF.setId_funcion(IDF);
        /*Condicion para insertat Cargo y Funcion*/
        if (CF.Insertar_CargoFuncion() == true){
            return true;
        }else{
            return false;
        }
    }
    
    /*Metodo de Buscar Cargo*/
    public  void Buscar_C (String VB, String CB, boolean BP) throws SQLException{
        ResultSet rs_c; 
        if(C.BuscaCargo(VB, CB, BP) == null){
    System.out.println("No existe esa informacion");
    }else{                                   
    rs_c = C.BuscaCargo(VB, CB, BP);
    while (rs_c.next()) {                                
    System.out.print(" ID_CARGO: " + rs_c.getString("id_cargo"));
    System.out.print(" -- ");
    System.out.print(" NOMBRE_CARGO: " + rs_c.getString("nombre_cargo"));
    System.out.println();
      } 
    }
    }
    /*Metodo para Borrar Cargo*/
    public  boolean Borrar_C (String IDC){
        C.setId_cargo(IDC);
        if (C.Eliminar_Cargos() == true){
            return true;
        }else{
            return false;
        }
    }
    
    /*Metodo para Borrar Funcion*/
    public  boolean Borrar_F (String IDF){
        F.setId_funcion(IDF);
        if (F.Eliminar_Funciones() == true){
            return true;
        }else{
            return false;
        }
    }
    
    /*Metodo para Borrar Cargo_Funcion en base al Cargo*/
    public  boolean Borrar_CF (String IDC){
        CF.setId_cargo(IDC);
        if (CF.Eliminar_CargosFunciones() == true){
            return true;
        }else{
            return false;
        }
    }
    /*Metodo para Borrar Cargo_Funcion en base a la Funcion*/
    public  boolean Borrar_CF2 (String IDF){
        CF.setId_funcion(IDF);
        if (CF.Eliminar_CargoFunciones2() == true){
            return true;
        }else{
            return false;
        }
    }
    
    /*Metodo de Buscar Funcion*/
    public  void Buscar_F (String VB, String CB, boolean BP) throws SQLException{
        ResultSet rs_f;
        if (F.BuscaFuncion(VB, CB, BP) == null){
            System.out.print("No existe esa informacion");
        }else{
            rs_f = F.BuscaFuncion(VB, CB, BP);
            while (rs_f.next()) {
                System.out.print("ID_FUNCION: " +rs_f.getString("id_funcion") + " -- " );
                System.out.print("NOMBRE_FUNCION: " +rs_f.getString("nombre_funcion"));
                System.out.println();
            }
        }
    }
    
    /*Metodo de Listar Cargos*/
    public  void Listar_Cargos(){
        C.Listar_Cargos();
    }
    /*Metodo de Listar Funciones*/
    public  void Listar_Funciones(){
        F.Listar_Funciones();
    }
    /*Metodo de Listar Cargos y Funciones*/
    public  void Listar_Cargos_Funciones(){
        CF.Listar_CargoFuncion();
    }
    /*Metodo de Editar el Cargo*/
    public  boolean Editar_Cargo(String IDC, String Campo, String Valor){
        C.setId_cargo(IDC);
        if (C.Actualizar_Cargos(Campo, Valor) == true){
            return true;
        }else{
            return false;
        }
    }
    /*Metodo de Editar la Funcion*/
    public  boolean Editar_Funcion(String IDF, String Campo, String Valor){
        F.setId_funcion(IDF);
        if (F.Actualizar_Funciones(Campo, Valor) == true){
            return true;
        }else{
            return false;
        }
    }
    
}
