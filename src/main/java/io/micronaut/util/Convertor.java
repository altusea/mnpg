package io.micronaut.util;

import io.micronaut.core.util.CollectionUtils;
import io.micronaut.db.tables.pojos.OperatorDO;
import io.micronaut.mo.OperatorMO;
import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Convertor {

    private static final ModelMapper MAPPER_INSTANCE = new ModelMapper();

    public static <B, A> B map(A from, Class<B> toClazz) {
        if (from == null) return null;
        return MAPPER_INSTANCE.map(from, toClazz);
    }

    public static <B, A> List<B> mapList(Collection<A> from, Class<B> toClazz) {
        if (CollectionUtils.isEmpty(from)) return Collections.emptyList();
        return from.stream().map(e -> map(e, toClazz)).toList();
    }

    public static void main(String[] args) {
        OperatorDO operatorDO = new OperatorDO();
        operatorDO.setId("111");
        operatorDO.setName("aaa");

        OperatorMO operatorMO = map(operatorDO, OperatorMO.class);
        System.out.println(operatorMO);
    }
}
