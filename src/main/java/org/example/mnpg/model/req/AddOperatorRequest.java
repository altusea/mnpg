package org.example.mnpg.model.req;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.example.mnpg.validation.ValidPermissionLevel;

@Serdeable
@Introspected
@Data
public class AddOperatorRequest {

    @NotBlank
    private String id;

    @NotBlank
    private String name;

    private String tel;

    private String addr;

    @ValidPermissionLevel
    private String permissionLevel;
}
