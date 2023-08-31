package io.micronaut.repo;

import io.micronaut.db.tables.pojos.OperatorDO;
import io.micronaut.db.tables.records.OperatorRecord;
import io.micronaut.mo.OperatorMO;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.jooq.DSLContext;
import org.jooq.Record1;

import java.util.List;

import static io.micronaut.db.Tables.OPERATOR;

@Singleton
public class OperatorRepo {

    @Inject
    DSLContext context;

    public void insert(OperatorMO newOperator) {
        OperatorRecord operatorRecord = new OperatorRecord();
        operatorRecord.setId(newOperator.getId());
        operatorRecord.setName(newOperator.getName());
        operatorRecord.setTel(newOperator.getTel());
        operatorRecord.setAddr(newOperator.getAddr());

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
