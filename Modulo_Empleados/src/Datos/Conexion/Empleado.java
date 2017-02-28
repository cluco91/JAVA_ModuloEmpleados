package Datos.Conexion;

import static Datos.Conexion.modConexionDB.DB_Empleados;
import java.sql.ResultSet;

public class Empleado {
    
    /*Atributos de Empleado*/
    private String id_empleado;
    private String nombre_1;
    private String nombre_2;
    private String apellido_1;
    private String apellido_2;
    private String id_cargo;
    private String id_comuna;
    private String id_ciudad;
    private String id_region;
    
    /*Metodos*/
    public boolean Insertar_Empleados(){
        try {
           DB_Empleados.sqlExecute();
            String consulta = "INSERT INTO emp_t_empleados (id_empleado,nombre_1,nombre_2,apellido_1,apellido_2,id_cargo,id_comuna,id_ciudad,id_region) VALUES ('"+id_empleado+"','"+nombre_1+"','"+nombre_2+"','"+apellido_1+"','"+apellido_2+"','"+id_cargo+"','"+id_comuna+"','"+id_ciudad+"','"+id_region+"');"; //
            ResultSet rs_empleados;
            rs_empleados = DB_Empleados.sqlExecute(consulta);
            return true;                       
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }    
    /*Listar*/
    public ResultSet Listar_Empleados(){
            try {
           DB_Empleados.sqlExecute();           
            String consulta = "SELECT * FROM emp_t_empleados";
            ResultSet rs_e;
            rs_e = DB_Empleados.sqlExecute(consulta);                   
        return DB_Empleados.sqlExecute(consulta);
            } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    
    /*ELIMINAR*/
    public boolean Eliminar_Empleados(){
           try {
           DB_Empleados.sqlExecute();
            String consulta = "DELETE FROM emp_t_empleados WHERE id_empleado='"+id_empleado+"';";
            ResultSet rs_empleados;
            rs_empleados = DB_Empleados.sqlExecute(consulta);
            return true;                       
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }   
    }
    /*ELIMINAR 2*/
    public boolean Eliminar_Empleados2(){
        try{
            DB_Empleados.sqlExecute();
            String consulta = "DELETE FROM emp_t_empleados WHERE id_cargo='"+id_cargo+"';";
            ResultSet rs_empleados;
            rs_empleados = DB_Empleados.sqlExecute(consulta);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    /*ACTUALIZAR*/
    public boolean Actualizar_Empleados(String Campo, String Valor){
           try {
           DB_Empleados.sqlExecute();     
           /*A modo de ejemplo modificar nombre_1, no es demasiado practico modificar el primer nombre*/
            String consulta = "UPDATE emp_t_empleados SET "+Campo+"='"+Valor+"' WHERE id_empleado='"+id_empleado+"';";
            ResultSet rs_empleados;
            rs_empleados = DB_Empleados.sqlExecute(consulta);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    /*ACTUALIZAR 2*/
    public boolean Actualizar_Empleados2(){
           try {
           DB_Empleados.sqlExecute();     
            String consulta = "UPDATE emp_t_empleados SET nombre_1 = '"+nombre_1+"', nombre_2 = '"+nombre_2+"', apellido_1 = '"+apellido_1+"', apellido_2 = '"+apellido_2+"'"
            + ",id_cargo = '"+id_cargo+"', id_comuna = '"+id_comuna+"', id_ciudad = '"+id_ciudad+"', id_region = '"+id_region+"' "
            + "WHERE id_empleado = '"+id_empleado+"'";
            
            ResultSet rs_empleados;
            rs_empleados = DB_Empleados.sqlExecute(consulta);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public ResultSet BuscaEmpleado (String ValorBuscado, String CampoBuscado, Boolean BusquedaParcial){
       /*Consulta -> 
        TipoBusqueda->*/ 
       String Consulta, TipoBusqueda;
       String Busqueda = " LIKE ";
       if (BusquedaParcial == true){
           TipoBusqueda = "%";
       }else{
           TipoBusqueda = "";
       }
       Consulta = "SELECT * FROM emp_t_empleados WHERE "+CampoBuscado+Busqueda+"'"+ValorBuscado+TipoBusqueda+"';";
        ResultSet Resultado;
        //System.out.println(""+Consulta);
        try {
            return DB_Empleados.sqlExecute(Consulta);
        }catch(Exception e){
            
            return null;
        }
    }
    /*Set() y Get()*/
    public String getId_empleado() {
        return id_empleado;
    }

    /**
     * @param id_empleado the id_empleado to set
     */
    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }

    /**
     * @return the nombre_1
     */
    public String getNombre_1() {
        return nombre_1;
    }

    /**
     * @param nombre_1 the nombre_1 to set
     */
    public void setNombre_1(String nombre_1) {
        this.nombre_1 = nombre_1;
    }

    /**
     * @return the nombre_2
     */
    public String getNombre_2() {
        return nombre_2;
    }

    /**
     * @param nombre_2 the nombre_2 to set
     */
    public void setNombre_2(String nombre_2) {
        this.nombre_2 = nombre_2;
    }

    /**
     * @return the apellido_1
     */
    public String getApellido_1() {
        return apellido_1;
    }

    /**
     * @param apellido_1 the apellido_1 to set
     */
    public void setApellido_1(String apellido_1) {
        this.apellido_1 = apellido_1;
    }

    /**
     * @return the apellido_2
     */
    public String getApellido_2() {
        return apellido_2;
    }

    /**
     * @param apellido_2 the apellido_2 to set
     */
    public void setApellido_2(String apellido_2) {
        this.apellido_2 = apellido_2;
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
}