package org.example.mnpg.validation;

import io.micronaut.context.annotation.Factory;
import io.micronaut.validation.validator.constraints.ConstraintValidator;
import jakarta.inject.Singleton;
import org.example.mnpg.enums.PermissionsLevel;

@Factory
class PermissionLevelValidationFactory {

    @Singleton
    ConstraintValidator<ValidPermissionLevel, String> permissionLevelValidator() {
        return (value, annotationMetadata, context) -> PermissionsLevel.isValid(value);
    }
}
