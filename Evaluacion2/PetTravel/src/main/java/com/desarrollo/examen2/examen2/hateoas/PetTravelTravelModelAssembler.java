package com.desarrollo.examen2.examen2.hateoas;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.desarrollo.examen2.examen2.controller.PetTravelController;
import com.desarrollo.examen2.examen2.lib.Travel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class PetTravelTravelModelAssembler  implements RepresentationModelAssembler<Travel, EntityModel<Travel>>
{
    @Override
    public EntityModel<Travel> toModel(Travel travel) 
    {
        return EntityModel.of(
                travel, 
                linkTo(methodOn(PetTravelController.class)
                       .getViaje(travel.getId()))
                       .withSelfRel(),
                linkTo(methodOn(PetTravelController.class)
                        .deleteViaje(travel.getId()))
                        .withRel("delete"),
                linkTo(methodOn(PetTravelController.class)
                        .updateViaje(travel.getId(), null))
                        .withRel("update"),
                linkTo(methodOn(PetTravelController.class)
                        .getViajes())
                        .withRel("all"));
    }
}
