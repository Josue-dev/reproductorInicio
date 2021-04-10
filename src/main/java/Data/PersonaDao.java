/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import static Data.conexion.*;
import domain.Persona;
import java.sql.*;
import java.util.*;



/**
 *DATA ACCESS OBJECT 
 * SE IMPLEMENTARA EL CRUD CREATE READ UPDTE AND DELETE DE LA BASE DE DATOS 
 * @author Josue
 */
public class PersonaDao {
    private static final String SQL_SELECT ="SELECT id, nombre FROM participantesdos";
    
    public List<Persona> seleccinar(){
        Connection conn =null;
        PreparedStatement stmt = null;
        ResultSet rs =null;
        Persona persona=null;
        List<Persona> personas = new ArrayList<>();
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                int idPersona = rs.getInt("id");
                String nombrePersona = rs.getString("nombre");
                
                persona = new Persona(idPersona, nombrePersona);//mandamos al constructor de la clase persona
                personas.add(persona);//agregamos el objeto a la lista de personas
            }
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }finally{
            try {
                conexion.close(rs);
                conexion.close(stmt);
                conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
                
        return personas;
    }
}
