/*
 * This file is generated by jOOQ.
 */
package io.micronaut.db.tables;


import io.micronaut.db.Mnpg;
import io.micronaut.db.tables.records.OperationLogRecord;

import java.time.LocalDateTime;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function3;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TOperationLog extends TableImpl<OperationLogRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>mnpg.operation_log</code>
     */
    public static final TOperationLog OPERATION_LOG = new TOperationLog();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OperationLogRecord> getRecordType() {
        return OperationLogRecord.class;
    }

    /**
     * The column <code>mnpg.operation_log.operation_time</code>.
     */
    public final TableField<OperationLogRecord, LocalDateTime> OPERATION_TIME = createField(DSL.name("operation_time"), SQLDataType.LOCALDATETIME(6), this, "");

    /**
     * The column <code>mnpg.operation_log.operator</code>.
     */
    public final TableField<OperationLogRecord, String> OPERATOR = createField(DSL.name("operator"), SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>mnpg.operation_log.operation_type</code>.
     */
    public final TableField<OperationLogRecord, String> OPERATION_TYPE = createField(DSL.name("operation_type"), SQLDataType.VARCHAR(10), this, "");

    private TOperationLog(Name alias, Table<OperationLogRecord> aliased) {
        this(alias, aliased, null);
    }

    private TOperationLog(Name alias, Table<OperationLogRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>mnpg.operation_log</code> table reference
     */
    public TOperationLog(String alias) {
        this(DSL.name(alias), OPERATION_LOG);
    }

    /**
     * Create an aliased <code>mnpg.operation_log</code> table reference
     */
    public TOperationLog(Name alias) {
        this(alias, OPERATION_LOG);
    }

    /**
     * Create a <code>mnpg.operation_log</code> table reference
     */
    public TOperationLog() {
        this(DSL.name("operation_log"), null);
    }

    public <O extends Record> TOperationLog(Table<O> child, ForeignKey<O, OperationLogRecord> key) {
        super(child, key, OPERATION_LOG);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Mnpg.MNPG;
    }

    @Override
    public TOperationLog as(String alias) {
        return new TOperationLog(DSL.name(alias), this);
    }

    @Override
    public TOperationLog as(Name alias) {
        return new TOperationLog(alias, this);
    }

    @Override
    public TOperationLog as(Table<?> alias) {
        return new TOperationLog(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public TOperationLog rename(String name) {
        return new TOperationLog(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TOperationLog rename(Name name) {
        return new TOperationLog(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public TOperationLog rename(Table<?> name) {
        return new TOperationLog(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<LocalDateTime, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function3<? super LocalDateTime, ? super String, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function3<? super LocalDateTime, ? super String, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
