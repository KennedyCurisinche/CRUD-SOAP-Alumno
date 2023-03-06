package roggero.guia.app.alumnows.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import roggero.guia.app.alumnows.dbase.Conexcion;
import roggero.guia.app.alumnows.vo.AlumnoVO;

public class AlumnoDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public AlumnoVO porIdAlumno(Integer id) {
        AlumnoVO alumno = null;
        
        try {
            
            con = Conexcion.Mysql();
            ps = con.prepareStatement("SELECT * FROM alumno WHERE idalumno = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                alumno = new AlumnoVO(rs.getInt(1), rs.getString(2), rs.getString(3));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return alumno;
    }
    
    public List<AlumnoVO> listaAlumno() {
        List<AlumnoVO> alumnos = new ArrayList<>();
        
        try {
            
            con = Conexcion.Mysql();
            ps = con.prepareStatement("SELECT * FROM alumno");
            rs = ps.executeQuery();

            while (rs.next()) {
                alumnos.add(new AlumnoVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return alumnos;
    }
    
    public String guardarAlumno(AlumnoVO alumno) {
        String mensaje = "No se guardo alumno";
        try {
            
            con = Conexcion.Mysql();
            ps = con.prepareStatement("INSERT INTO alumno (codigo, alumno) VALUES(?, ?)");
            ps.setString(1, alumno.getCodigo());
            ps.setString(2, alumno.getNombre());
            
            int exito = ps.executeUpdate();
            
            if(exito != 0) {
                mensaje = "Se guardo alumno con exito";
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return mensaje;
    }
    
    public String eliminarPorIdAlumno(Integer id) {
        String mensaje = "No se pudo eliminar alumno";
        try {
            
            con = Conexcion.Mysql();
            ps = con.prepareStatement("DELETE FROM alumno WHERE idalumno = ?");
            ps.setInt(1, id);
            
            int exito = ps.executeUpdate();
            
            if(exito != 0) {
                mensaje = "Se elimino alumno con exito";
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return mensaje;
    }
            
}
