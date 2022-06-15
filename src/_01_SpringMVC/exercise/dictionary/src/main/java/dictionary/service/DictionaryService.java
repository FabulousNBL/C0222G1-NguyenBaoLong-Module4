package dictionary.service;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {
    static Map<String, String> map = new LinkedHashMap<>();

    static {
        map.put("dog", "chó");
        map.put("cat", "mèo");
        map.put("mouse", "chuột");
        map.put("bird", "chim");
        map.put("hello", "xin chào");
        map.put("bye", "tạm biệt");
    }

    @Override
    public String dictionary(String word) {
        if (map.get(word) != null) {
            return map.get(word);
        } else {
            return "Can't find this word";
        }
    }
}
