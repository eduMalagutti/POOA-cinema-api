package br.ufscar.pooa.cinema_api.infrastructure.persistence_framework.database;

import br.ufscar.pooa.cinema_api.infrastructure.persistence_framework.annotation.PFColumn;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

public class DQLGenerator {

    public String generateInsertSQL(String tableName, List<Field> insertColumns) {
        String columnNames = insertColumns.stream().map(Field::getName).collect(Collectors.joining(","));
        String questionMarks = insertColumns.stream().map(i -> "?").collect(Collectors.joining(","));

        return String.format("""
                INSERT INTO %s (%s)
                VALUES (%s)
                """, tableName, columnNames, questionMarks);
    }

    public String generateSelectByIdSQL(String tableName, List<Field> columns, Field idField) {
        StringBuilder sql = new StringBuilder("SELECT ");

        for (int i = 0; i < columns.size(); i++) {
            Field currentField = columns.get(i);
            PFColumn columnAnnotation = currentField.getAnnotation(PFColumn.class);
            sql.append(columnAnnotation.name());

            if (i < columns.size() - 1) {
                sql.append(", ");
            }
        }

        sql.append(" FROM ").append(tableName);
        sql.append(" WHERE ");

        PFColumn idColumnAnnotation = idField.getAnnotation(PFColumn.class);
        sql.append(idColumnAnnotation.name()).append(" = ?");

        return sql.toString();
    }

    public String generateSelectByFieldSQL(String tableName, List<Field> columns, Field field) {
        StringBuilder sql = new StringBuilder("SELECT ");

        for (int i = 0; i < columns.size(); i++) {
            Field currentField = columns.get(i);
            PFColumn columnAnnotation = currentField.getAnnotation(PFColumn.class);
            sql.append(columnAnnotation.name());

            if (i < columns.size() - 1) {
                sql.append(", ");
            }
        }

        sql.append(" FROM ").append(tableName);
        sql.append(" WHERE ");

        PFColumn fieldAnnotation = field.getAnnotation(PFColumn.class);
        sql.append(fieldAnnotation.name()).append(" = ?");

        return sql.toString();
    }

    public String generateSelectAllSQL(String tableName, List<Field> columns) {
        StringBuilder sql = new StringBuilder("SELECT ");

        for (int i = 0; i < columns.size(); i++) {
            Field currentField = columns.get(i);
            PFColumn columnAnnotation = currentField.getAnnotation(PFColumn.class);
            sql.append(columnAnnotation.name());

            if (i < columns.size() - 1) {
                sql.append(", ");
            }
        }

        sql.append(" FROM ").append(tableName);

        return sql.toString();
    }

    public String generateExistsSQL(String tableName, Field idField) {
        StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM ");
        sql.append(tableName);
        sql.append(" WHERE ");

        PFColumn idColumnAnnotation = idField.getAnnotation(PFColumn.class);
        sql.append(idColumnAnnotation.name()).append(" = ?");

        return sql.toString();
    }

    public String generateExistsByFieldSQL(String tableName, java.lang.reflect.Field field) {
        StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM ");
        sql.append(tableName);
        sql.append(" WHERE ");

        PFColumn columnAnnotation = field.getAnnotation(PFColumn.class);
        sql.append(columnAnnotation.name()).append(" = ?");

        return sql.toString();
    }
}