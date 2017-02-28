
package Consola.Principal;

import Logica.Cont_Emp;
import Logica.Cont_OB;
import Logica.Cont_OB_v2;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {    
   /*Variable Global estatica del Scanner*/
    static Scanner leer = new Scanner (System.in);
    static Cont_OB_v2 COB = new Cont_OB_v2();
    static Cont_Emp CEMP = new Cont_Emp();    
     /*Metodo de Inicio del Menu*/
    public static void menu_inicia() throws SQLException{
       int opcion = 0;         /*La opcion del Menu*/ 
       /*El Ciclo del Menu Principal que llama al metodo Menu_Principal y espera una opcion de Menu*/
       while (opcion != 7){
           Menu_Principal();
              opcion = leer.nextInt();
            Opciones_MP (opcion);
            }
        }
    /*Metodo del String del Menu Principal*/
       public static void Menu_Principal(){   
       System.out.println("-------------MODULO EMPLEADOS-------------");
       System.out.println("1.-Operaciones Basicas");
       System.out.println("2.-Buscar Empleado");
       System.out.println("3.-Nuevo Empleado");
       System.out.println("4.-Editar Empleado");
       System.out.println("5.-Eliminar Empleado");
       System.out.println("6.-Listar Empleados");
       System.out.println("7.-Salir");
       System.out.println("-------------------------------------------");
       System.out.print("Seleccione una opcion: ");
    }      
    /*Metodo de Opciones del Menu Principal*/   
       public static void Opciones_MP(int opcion) throws SQLException{
           switch(opcion){
               case 1:while(opcion != 13){Menu_OB();opcion = leer.nextInt(); Opciones_OB(opcion);}break;
               case 2:Buscar_Empleados(opcion);break;
               case 3:Insertar_Empleados();break;
               case 4:Editar_Empleados(opcion);break;
               case 5:Eliminar_Empleados();break;
               case 6:Listar_Empleados();break;
               case 7:System.out.println("Fin de Programa");break;                   
            }
        }
       /*Metodo del String del Menu de Operaciones Basicas*/
       public static void Menu_OB(){
       System.out.println("-------------OPERACIONES BASICAS-------------");
       System.out.println("-------------Seleccione una Opcion-------------");
       System.out.println("1.-Insertar Cargo");
       System.out.println("2.-Insertar Funcion");
       System.out.println("3.-Insertar cargo y funcion");
       System.out.println("4.-Editar Cargo");
       System.out.println("5.-Editar Funcion");
       System.out.println("6.-Buscar Cargo");
       System.out.println("7.-Buscar Funcion");
       System.out.println("8.-Borrar Cargo");
       System.out.println("9.-Borrar Funcion");
       System.out.println("10.-Listar Cargos");
       System.out.println("11.-Listar Funciones");
       System.out.println("12.-Listar Cargos con Funciones");
       System.out.println("13.-Devolverse");
       System.out.println("-------------------------------------------");
       System.out.print("Seleccione una opcion: ");
        }     
       /*Metodo de Opciones del Menu Operaciones Basicas*/       
       public static void Opciones_OB(int opcion) throws SQLException{
           switch(opcion){
               case 1:Insertar_Cargo();break;
               case 2:Insertar_Funcion();break;
               case 3:Insertar_Cargo_Funcion();break;
               case 4:Editar_Cargo(opcion);break;
               case 5:Editar_Funcion(opcion);break;
               case 6:Buscar_Cargo(opcion);break;
               case 7:Buscar_Funcion(opcion);break; 
               case 8:Borrar_Cargo(opcion);break; 
               case 9:Borrar_Funcion(opcion);break;    
               case 10:Listar_Cargos();break; 
               case 11:Listar_Funciones();break; 
               case 12:Listar_CargFun();break;     
               case 13:System.out.println("Devolviendo a Menu Principal");break;     
       }
      }       
       /*######################OPERACIONES BASICAS################*/
       /*Metodo para Insertar Cargo*/
       public static void Insertar_Cargo(){
           System.out.print("Ingrese el ID del Cargo: ");
           String IDC = leer.next();
           System.out.print("Ingrese el Nombre del Cargo: ");
           String NC = leer.next();           
           if (COB.Insertar_C(IDC, NC) == true){
               System.out.println("El Cargo ha sido ingresado con exito");
           }else{
               System.out.println("No ha sido posible ingresar el Cargo");
           }           
       }

       /*Metodo para Insertar Funcion*/
       public static void Insertar_Funcion(){
           System.out.print("Ingrese el ID de la Funcion: ");
           String IDF = leer.next();
           System.out.print("Ingrese el Nombre de la Funcion: ");
           String NF = leer.next();           
           if (COB.Insertar_F(IDF, NF) == true){
               System.out.println("La Funcion ha sido ingresada con exito");
           }else{
               System.out.println("No ha sido posible ingresar la Funcion");
           }
       }
       
       /*Metodo para Ingresar Cargo y Funcion*/
       public static void Insertar_Cargo_Funcion(){
           System.out.print("Ingrese el ID del Cargo: ");
           String IDC = leer.next();
           System.out.print("Ingrese el ID de la Funcion: ");
           String IDF = leer.next();           
           if (COB.Insertar_CF(IDC, IDF) == true){
               System.out.println("El Cargo y la Funcion han sido asociados con exito");
           }else{
               System.out.println("No ha sido posible asociar el Cargo con la Funcion");
           }
       }       

       /*Metodo para Editar el Cargo*/
       public static void Editar_Cargo(int opcion){
           while (opcion!=2){
               System.out.println("--------Seleccione Campo a Editar----------");               
               System.out.println("1)Nombre de Cargo");
               System.out.println("2)Devolverse");
               System.out.println("-------------------------------------------");
               System.out.print("Ingrese Opcion: ");
               opcion = leer.nextInt();
               switch(opcion){
                   case 1:
                       System.out.print("Ingrese el ID del Cargo a Editar: ");
                       String IDC = leer.next();
                       System.out.print("Ingrese el nuevo Nombre del Cargo: ");
                       String NC = leer.next();
                       if (COB.Editar_Cargo(IDC, "nombre_cargo", NC) == true){
                           System.out.println("El Cargo se ha editado con Exito!");
                       }else{
                           System.out.println("No ha sido posible editar el Cargo!");
                       }                           
                       break;
                   case 2:
                       limpiar(5);
                       break;
               }
           }
      }       
       /*Metodo para Editar la Funcion*/
       public static void Editar_Funcion(int opcion){
           while (opcion != 2){
               System.out.println("--------Seleccione Campo a Editar----------");               
               System.out.println("1)Nombre de Cargo");
               System.out.println("2)Devolverse");
               System.out.println("-------------------------------------------");
               System.out.print("Ingrese Opcion: ");
               opcion = leer.nextInt();
               switch(opcion){
                   case 1:
                   System.out.print("Ingrese el ID de la Funcion a Editar: ");
                   String IDF = leer.next();
                   System.out.print("Ingrese el nuevo Nombre de la Funcion: ");
                   String NF = leer.next();
                   if (COB.Editar_Funcion(IDF,"nombre_funcion", NF) == true){
                       System.out.println("La Funcion se ha editado con Exito!");
                   }else{
                       System.out.println("No ha sido posible editar la Funcion!");
                   }
                   break;
               }      
           }
       }       
       /*Metodo para Borrar el Cargo*/
       public static void Borrar_Cargo(int opcion){
           Cont_OB_v2 COB = new Cont_OB_v2();
           System.out.print("Ingrese el ID del Cargo a Borrar: ");
           String IDC = leer.next();
           if (COB.Borrar_C(IDC) == true){
               System.out.println("El cargo se ha borrado con Exito!");
           }else{
               System.out.println("No ha sido posible borrar el Cargo");
               System.out.println("Puede ser debido a que este asociado a algun Empleado y/o Funcion");
               Borrar_Cargo2(opcion,IDC);
           }
       }
       /*Metodo para Borrar el Cargo Si es que esta asociado a algun empleado y/o funcion*/
       public static void Borrar_Cargo2(int opcion, String IDC){
           while (opcion != 2){
               System.out.println("--------¿Qué desea Hacer?--------");
               System.out.println("1)Borrar el Cargo asociado a Empleado y/o Funcion");
               System.out.println("2)Devolverse");
               System.out.println("---------------------------------");
               System.out.print("Ingrese Opcion: ");
               opcion = leer.nextInt();
               switch(opcion){
                   case 1:
                      if (CEMP.Borrar_Emp2(IDC) == true && COB.Borrar_CF(IDC) == true && COB.Borrar_C(IDC) == true){
                          System.out.println("El Cargo se ha eliminado con Exito!");
                      }else{
                          System.out.println("No ha sido posible eliminar el Cargo!");
                      }
                   break;
                   case 2:
                   limpiar(5);   
                   break;
               }
           }
       }
       /*Metodo para Borrar la Funcion*/
       public static void Borrar_Funcion(int opcion){
           System.out.print("Ingrese el ID de la Funcion a Borrar: ");
           String IDF = leer.next();
           if (COB.Borrar_F(IDF) == true){
               System.out.println("La Funcion se ha borrado con Exito!");
           }else{
               System.out.println("No ha sido posible borrar la Funcion");
               System.out.println("Puede ser debido a que este asociado a algun Cargo");
               Borrar_Funcion2(opcion, IDF);
           }
       }       
       /*Metodo para Borrar la Funcion Si es que esta asociado a algun Cargo*/
       public static void Borrar_Funcion2(int opcion, String IDF){   
           while (opcion != 2){
               System.out.println("--------¿Qué desea Hacer?--------");
               System.out.println("1)Borrar la Funcion asociada a Cargo");
               System.out.println("2)Devolverse");
               System.out.println("---------------------------------");
               System.out.print("Ingrese Opcion: ");
               opcion = leer.nextInt();
               switch(opcion){
                   case 1:
                   if(COB.Borrar_CF2(IDF) == true && COB.Borrar_F(IDF) == true){
                       System.out.println("La Funcion se ha eliminado con Exito!");
                   }else{
                       System.out.println("No ha sido posible eliminar la Funcion!");
                   }          
                   break;         
                   case 2:
                    limpiar(5);  
                   break;
               }    
           }
       }
      /*Metodo para Buscar Cargo*/
       public static void Buscar_Cargo(int opcion) throws SQLException{
           boolean BP = false; /*Busqueda Parcial*/
           while(opcion != 3){
                System.out.println("-------------MODO DE BUSQUEDA-------------");
                System.out.println("-------------Seleccione Tipo de Busqueda-------------");
                System.out.println("1.-BUSQUEDA COMPLETA");
                System.out.println("2.-BUSQUEDA PARCIAL");
                System.out.println("3.-DEVOLVERSE");                           
                System.out.println("---------------------------------------------");
                System.out.print("Ingrese Opcion:");
                opcion = leer.nextInt();  
                switch(opcion){
                    case 1:
                        BP = false;
                        Campo_Buscar_C(opcion,BP);
                        break;
                    case 2:
                        BP = true;
                        Campo_Buscar_C(opcion,BP);
                        break;
                    case 3:
                        limpiar(5);
                    break;
                }
           }
           
       }
       /*Metodo de Complemento para Buscar el Cargo*/
       public static void Campo_Buscar_C(int opcion, boolean BP) throws SQLException{
           String CB = ""; /*Campo Buscado*/
           String VB = ""; /*Valor Buscado*/
           ResultSet RS;
           while (opcion!=3){
               System.out.println("--------------Seleccione Campo a Buscar------------------");
               System.out.println("1)ID del Cargo.");
               System.out.println("2)Nombre del Cargo.");
               System.out.println("3)Devolverse.");
               System.out.println("---------------------------------------------");
               System.out.print("Ingrese Opcion:");
               opcion = leer.nextInt();  
               switch (opcion){
                   case 1:
                       CB = "id_cargo";
                       System.out.print("Ingrese el ID de Cargo a Buscar: ");
                       VB = leer.next();
                       RS = COB.Buscar_C(VB, CB, BP);
                       while (RS.next()){
                         System.out.print("ID CARGO: " + RS.getString("id_cargo"));
                         System.out.print(" | ");
                         System.out.print("NOMBRE CARGO: " + RS.getString("nombre_cargo"));
                           limpiar(3);
                       }                                                                          
                   break;
                   case 2:
                      CB = "nombre_cargo";
                    System.out.print("Ingrese el Nombre de Cargo a Buscar: ");
                     VB = leer.next();
                     RS = COB.Buscar_C(VB, CB, BP);
                       while (RS.next()){
                         System.out.print("ID CARGO: " + RS.getString("id_cargo"));
                         System.out.print(" | ");
                         System.out.print("NOMBRE CARGO: " + RS.getString("nombre_cargo"));
                         limpiar(3);
                       }  
                  break;                     
                  case 3:
                   limpiar(5);
                  break;    
              }
           }
       }
     
       /*Metodo para Buscar Funcion*/
       public static void Buscar_Funcion(int opcion) throws SQLException {
       boolean BP = false; /*Busqueda Parcial*/    
       while(opcion != 3){
                System.out.println("-------------MODO DE BUSQUEDA-------------");
                System.out.println("-------------Seleccione Tipo de Busqueda-------------");
                System.out.println("1.-BUSQUEDA COMPLETA");
                System.out.println("2.-BUSQUEDA PARCIAL");
                System.out.println("3.-DEVOLVERSE");                           
                System.out.println("---------------------------------------------");
                System.out.print("Ingrese Opcion:");
                opcion = leer.nextInt();  
                switch(opcion){
                    case 1:
                        BP = false;                        
                        Campo_Buscar_F(opcion,BP);
                        break;
                    case 2:
                        BP = true;
                        Campo_Buscar_F(opcion,BP);
                        break;
                    case 3:
                    limpiar(5);   
                    break;
                }
           }    
       }
       /*Metodo de Complemento para Buscar la Funcion*/
        public static void Campo_Buscar_F(int opcion, boolean BP) throws SQLException{
           String CB = ""; /*Campo Buscado*/
           String VB = ""; /*Valor Buscado*/
           ResultSet RS;
           while (opcion!=3){
               System.out.println("--------------Seleccione Campo a Buscar------------------");
               System.out.println("1)ID de la Funcion.");
               System.out.println("2)Nombre de la Funcion.");
               System.out.println("3)Devolverse.");
               System.out.println("---------------------------------------------");
               System.out.print("Ingrese Opcion:");
               opcion = leer.nextInt();  
               switch (opcion){
                   case 1:
                       CB = "id_funcion";
                       System.out.print("Ingrese el ID de la Funcion a Buscar: ");
                       VB = leer.next();
                       RS = COB.Buscar_F(VB, CB, BP);
                       while (RS.next()){
                         System.out.print("ID FUNCION: " + RS.getString("id_funcion"));
                         System.out.print(" | ");
                         System.out.print("NOMBRE FUNCION: " + RS.getString("nombre_funcion"));
                         limpiar(3);
                       }  
                       
                   break;
                   case 2:
                       CB = "nombre_funcion";
                       System.out.print("Ingrese el Nombre de la Funcion a Buscar: ");
                       VB = leer.next();
                       RS = COB.Buscar_F(VB, CB, BP);
                       while (RS.next()){
                         System.out.print("ID FUNCION: " + RS.getString("id_funcion"));
                         System.out.print(" | ");
                         System.out.print("NOMBRE FUNCION: " + RS.getString("nombre_funcion"));
                         limpiar(3);
                       }  
                                              
                   break;                       
                   case 3:
                       limpiar(5);
                   break;    
               }
           }
       }
       /*Metodo para Listar los Cargos*/
       public static void Listar_Cargos() throws SQLException{
           ResultSet RS;
           RS = COB.Listar_C();           
           while (RS.next()){
                         System.out.print("ID CARGO: " + RS.getString("id_cargo"));
                         System.out.print(" | ");
                         System.out.print("NOMBRE CARGO: " + RS.getString("nombre_cargo"));
                         limpiar(3);
        }           
       }
       /*Metodo para Listar las Funciones*/
       public static void Listar_Funciones() throws SQLException{
           ResultSet RS;
           RS = COB.Listar_Funciones();
           while (RS.next()){
                         System.out.print("ID FUNCION: " + RS.getString("id_funcion"));
                         System.out.print(" | ");
                         System.out.print("NOMBRE FUNCION: " + RS.getString("nombre_funcion"));
                         limpiar(3);
        }                    
       }
       /*Metodo para Listar los Cargos y las Funciones*/
       public static void Listar_CargFun() throws SQLException{
        ResultSet RS;
           RS = COB.Listar_CF();
           while (RS.next()){
                 System.out.print("ID CARGO: " + RS.getString("id_cargo"));
                 System.out.print(" | ");
                 System.out.print("ID FUNCION: " + RS.getString("id_funcion"));
                 limpiar(3);
        }   
           
           
       }
       /*######################OPERACIONES BASICAS################*/
       
       /*######################EMPLEADOS#########################*/
       /*Insertar Empleados*/
      public static void Insertar_Empleados(){
           System.out.print("Ingrese el ID del Empleado: ");
           String IDE = leer.next();
           System.out.print("Ingrese el Primer Nombre del Empleado: ");
           String N1 = leer.next();
           System.out.print("Ingrese el Segundo Nombre del Empleado: ");
           String N2 = leer.next();
           System.out.print("Ingrese el Primer Apellido del Empleado: ");
           String AP1 = leer.next();
           System.out.print("Ingrese el Segundo Apellido del Empleado: ");
           String AP2 = leer.next();
           System.out.print("Ingrese el ID del Cargo del Empleado: ");
           String IDC = leer.next();
           System.out.print("Ingrese el ID de la Comuna donde vive el Empleado: ");
           String IDCOM = leer.next();
           System.out.print("Ingrese el ID de la Ciudad donde vive el Empleado: ");
           String IDCD = leer.next();
           System.out.print("Ingrese el ID de la Region donde vive el Empleado: ");
           String IDREG = leer.next();
           if (CEMP.Insertar_Emp(IDE, N1, N2, AP1, AP2, IDC, IDCOM, IDCD, IDREG) == true){
               System.out.println("El empleado se ha ingresado con Exito!");
           }else{
               System.out.println("No ha sido posible ingresar el Empleado!");                      
           }
       }
       /*Eliminar Empleados*/
       public static void Eliminar_Empleados(){
           System.out.print("Ingrese el ID del Empleado que desea Borrar: ");
           String IDE = leer.next();
           if (CEMP.Borrar_Emp(IDE) == true){
               System.out.println("El empleado se ha eliminado con Exito!"); 
           }else{
               System.out.println("No ha sido posible borrar el Empleado!");             
           }
       }
       /*Editar Empleados*/
       public static void Editar_Empleados(int opcion){
           String IDE,VALOR = "";
           while (opcion!=5){
               System.out.println("--------Seleccione Campo a Editar----------");               
               System.out.println("1)Primer Nombre de Empleado.");
               System.out.println("2)Segundo Nombre de Empleado.");
               System.out.println("3)Primer Apellido de Empleado.");
               System.out.println("4)Segundo Apellido de Empleado.");
               System.out.println("5)Devolverse");
               System.out.println("-------------------------------------------");
               System.out.print("Ingrese Opcion: ");
               opcion = leer.nextInt();
               switch(opcion){
                   case 1:
                       System.out.print("Ingrese el ID del Empleado a Editar: ");
                       IDE = leer.next();
                       System.out.print("Ingrese el Nuevo Primer Nombre del Empleado: ");
                       VALOR = leer.next();
                       if (CEMP.Editar_Emp(IDE, "nombre_1", VALOR) == true){
                           System.out.println("El Empleado se ha editado con Exito!");
                       }else{
                           System.out.println("No se ha podido editar el Empleado!");
                       }
                       break;
                   case 2:
                       System.out.print("Ingrese el ID del Empleado a Editar: ");
                       IDE = leer.next();
                       System.out.print("Ingrese el Nuevo Segundo Nombre del Empleado: ");
                       VALOR = leer.next();
                       if (CEMP.Editar_Emp(IDE,"nombre_2", VALOR) == true){
                           System.out.println("El Empleado se ha editado con Exito!");
                       }else{
                           System.out.println("No se ha podido editar el Empleado!");
                       }
                       break;
                   case 3:
                       System.out.print("Ingrese el ID del Empleado a Editar: ");
                       IDE = leer.next();
                       System.out.print("Ingrese el Nuevo Primer Apellido del Empleado: ");
                       VALOR = leer.next();
                       if (CEMP.Editar_Emp(IDE,"apellido_1", VALOR) == true){
                           System.out.println("El Empleado se ha editado con Exito!");
                       }else{
                           System.out.println("No se ha podido editar el Empleado!");
                       }
                       break;
                   case 4:
                       System.out.print("Ingrese el ID del Empleado a Editar: ");
                       IDE = leer.next();
                       System.out.print("Ingrese el Nuevo Segundo Apellido del Empleado: ");
                       VALOR = leer.next();
                       if (CEMP.Editar_Emp(IDE,"apellido_2", VALOR) == true){
                           System.out.println("El Empleado se ha editado con Exito!");
                       }else{
                           System.out.println("No se ha podido editar el Empleado!");
                       }
                       break;
                   case 5:
                       limpiar(5);
                       break;
               }
            }       
        }
       /*Listar Empleados*/
       public static void Listar_Empleados() throws SQLException{           
           ResultSet RS;
           RS = CEMP.Listar_Emp();
           while (RS.next()){
                 System.out.print("ID EMPLEADO: " + RS.getString("id_empleado"));
                 System.out.print(" | ");
                 System.out.print("NOMBRE 1: " + RS.getString("nombre_1"));
                 System.out.print(" | ");
                 System.out.print("NOMBRE 2: " + RS.getString("nombre_2"));
                 System.out.print(" | ");
                 System.out.print("APELLIDO 1: " + RS.getString("apellido_1"));
                 System.out.print(" | ");
                 System.out.print("APELLIDO 2: " + RS.getString("apellido_2"));
                 System.out.print(" | ");
                 System.out.print("ID CARGO: " + RS.getString("id_cargo"));
                 System.out.print(" | ");
                 System.out.print("ID COMUNA: " + RS.getString("id_comuna"));
                 System.out.print(" | ");
                 System.out.print("ID CIUDAD: " + RS.getString("id_ciudad"));
                 System.out.print(" | ");
                 System.out.print("ID REGION: " + RS.getString("id_region"));
                 limpiar(3);
        }  
            
      }
       /*Buscar Empleados*/
       public static void Buscar_Empleados(int opcion) throws SQLException{
           boolean BP = false; /*Busqueda Parcial*/    
       while(opcion != 3){
                System.out.println("-------------MODO DE BUSQUEDA-------------");
                System.out.println("-------------Seleccione Tipo de Busqueda-------------");
                System.out.println("1.-BUSQUEDA COMPLETA");
                System.out.println("2.-BUSQUEDA PARCIAL");
                System.out.println("3.-DEVOLVERSE");                           
                System.out.println("---------------------------------------------");
                System.out.println("Ingrese Opcion:");
                opcion = leer.nextInt();  
                switch(opcion){
                    case 1:
                        BP = false;
                        Campo_Buscar_E(opcion,BP);
                        break;
                    case 2:
                        BP = true;
                        Campo_Buscar_E(opcion,BP);
                        break;
                    case 3:
                    limpiar(5);    
                    break;
                }
           } 
           
       }
       
       /*Metodo Complementario de Buscar Empleados*/
       public static void Campo_Buscar_E(int opcion, boolean BP) throws SQLException{
           String CB = ""; /*Campo Buscado*/
           String VB = ""; /*Valor Buscado*/
           ResultSet RS;
           while (opcion!=6){
               System.out.println("--------------Seleccione Campo a Buscar------------------");
               System.out.println("1)ID del Empleado.");
               System.out.println("2)Primer Nombre del Empleado.");
               System.out.println("3)Segundo Nombre del Empleado.");
               System.out.println("4)Primer Apellido del Empleado.");
               System.out.println("5)Segundo Apellido del Empleado.");
               System.out.println("6)Devolverse.");               
               System.out.println("---------------------------------------------");
               System.out.println("Ingrese Opcion:");
               opcion = leer.nextInt();  
               switch (opcion){
                   case 1:
                       CB = "id_empleado";
                       System.out.print("Ingrese el ID del Empleado a Buscar: ");
                       VB = leer.next();
                       RS = CEMP.Buscar_E(VB, CB, BP);
                       while (RS.next()){
                        System.out.print("ID EMPLEADO: " + RS.getString("id_empleado"));
                        System.out.print(" | ");
                        System.out.print("NOMBRE 1: " + RS.getString("nombre_1"));
                        System.out.print(" | ");
                        System.out.print("NOMBRE 2: " + RS.getString("nombre_2"));
                        System.out.print(" | ");
                        System.out.print("APELLIDO 1: " + RS.getString("apellido_1"));
                        System.out.print(" | ");
                        System.out.print("APELLIDO 2: " + RS.getString("apellido_2"));
                        System.out.print(" | ");
                        System.out.print("ID CARGO: " + RS.getString("id_cargo"));
                        System.out.print(" | ");
                        System.out.print("ID COMUNA: " + RS.getString("id_comuna"));
                        System.out.print(" | ");
                        System.out.print("ID CIUDAD: " + RS.getString("id_ciudad"));
                        System.out.print(" | ");
                        System.out.print("ID REGION: " + RS.getString("id_region"));
                        limpiar(3);
                        }                                                
                   break;
                   case 2:
                       CB = "nombre_1";
                       System.out.print("Ingrese el Primer Nombre del Empleado a Buscar: ");
                       VB = leer.next();
                       RS = CEMP.Buscar_E(VB, CB, BP);
                       while (RS.next()){
                        System.out.print("ID EMPLEADO: " + RS.getString("id_empleado"));
                        System.out.print(" | ");
                        System.out.print("NOMBRE 1: " + RS.getString("nombre_1"));
                        System.out.print(" | ");
                        System.out.print("NOMBRE 2: " + RS.getString("nombre_2"));
                        System.out.print(" | ");
                        System.out.print("APELLIDO 1: " + RS.getString("apellido_1"));
                        System.out.print(" | ");
                        System.out.print("APELLIDO 2: " + RS.getString("apellido_2"));
                        System.out.print(" | ");
                        System.out.print("ID CARGO: " + RS.getString("id_cargo"));
                        System.out.print(" | ");
                        System.out.print("ID COMUNA: " + RS.getString("id_comuna"));
                        System.out.print(" | ");
                        System.out.print("ID CIUDAD: " + RS.getString("id_ciudad"));
                        System.out.print(" | ");
                        System.out.print("ID REGION: " + RS.getString("id_region"));
                        limpiar(3);
                        }                         
                   break;                       
                   case 3:
                       CB = "nombre_2";
                       System.out.print("Ingrese el Segundo Nombre del Empleado a Buscar: ");
                       VB = leer.next();                       
                       RS = CEMP.Buscar_E(VB, CB, BP);
                       while (RS.next()){
                        System.out.print("ID EMPLEADO: " + RS.getString("id_empleado"));
                        System.out.print(" | ");
                        System.out.print("NOMBRE 1: " + RS.getString("nombre_1"));
                        System.out.print(" | ");
                        System.out.print("NOMBRE 2: " + RS.getString("nombre_2"));
                        System.out.print(" | ");
                        System.out.print("APELLIDO 1: " + RS.getString("apellido_1"));
                        System.out.print(" | ");
                        System.out.print("APELLIDO 2: " + RS.getString("apellido_2"));
                        System.out.print(" | ");
                        System.out.print("ID CARGO: " + RS.getString("id_cargo"));
                        System.out.print(" | ");
                        System.out.print("ID COMUNA: " + RS.getString("id_comuna"));
                        System.out.print(" | ");
                        System.out.print("ID CIUDAD: " + RS.getString("id_ciudad"));
                        System.out.print(" | ");
                        System.out.print("ID REGION: " + RS.getString("id_region"));
                        limpiar(3);
                        }                                                                        
                   break;    
                   case 4:
                       CB = "apellido_1";
                       System.out.print("Ingrese el Primer Apellido del Empleado a Buscar: ");
                       VB = leer.next();
                       RS = CEMP.Buscar_E(VB, CB, BP);
                       while (RS.next()){
                        System.out.print("ID EMPLEADO: " + RS.getString("id_empleado"));
                        System.out.print(" | ");
                        System.out.print("NOMBRE 1: " + RS.getString("nombre_1"));
                        System.out.print(" | ");
                        System.out.print("NOMBRE 2: " + RS.getString("nombre_2"));
                        System.out.print(" | ");
                        System.out.print("APELLIDO 1: " + RS.getString("apellido_1"));
                        System.out.print(" | ");
                        System.out.print("APELLIDO 2: " + RS.getString("apellido_2"));
                        System.out.print(" | ");
                        System.out.print("ID CARGO: " + RS.getString("id_cargo"));
                        System.out.print(" | ");
                        System.out.print("ID COMUNA: " + RS.getString("id_comuna"));
                        System.out.print(" | ");
                        System.out.print("ID CIUDAD: " + RS.getString("id_ciudad"));
                        System.out.print(" | ");
                        System.out.print("ID REGION: " + RS.getString("id_region"));
                        limpiar(3);
                        }     
                       break;
                   case 5:
                       CB = "apellido_2";
                       System.out.print("Ingrese el Segundo Apellido del Empleado a Buscar: ");
                       VB = leer.next();
                       RS = CEMP.Buscar_E(VB, CB, BP);
                       while (RS.next()){
                        System.out.print("ID EMPLEADO: " + RS.getString("id_empleado"));
                        System.out.print(" | ");
                        System.out.print("NOMBRE 1: " + RS.getString("nombre_1"));
                        System.out.print(" | ");
                        System.out.print("NOMBRE 2: " + RS.getString("nombre_2"));
                        System.out.print(" | ");
                        System.out.print("APELLIDO 1: " + RS.getString("apellido_1"));
                        System.out.print(" | ");
                        System.out.print("APELLIDO 2: " + RS.getString("apellido_2"));
                        System.out.print(" | ");
                        System.out.print("ID CARGO: " + RS.getString("id_cargo"));
                        System.out.print(" | ");
                        System.out.print("ID COMUNA: " + RS.getString("id_comuna"));
                        System.out.print(" | ");
                        System.out.print("ID CIUDAD: " + RS.getString("id_ciudad"));
                        System.out.print(" | ");
                        System.out.print("ID REGION: " + RS.getString("id_region"));
                        limpiar(3);
                        }   
                       break;
                   case 6:
                       limpiar(5);
                       break;
               }
           }           
       }
    /*Metodo de limpiar pantalla*/
    /*Sirve para hacer saltos de linea recibiendo un numero de lineas*/
    private static void limpiar(int lineas){
    for (int i=0; i < lineas; i++)
    {
    System.out.println();
        }
    }      
}