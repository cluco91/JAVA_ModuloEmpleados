
package Logica;

import Datos.Conexion.Cargo;
import Datos.Conexion.Empleado;
import java.sql.ResultSet;
import java.sql.SQLException;

/*La clase Controladora de Empleados*/
public class Cont_Emp {
    
    /*Variable Global Estatica Empleado*/
    static Empleado E = new Empleado();
    
    /*Metodo de Insertar Empleados*/
    
    public  boolean Insertar_Emp(String IDE, String N1, String N2, String AP1, String AP2, String IDC, String IDCOM, String IDCD, String IDREG){
        /*Setear los valores correspondientes del empleado E*/
        E.setId_empleado(IDE);
        E.setNombre_1(N1);
        E.setNombre_2(N2);
        E.setApellido_1(AP1);
        E.setApellido_2(AP2);
        E.setId_cargo(IDC);
        E.setId_comuna(IDCOM);
        E.setId_ciudad(IDCD);
        E.setId_region(IDREG);
        /*La condicion para insertar el Empleado*/
        if (E.Insertar_Empleados() == true){
            return true;
        }else{
            return false;
        }
    }
    
    /*Metodo de Borrar Empleados*/
    public  boolean Borrar_Emp(String IDE){
        /*Setear el ID del empleado E*/
        E.setId_empleado(IDE);
        /*La condicion para eliminar el Empleado*/
        if (E.Eliminar_Empleados() == true){
            return true;
        }else{
            return false;
        }
    }
    
    /*Metodo de Borrar Empleados en Funcion del Cargo*/
    public  boolean Borrar_Emp2(String IDC){
        E.setId_cargo(IDC);
        if (E.Eliminar_Empleados2() == true){
            return true;
        }else{
            return false;
        }
    }
    
    /*Metodo de Listar Empleados*/
     public ResultSet Listar_Emp (){
         try {
             return E.Listar_Empleados();
        } catch (Exception e) {
            return null;
        }
     }
     /*Metodo para ver si existe cargos al listar*/
     public boolean Existe_Emp () throws SQLException{ 
          ResultSet rs_emp;
          rs_emp = Listar_Emp();
        if (rs_emp == null){
            return false;
        }else{
            return true;
        }
    }
/*Metodo de Buscar Empleados*/   
    public ResultSet Buscar_E (String VB, String CB, boolean BP) throws SQLException{ 
        try {
            return E.BuscaEmpleado(VB, CB, BP);   
        } catch (Exception e) {
        }
        return null;
         
        
    }
    
    public boolean Existe_E (String VB, String CB) throws SQLException{ 
          ResultSet rs_e;
          rs_e = Buscar_E(VB, CB, false);
        if (rs_e == null){
            return false;
        }else{
            return true;
        }
    }
        
    /*Metodo de Editar Empleados*/
        public  boolean Editar_Emp(String IDE, String Campo, String Valor){
        /*Setear el ID del Empleado*/
        E.setId_empleado(IDE);
        /*La condicion para actualizar el empleado*/
        if (E.Actualizar_Empleados(Campo,Valor) == true){
            return true;
        }else{
            return false;
        }
    }
        
        /*Metodo de Editar Empleados 2*/
        
        public boolean Editar_Emp2(String IDE, String N1, String N2, String AP1, String AP2, String IDC, String IDCOM, String IDCIUD, String IDREG){            
        /*Setear el ID del Empleado*/
        E.setId_empleado(IDE);
        /*Setear el Nombre 1 del Empleado */
        E.setNombre_1(N1);
        /*Setear el Nombre 2 del Empleado*/
        E.setNombre_2(N2);
        /*Setear el Apellido 1 del Empleado*/
        E.setApellido_1(AP1);
        /*Setear el Apellido 2 del Empleado*/
        E.setApellido_2(AP2);
        /*Setear el ID del Cargo del Empleado*/
        E.setId_cargo(IDC);
        /*Setear el ID de la Comuna del Empleado*/
        E.setId_comuna(IDCOM);
        /*Setear el ID de la Ciudad del Empleado*/
        E.setId_ciudad(IDCIUD);
        /*Setear el ID de la Region del Empleado*/
        E.setId_region(IDREG);
        /*La condicion para actualizar el empleado*/
        if (E.Actualizar_Empleados2() == true){
            return true;
        }else{
            return false;
        }
        }
    
}
