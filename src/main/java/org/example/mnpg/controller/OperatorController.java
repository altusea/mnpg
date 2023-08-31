package org.example.mnpg.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import org.example.mnpg.model.mo.OperatorMO;
import org.example.mnpg.model.req.AddOperatorRequest;
import org.example.mnpg.service.OperatorService;

import java.util.List;

@Controller("/operator")
@Produces(MediaType.APPLICATION_JSON)
public class OperatorController {

    @Inject
    OperatorService operatorService;

    @Post(value = "/add")
    public void add(@Valid @Body AddOperatorRequest request) {
        operatorService.add(request);
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
