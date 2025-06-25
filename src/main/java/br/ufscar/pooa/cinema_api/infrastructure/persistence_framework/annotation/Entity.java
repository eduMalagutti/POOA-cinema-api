package br.ufscar.pooa.cinema_api.infrastructure.persistence_framework.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Entity {
    String tableName();
}
