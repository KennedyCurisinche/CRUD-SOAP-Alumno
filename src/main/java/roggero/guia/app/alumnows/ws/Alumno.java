package roggero.guia.app.alumnows.ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import roggero.guia.app.alumnows.dao.AlumnoDAO;
import roggero.guia.app.alumnows.vo.AlumnoVO;

@WebService(serviceName = "Alumno")
public class Alumno {
    
    AlumnoDAO dao = new AlumnoDAO();
    
    @WebMethod(operationName = "porIdAlumno")
    @WebResult(name = "alumno")
    public AlumnoVO porIdAlumno(@WebParam(name = "id") Integer id)  {
        return dao.porIdAlumno(id);
    }
    
    @WebMethod(operationName = "listaAlumno")
    @WebResult(name = "listaAlumno")
    public List<AlumnoVO> listaAlumno() {
        return dao.listaAlumno();
    }
    
    @WebMethod(operationName = "guardarAlumno")
    @WebResult(name = "mensaje")
    public String guardarAlumno(@WebParam(name = "alumno") AlumnoVO alumno) {
        return dao.guardarAlumno(alumno);
    }
    
    @WebMethod(operationName = "eliminarPorIdAlumno")
    @WebResult(name = "mensaje")
    public String eliminarPorIdAlumno(@WebParam(name = "id") Integer id) {
        return dao.eliminarPorIdAlumno(id);
    }
    
}
