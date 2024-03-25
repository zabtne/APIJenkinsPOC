package Utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import PojoClasses.Product;

public class JsonHelper {

	public static boolean CompareStringToJsonFile(String text, String fileName) throws IOException {
		String filePath = System.getProperty("user.dir")+"/src/test/java/TestData/" + fileName;
		ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Product>> listType = new TypeReference<List<Product>>() {};
        List<Product> responseProductsList = objectMapper.readValue(text, listType);
        List<Product> expectedProductsList = objectMapper.readValue(new File(filePath), listType);

        return (responseProductsList.size() == expectedProductsList.size() && responseProductsList.containsAll(expectedProductsList) && expectedProductsList.containsAll(responseProductsList));
	}
}
