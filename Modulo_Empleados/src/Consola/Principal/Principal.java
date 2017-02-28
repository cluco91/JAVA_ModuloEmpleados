
package Consola.Principal;

import Datos.Conexion.modConexionDB;
import Consola.Principal.Menu;
import java.sql.SQLException;
public class Principal {

    public static void main(String[] args) throws SQLException {
        modConexionDB.conexionDB(); 
        Menu.menu_inicia();
    }
  
}
