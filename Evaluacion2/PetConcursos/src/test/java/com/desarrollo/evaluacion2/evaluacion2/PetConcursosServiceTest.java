// package com.desarrollo.evaluacion2.evaluacion2;

// import com.desarrollo.evaluacion2.evaluacion2.lib.Concurso;
// import com.desarrollo.evaluacion2.evaluacion2.repository.ConcursoRepository;
// import com.desarrollo.evaluacion2.evaluacion2.service.PetConcursoService;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;


// import java.util.Arrays;
// import java.util.List;

// import static org.junit.jupiter.api.Assertions.*;
// import static org.mockito.Mockito.*;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Sort;

// public class PetConcursosServiceTest {

//     @Autowired
//     private PetConcursoService petConcursoService;
    
//     @Autowired
//     private ConcursoRepository concursoRepository;

//     @BeforeEach
//     public void setUp() {
//         concursoRepository = mock(ConcursoRepository.class);
//         petConcursoService = new PetConcursoService();
//     }

//     @Test
//     public void testObtenerConcursos() {
//         Concurso concurso1 = new Concurso();
//         concurso1.setId(1);
//         concurso1.setIdMascota(1);
//         concurso1.setIdPropietario(1);
//         concurso1.setPrecio(1000);
//         concurso1.setNombre("Concurso 1");
//         concurso1.setDescripcion("Descripción del concurso 1");
//         concurso1.setFecha("2023-01-01");
//         concurso1.setUbicacion("Ubicación 1");
//         concurso1.setEstado("Activo");

//         Concurso concurso2 = new Concurso();
//         concurso2.setId(2);
//         concurso2.setIdMascota(2);
//         concurso2.setIdPropietario(2);
//         concurso2.setPrecio(2000);
//         concurso2.setNombre("Concurso 2");
//         concurso2.setDescripcion("Descripción del concurso 2");
//         concurso2.setFecha("2023-02-01");
//         concurso2.setUbicacion("Ubicación 2");
//         concurso2.setEstado("Inactivo");

//         when(concursoRepository.findAll(Sort.by("id").ascending())).thenReturn(Arrays.asList(concurso1, concurso2));
//         List<Concurso> concursos = petConcursoService.obtenerConcursos();

//         assertEquals(2, concursos.size());
//         assertEquals("Concurso 1", concursos.get(0).getNombre());   
//     }
    
// }
