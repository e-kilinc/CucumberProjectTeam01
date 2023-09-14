package utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtils {
    // <T> T --> Herhangi bir veri tipini temsil eder. (Generic)
    // readValue() metodu, birinci parametrede aldığı String datayı,
    // ikinci parametrede belirttiğimiz data tipine çevirir.
    public static <T> T convertJsonToJava(String json, Class<T> cls) { //gee´´nric method: bununla istedigim class tipi ile bu methodu kullananbiliirim(Ister JsonPlacePojo ister diger Pojo classlar ile))
        try {
            return new ObjectMapper().readValue(json, cls); //sadece addExeption yaparsak methodu her kullandigimizda exception atmamiz gerekir. onedenle method icinde handle etmememiz gerekir. more actions--> try catch

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
