package com.kochetkov.newpalette.repository.nativeRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NativeRepository {
    NamedParameterJdbcTemplate jdbcTemplate;
    @Transactional
    public <T> List<T> get(String query, Map<String, ?> paramMap, Class<T> clazz) {
        return jdbcTemplate.query(query, paramMap, new BaseRowMapper<>(clazz));
    }
    @Transactional
    public <T> List<T> get(String query, Class<T> clazz) {
        return jdbcTemplate.query(query, new BaseRowMapper<>(clazz));
    }
}
