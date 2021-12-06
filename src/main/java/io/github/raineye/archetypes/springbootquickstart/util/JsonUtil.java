package io.github.raineye.archetypes.springbootquickstart.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.util.List;
import java.util.Map;

/**
 * json 工具类
 *
 * @author TX
 */
public class JsonUtil {

    /**
     * 将对象转换成json字符串
     * @param obj 对象
     * @return json字符串
     */
    @SneakyThrows
    public static String obj2JsonStr(Object obj) {
        return new ObjectMapper().writeValueAsString(obj);
    }

    /**
     * 将json字符串转换为对象
     * @param jsonStr json字符串
     * @param clz 类
     * @param <T> 泛型
     * @return 转换后的对象
     */
    @SneakyThrows
    public static <T> T json2Obj(String jsonStr, Class<T> clz) {
        return new ObjectMapper().readValue(jsonStr, clz);
    }

    /**
     * 将json字符串转换成map
     *
     * @param jsonStr json字符串
     * @param <K>     键类型
     * @param <V>     值类型
     * @return 转换后的map
     */
    @SneakyThrows
    public static <K, V> Map<K, V> json2Map(String jsonStr) {
        return new ObjectMapper().readValue(jsonStr, new TypeReference<Map<K, V>>() {
        });
    }

    /**
     * 将json字符串转换成list包装的map
     *
     * @param jsonStr json字符串
     * @param <K>     键类型
     * @param <V>     值类型
     * @return 转换后的list包装的map
     */
    @SneakyThrows
    public static <K, V> List<Map<K, V>> json2ListMap(String jsonStr) {
        return new ObjectMapper().readValue(jsonStr, new TypeReference<List<Map<K, V>>>() {
        });
    }
}
