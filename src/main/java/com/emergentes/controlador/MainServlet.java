package com.emergentes.controlador;

import com.emergentes.modelo.Contacto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Parametros requeridos en la conexion
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://i0rgccmrx3at3wv3.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/ku4vtlexfz5pgxq8";
        String usuario = "kanitq26naz5dwuz";
        String password = "i8msnny6rt8li3et";

        try {
            //
            Connection conn = null;
            String sql = "select * from contactos";
            PreparedStatement ps = null;
            ResultSet rs = null;

            ArrayList<Contacto> lista = new ArrayList<Contacto>();

            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Contacto c = new Contacto();

                c.setId(rs.getInt("id"));
                c.setCorreo(rs.getString("correo"));
                c.setNombre(rs.getString("nombre"));
                c.setTelefono(rs.getString("telefono"));

                lista.add(c);
            }

            request.setAttribute("lista", lista);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e){
            System.out.println("Error al conectar" + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
