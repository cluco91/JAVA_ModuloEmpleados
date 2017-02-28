
package Logica;

import Datos.Conexion.CCR;
import Datos.Conexion.Cargo;
import Datos.Conexion.Cargo_Funcion;
import Datos.Conexion.Funcion;
import java.sql.ResultSet;
import java.sql.SQLException;

/*La clase Controladora de Operaciones Basicas*/

public class Cont_OB_v2 {
    
    static Cargo C = new Cargo();
    static Funcion F = new Funcion();
    static Cargo_Funcion CF = new Cargo_Funcion();
    static CCR ComRC = new CCR();
    
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
    public ResultSet Buscar_C (String VB, String CB, boolean BP) throws SQLException{ 
        try {
        return C.BuscaCargo(VB, CB, BP);        
        } catch (Exception e) {
        }
        return null;
    }
    public boolean Existe_C (String VB, String CB) throws SQLException{ 
          ResultSet rs_c;
          rs_c = Buscar_C(VB, CB, false);
        if (rs_c == null){
            return false;
        }else{
            return true;
        }
    }   
    /*Metodo de Buscar Cargo_Funcion*/
    public ResultSet Buscar_CF (String VB, String CB, boolean BP) throws SQLException{ 
        try {
        return CF.BuscaCargoFuncion(VB, CB, BP);   
        } catch (Exception e) {
        }
        return null;
    }  
    public boolean Existe_CF (String VB, String CB) throws SQLException{ 
          ResultSet rs_cf;
          rs_cf = Buscar_CF(VB, CB, false);
        if (rs_cf == null){
            return false;
        }else{
            return true;
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
    public ResultSet Buscar_F (String VB, String CB, boolean BP) throws SQLException{

        try {
            return F.BuscaFuncion(VB, CB, BP);        
        } catch (Exception e) {
         return null;
        }
    }
     public boolean Existe_F (String VB, String CB) throws SQLException{ 
          ResultSet rs_f;
          rs_f = Buscar_F(VB, CB, false);
        if (rs_f == null){
            return false;
        }else{
            return true;
        }
    }
     /*Metodo de Buscar Cargo 2*/
       public ResultSet Buscar_C2 (String VB) throws SQLException{

        try {
            return C.BuscarCargo_2(VB);        
        } catch (Exception e) {
        return null;
        }
    }
     public boolean Existe_C2 (String VB) throws SQLException{ 
          ResultSet rs_c;
          rs_c = Buscar_C2(VB);
        if (rs_c == null){
            return false;
        }else{
            return true;
        }
    }
     /*Metodo para Listar Cargos*/
     public ResultSet Listar_C (){
         try {
            return C.Listar_Cargos();
        } catch (Exception e) {
            return null;
        }
     }
     /*Metodo para ver si existe cargos al listar*/
     public boolean Existe_LC () throws SQLException{ 
          ResultSet rs_c;
          rs_c = Listar_C();
        if (rs_c == null){
            return false;
        }else{
            return true;
        }
    }  
     /*Metodo para Listar Cargos y Funciones*/
     public ResultSet Listar_CF (){
         try {
            return CF.Listar_CargoFuncion();
        } catch (Exception e) {
            return null;
        }
     }
     /*Metodo para ver si existe Cargos y Funciones al listar*/
     public boolean Existe_LCF () throws SQLException{ 
          ResultSet rs_cf;
          rs_cf = Listar_CF();
        if (rs_cf == null){
            return false;
        }else{
            return true;
        }
    }
    /*Metodo para Listar Funciones*/
     public ResultSet Listar_Funciones (){
         try {
             return F.Listar_Funciones();
        } catch (Exception e) {
            return null;
        }
     }
     /*Metodo para ver si existe Cargos y Funciones al listar*/
     public boolean Existe_LF () throws SQLException{ 
          ResultSet rs_f;
          rs_f = Listar_Funciones();
        if (rs_f == null){
            return false;
        }else{
            return true;
        }
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
    /*Metodo de Buscar CCR*/
    public ResultSet Buscar_CCR (String VB) throws SQLException{
        try {
            return ComRC.Buscar_CCR(VB);
        } catch (Exception e) {
        return null;
        }
    }  
     public boolean Existe_CCR (String VB) throws SQLException{ 
          ResultSet rs_ccr;
          rs_ccr = Buscar_CCR(VB);
        if (rs_ccr == null){
            return false;
        }else{
            return true;
        }
    }     
     /*Metodo para Listar CCR*/
     /*Metodo para Listar Cargos 2*/
     public ResultSet Listar_CCR (){
         try {
             return ComRC.Listar_CCR();
        } catch (Exception e) {
            return null;
        }
     }
     /*Metodo */
     public boolean Existe_LCCR () throws SQLException{ 
          ResultSet rs_ccr;
          rs_ccr = Listar_CCR();
        if (rs_ccr == null){
            return false;
        }else{
            return true;
        }
    }   
}