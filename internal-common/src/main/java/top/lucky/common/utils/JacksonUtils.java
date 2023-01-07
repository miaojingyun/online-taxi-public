package top.lucky.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JacksonUtils {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private JacksonUtils() {
    }

    public static <T> String toJSONString(T obj) {
        try {
            return obj == null ? null : MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException var2) {
            throw new IllegalArgumentException(var2);
        }
    }

    public static <T> String toJSONStringPretty(T obj) {
        try {
            return obj == null ? null : MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (JsonProcessingException var2) {
            throw new IllegalArgumentException(var2);
        }
    }

    public static <T> T parseObject(String text, Class<T> clazz) {
        try {
            return MAPPER.readValue(text, clazz);
        } catch (IOException var3) {
            throw new IllegalArgumentException(var3);
        }
    }

    public static <T> T parseObject(String text, TypeReference<T> valueTypeRef) {
        try {
            return MAPPER.readValue(text, valueTypeRef);
        } catch (IOException var3) {
            throw new IllegalArgumentException(var3);
        }
    }

    public static <T> T parseObject(String text, Type type) {
        return (T) parseObject(text, (Class)type);
    }

    public static <T> List<T> parseArray(String text, Class<T> clazz) {
        try {
            JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, new Class[]{clazz});
            return (List)MAPPER.readValue(text, javaType);
        } catch (IOException var3) {
            throw new IllegalArgumentException(var3);
        }
    }

    public static ObjectMapper getObjectMapper() {
        return MAPPER;
    }

    static {
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}
