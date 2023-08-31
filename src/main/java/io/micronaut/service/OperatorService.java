package io.micronaut.service;

import io.micronaut.db.tables.pojos.OperatorDO;
import io.micronaut.mo.OperatorMO;
import io.micronaut.repo.OperatorRepo;
import io.micronaut.util.Convertor;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class OperatorService {

    @Inject
    OperatorRepo operatorRepo;

    public void add(OperatorMO operator) {
        operatorRepo.insert(operator);
    }

    public List<String> listAllId() {
        return operatorRepo.listId();
    }

    public List<OperatorMO> listAll() {
        List<OperatorDO> operatorDOList = operatorRepo.queryAll();
        return Convertor.mapList(operatorDOList, OperatorMO.class);
    }

    public void deleteById(String id) {
        operatorRepo.deleteById(id);
    }
}
