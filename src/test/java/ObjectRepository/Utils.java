package ObjectRepository;

public class Utils {

    public String getRequestBodyPath(String path) {
        String requestBodyPath = "src/test/testdata/" + path + ".json";
        return requestBodyPath;
    }
}
