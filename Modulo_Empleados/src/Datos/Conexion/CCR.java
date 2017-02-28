
package Datos.Conexion;

import static Datos.Conexion.modConexionDB.DB_Empleados;
import java.sql.ResultSet;

public class CCR {

    /*Atributos*/
    private String id_comuna;
    private String nombre_comuna;
    private String id_ciudad;
    private String nombre_ciudad;
    private String id_region;
    private String nombre_region;
    
    /*Metodos*/
    public ResultSet Buscar_CCR (String ValorBuscado){
        String Consulta;
        ValorBuscado = ValorBuscado + "%";
        Consulta = "SELECT sys_t_comunas.id_comuna,sys_t_comunas.nombre_comuna,sys_t_ciudades.id_ciudad,sys_t_ciudades.nombre_ciudad,sys_t_regiones.id_region,sys_t_regiones.nombre_region \n" +
        "FROM sys_t_comunas INNER JOIN sys_t_ciudades on sys_t_ciudades.id_ciudad = sys_t_comunas.id_ciudad INNER JOIN "
        + "sys_t_regiones ON sys_t_regiones.id_region = sys_t_comunas.id_region WHERE sys_t_comunas.id_comuna LIKE '"+ValorBuscado+"' OR sys_t_comunas.nombre_comuna LIKE '"+ValorBuscado+"' OR sys_t_comunas.id_ciudad LIKE '"+ValorBuscado+"' "
        + "OR sys_t_ciudades.nombre_ciudad LIKE '"+ValorBuscado+"' OR sys_t_comunas.id_region LIKE '"+ValorBuscado+"' OR sys_t_regiones.nombre_region LIKE '"+ValorBuscado+"'";
        
        try{
            return DB_Empleados.sqlExecute(Consulta);
        }catch(Exception e){
            return null;
        }
    }
    
    /*Listar*/
    public ResultSet Listar_CCR(){
            try {
           DB_Empleados.sqlExecute();           
            String consulta ="SELECT sys_t_comunas.id_comuna,sys_t_comunas.nombre_comuna,sys_t_ciudades.id_ciudad,sys_t_ciudades.nombre_ciudad,sys_t_regiones.id_region,sys_t_regiones.nombre_region \n" +
            "FROM sys_t_ciudades, sys_t_regiones, sys_t_comunas WHERE sys_t_comunas.id_ciudad = sys_t_ciudades.id_ciudad AND sys_t_comunas.id_region = sys_t_regiones.id_region ";
            ResultSet rs_ccr;
            rs_ccr = DB_Empleados.sqlExecute(consulta);                   
        return DB_Empleados.sqlExecute(consulta);
            } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    /**
     * @return the id_comuna
     */
    public String getId_comuna() {
        return id_comuna;
    }

    /**
     * @param id_comuna the id_comuna to set
     */
    public void setId_comuna(String id_comuna) {
        this.id_comuna = id_comuna;
    }

    /**
     * @return the nombre_comuna
     */
    public String getNombre_comuna() {
        return nombre_comuna;
    }

    /**
     * @param nombre_comuna the nombre_comuna to set
     */
    public void setNombre_comuna(String nombre_comuna) {
        this.nombre_comuna = nombre_comuna;
    }

    /**
     * @return the id_ciudad
     */
    public String getId_ciudad() {
        return id_ciudad;
    }

    /**
     * @param id_ciudad the id_ciudad to set
     */
    public void setId_ciudad(String id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    /**
     * @return the nombre_ciudad
     */
    public String getNombre_ciudad() {
        return nombre_ciudad;
    }

    /**
     * @param nombre_ciudad the nombre_ciudad to set
     */
    public void setNombre_ciudad(String nombre_ciudad) {
        this.nombre_ciudad = nombre_ciudad;
    }

    /**
     * @return the id_region
     */
    public String getId_region() {
        return id_region;
    }

    /**
     * @param id_region the id_region to set
     */
    public void setId_region(String id_region) {
        this.id_region = id_region;
    }

    /**
     * @return the nombre_region
     */
    public String getNombre_region() {
        return nombre_region;
    }

    /**
     * @param nombre_region the nombre_region to set
     */
    public void setNombre_region(String nombre_region) {
        this.nombre_region = nombre_region;
    }
    
    
    
}
