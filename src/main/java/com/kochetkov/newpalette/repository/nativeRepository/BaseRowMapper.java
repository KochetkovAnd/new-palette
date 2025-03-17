package com.kochetkov.newpalette.repository.nativeRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.jdbc.core.RowMapper;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BaseRowMapper<T> implements RowMapper<T> {

    Class<T> targetClass;

    @Override
    public T mapRow(ResultSet rs, int rowNum) throws SQLException {

        try {
            T dto = targetClass.getDeclaredConstructor().newInstance();

            var metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnLabel(i);
                Object columnValue = rs.getObject(i);

                for (Field field : targetClass.getDeclaredFields()) {
                    if (field.getName().equalsIgnoreCase(columnName)) {
                        field.setAccessible(true);
                        field.set(dto, columnValue);
                        break;
                    }
                }
            }
            return dto;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
