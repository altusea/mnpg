package org.example.mnpg.service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.example.mnpg.db.tables.pojos.OperatorDO;
import org.example.mnpg.model.mo.OperatorMO;
import org.example.mnpg.model.req.AddOperatorRequest;
import org.example.mnpg.repo.OperatorRepo;
import org.example.mnpg.utils.Convertor;

import java.util.List;

@Singleton
public class OperatorService {

    @Inject
    OperatorRepo operatorRepo;

    public void add(AddOperatorRequest request) {
        operatorRepo.insert(request);
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
