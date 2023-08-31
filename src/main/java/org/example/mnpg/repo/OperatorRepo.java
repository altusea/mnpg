package org.example.mnpg.repo;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.example.mnpg.db.tables.pojos.OperatorDO;
import org.example.mnpg.db.tables.records.OperatorRecord;
import org.example.mnpg.model.req.AddOperatorRequest;
import org.jooq.DSLContext;
import org.jooq.Record1;

import java.util.List;

import static org.example.mnpg.db.Tables.OPERATOR;


@Singleton
public class OperatorRepo {

    @Inject
    DSLContext context;

    public void insert(AddOperatorRequest request) {
        OperatorRecord operatorRecord = new OperatorRecord();
        operatorRecord.setId(request.getId());
        operatorRecord.setName(request.getName());
        operatorRecord.setTel(request.getTel());
        operatorRecord.setAddr(request.getAddr());

        context.insertInto(OPERATOR).set(operatorRecord).execute();
    }

    public List<String> listId() {
        return context
                .select(OPERATOR.ID)
                .from(OPERATOR)
                .fetch().stream().map(Record1::value1).toList();
    }

    public void deleteById(String id) {
        context.delete(OPERATOR).where(OPERATOR.ID.eq(id)).execute();
    }

    public List<OperatorDO> queryAll() {
        return context.selectFrom(OPERATOR).fetch().into(OperatorDO.class);
    }
}
