package com.desarrollo.evaluacion2.evaluacion2.hateoas;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*; 

import com.desarrollo.evaluacion2.evaluacion2.controller.PetConcursosController;
import com.desarrollo.evaluacion2.evaluacion2.lib.Concurso;

@Component
public class PetConcursosConcursosModelAssembler  implements RepresentationModelAssembler<Concurso, EntityModel<Concurso>>
{
    @Override
    public EntityModel<Concurso> toModel(Concurso concurso) 
    {
        return EntityModel.of(
                concurso, 
                linkTo(methodOn(PetConcursosController.class)
                       .getConcurso(concurso.getId()))
                       .withSelfRel(),
                linkTo(methodOn(PetConcursosController.class)
                        .deleteConcurso(concurso.getId()))
                        .withRel("delete"),
                linkTo(methodOn(PetConcursosController.class)
                        .updateConcurso(concurso.getId(), null))
                        .withRel("update"),
                linkTo(methodOn(PetConcursosController.class)
                        .getConcursos())
                        .withRel("all"));
    }
}
