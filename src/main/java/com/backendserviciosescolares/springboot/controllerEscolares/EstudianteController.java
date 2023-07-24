package com.backendserviciosescolares.springboot.controllerEscolares;

import com.backendserviciosescolares.springboot.dtoEscolares.AlumnosInscritosDTO;
import com.backendserviciosescolares.springboot.dtoEscolares.RequesAspirante;
import com.backendserviciosescolares.springboot.dtoEscolares.RequesEstudiante;
import com.backendserviciosescolares.springboot.entityEscolares.Aspirante;
import com.backendserviciosescolares.springboot.entityEscolares.Estudiante;
import com.backendserviciosescolares.springboot.repositoryEscolares.AspiranteRepository;
import com.backendserviciosescolares.springboot.repositoryEscolares.EstudianteRepository;
import com.backendserviciosescolares.springboot.serviceEscolares.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping(value = "escolares/estudiante")
public class EstudianteController {

  @Autowired
  private EstudianteRepository estudianteRepository;


  @Autowired
  private AspiranteRepository aspiranteRepository;

  @Autowired
  private EstudianteService estudianteService;

  @PostMapping("/crear/alumno")
  public ResponseEntity<List<Estudiante>> crearAlumno(@RequestBody RequesAspirante.Curp request) {
    try{
     /* if(Utils.validarCurp(request.getCurp())==false){
        System.out.println("no se crea");
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
      }
*/Aspirante result = aspiranteRepository.findByCurp(request.getCurp());
      if(result == null){
        System.out.println("ee");
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
      }

      System.out.println(result);
      Estudiante estudiante = new Estudiante();

      estudiante.setCurpAlumno(result.getCurp());
      estudiante.setApellidoPaterno(result.getApellidoPaterno());
      estudiante.setApellidoMaterno(result.getApellidoMaterno());
      estudiante.setNombreAlumno(result.getNombreAspirante());
      estudiante.setCarrera(result.getCarreraOp1());
      estudiante.setCiudadProcedencia(result.getZonaProcedencia());
      estudiante.setClaveServicioMedico(result.getClavePreparatoria());
      estudiante.setFechaNacimiento(result.getFechaNacimiento());
      estudiante.setSexo(result.getGenero());
      estudiante.setEstadoCivil(result.getEstadoCivil());
      estudiante.setEscuelaProcedencia(result.getClavePreparatoria());
      estudiante.setEntidadProcedencia(result.getEspecifiqueZonaProcedencia());
      estudiante.setCiudadProcedencia(result.getZonaProcedencia());
      estudiante.setCorreoElectronico(result.getCorreoElectronico());
      //estudiante.setPeriodoIngresoIt(result.getPeriodo());



      estudiante.setFechaNacimiento(result.getFechaNacimiento());

      return new ResponseEntity(estudianteService.create(estudiante), HttpStatus.OK);

    }catch (Exception e){
      System.out.println(e.getMessage());
      return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

    }

  }
  @PostMapping("/asignar/nocontrol")
  public List<Estudiante> asignarNoControl(@RequestBody RequesEstudiante request) {
    System.out.println(request);
    try {

      Integer reticula = request.getReticula();
      String periodoIngreso  = request.getPeriodoIngresoIT();
      Long consecutivoInicial = request.getConsecutivoInicial();
      String tipoIngreso = request.getTipoIngreso();
      String añoPreinscripcion = request.getAñoPreInscripcion();

      System.out.println(reticula);
      System.out.println(periodoIngreso);

      List<Estudiante> datosEstudiantes = estudianteService.buscarEstudiantesAsignarNoControl(reticula, periodoIngreso);
      System.out.println(datosEstudiantes);
      for (Estudiante estudiante : datosEstudiantes) {
        // body of loop
        //if (estudiante.getNoDeControl() == null) {
          estudiante.setNoDeControl(String.valueOf(consecutivoInicial));
          consecutivoInicial++;
          estudianteRepository.save(estudiante);
        //}
      }


      return datosEstudiantes;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
  @GetMapping("/obtener/{noDeControl}")
  public Estudiante obtenerEstudiante(@PathVariable String noDeControl) {
    return estudianteService.findByNoDeControl(noDeControl);
  }
  @GetMapping("/obtener/todos")
  public List<Estudiante> getAllEstudiantes() {
    return estudianteService.getAllEstudiantes();
  }

  @PutMapping("/estudiante/{noDeControl}/estatus")
  public void cambiarEstatusEstudiante(@PathVariable String noDeControl, @RequestBody RequesEstudiante.EstatusAlumno request){
    System.out.println(request);

      String estatus = request.getEstatusAlumno();
      estudianteService.cambiarEstatusEstudiante(noDeControl, estatus);

  }

 /* @GetMapping("/estudiante/{reticula}")
  public List<Estudiante> buscarPorCarrera(@PathVariable Integer reticula) {
    return estudianteService.buscarPorCarrera(reticula);
  }*/

  @GetMapping(value = "/carrera/{reticula}")
  public List<Estudiante> mostrarEstudiantesPorCarrera(@PathVariable Integer reticula){
    return estudianteService.buscarEstudiantesPorCarrera(reticula);
  }

  @GetMapping(value = "/periodo/{periodo}")
  public List<Estudiante> mostrarEstudiantesPorPeriodo(@PathVariable String periodo){
    return estudianteService.buscarEstudiantesPorPeriodo(periodo);
  }

  @GetMapping(value = "/nombre/nip/{noDeControl}")
  public Estudiante mostrarNombreYNip(@PathVariable String noDeControl){
    return estudianteService.mostrarNipYNombre(noDeControl);
  }

  @GetMapping(value = "/obtener/alumnos/inscritos/{reticula}/{periodo}")
  public List<AlumnosInscritosDTO> buscarAlumnosInscritos(@PathVariable Integer reticula, @PathVariable String periodo){
    System.out.println(reticula + periodo);
    return estudianteService.buscarAlumnosInscritos(reticula, periodo);
  }


}
