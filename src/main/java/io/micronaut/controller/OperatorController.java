package io.micronaut.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.mo.OperatorMO;
import io.micronaut.service.OperatorService;
import jakarta.inject.Inject;

import java.util.List;

@Controller("/operator")
@Produces(MediaType.APPLICATION_JSON)
public class OperatorController {

    @Inject
    OperatorService operatorService;

    @Post(value = "/add")
    public void add(@Body OperatorMO user) {
        operatorService.add(user);
    }

    @Get("/listAllId")
    public List<String> listAllId() {
        return operatorService.listAllId();
    }

    @Get("/listAll")
    public List<OperatorMO> listAll() {
        return operatorService.listAll();
    }

    @Delete("/delete")
    public void delete(@QueryValue("id") String id) {
        operatorService.deleteById(id);
    }
}
