package Git5YagoClon.GestionTaller.DAO;

import Git5YagoClon.GestionTaller.DAO.ConexionBD;

public static Connection conectar() {
    try {
    // Establecer la conexión con la base de datos
    return DriverManager.getConnection(ConexionBD.URL, ConexionBD.USUARIO, ConexionBD.CONTRASENA);
    } catch (SQLException e) {
    System.out.println("Error al conectar a la base de datos: " + 
   e.getMessage());
    return null;
    }
}



