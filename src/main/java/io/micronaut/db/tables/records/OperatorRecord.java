/*
 * This file is generated by jOOQ.
 */
package io.micronaut.db.tables.records;


import io.micronaut.db.tables.TOperator;
import io.micronaut.db.tables.pojos.OperatorDO;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OperatorRecord extends UpdatableRecordImpl<OperatorRecord> implements Record4<String, String, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>mnpg.operator.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>mnpg.operator.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>mnpg.operator.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>mnpg.operator.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>mnpg.operator.tel</code>.
     */
    public void setTel(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>mnpg.operator.tel</code>.
     */
    public String getTel() {
        return (String) get(2);
    }

    /**
     * Setter for <code>mnpg.operator.addr</code>.
     */
    public void setAddr(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>mnpg.operator.addr</code>.
     */
    public String getAddr() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<String, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<String, String, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return TOperator.OPERATOR.ID;
    }

    @Override
    public Field<String> field2() {
        return TOperator.OPERATOR.NAME;
    }

    @Override
    public Field<String> field3() {
        return TOperator.OPERATOR.TEL;
    }

    @Override
    public Field<String> field4() {
        return TOperator.OPERATOR.ADDR;
    }

    @Override
    public String component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public String component3() {
        return getTel();
    }

    @Override
    public String component4() {
        return getAddr();
    }

    @Override
    public String value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public String value3() {
        return getTel();
    }

    @Override
    public String value4() {
        return getAddr();
    }

    @Override
    public OperatorRecord value1(String value) {
        setId(value);
        return this;
    }

    @Override
    public OperatorRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public OperatorRecord value3(String value) {
        setTel(value);
        return this;
    }

    @Override
    public OperatorRecord value4(String value) {
        setAddr(value);
        return this;
    }

    @Override
    public OperatorRecord values(String value1, String value2, String value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached OperatorRecord
     */
    public OperatorRecord() {
        super(TOperator.OPERATOR);
    }

    /**
     * Create a detached, initialised OperatorRecord
     */
    public OperatorRecord(String id, String name, String tel, String addr) {
        super(TOperator.OPERATOR);

        setId(id);
        setName(name);
        setTel(tel);
        setAddr(addr);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised OperatorRecord
     */
    public OperatorRecord(OperatorDO value) {
        super(TOperator.OPERATOR);

        if (value != null) {
            setId(value.getId());
            setName(value.getName());
            setTel(value.getTel());
            setAddr(value.getAddr());
            resetChangedOnNotNull();
        }
    }
}