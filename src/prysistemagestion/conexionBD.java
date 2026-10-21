package prysistemagestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

class conexionBD {
    
        // Variables de conexión para XAMPP por defecto
    private final String bd = "sistema_gestion";
    private final String url = "jdbc:mysql://localhost:3306/" + bd;
    private final String usuario = "root"; // Usuario por defecto en XAMPP
    private final String password = "";    // Sin contraseña por defecto en XAMPP
    
    private Connection con = null;

    // Método para establecer la conexión
    public Connection conectar() {
        try {
            // 1. Cargamos el driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2. Establecemos la conexión
            con = DriverManager.getConnection(url, usuario, password);
            System.out.println("¡Conexión exitosa a MySQL!");
            
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error: No se encontró el driver de MySQL.\n" + e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos.\n" + e.getMessage());
        }
        
        return con;
    }

    // Método para desconectar
    public void desconectar() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Base de datos desconectada.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión.\n" + e.getMessage());
        }
    }
    
    
}
