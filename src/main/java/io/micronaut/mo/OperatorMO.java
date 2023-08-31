package io.micronaut.mo;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

@Serdeable
@Data
public class OperatorMO {

    private String id;

    private String name;

    private String tel;

    private String addr;
}
