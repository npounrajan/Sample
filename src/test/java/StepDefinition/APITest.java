package StepDefinition;

import ObjectRepository.APIPage;
import ObjectRepository.Utils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class APITest {
    String baseUrl;
    int createdRecordId;
    Response response;
    public APIPage apiPage = new APIPage();
    public Utils utils = new Utils();

    @BeforeMethod
    public void setUp() {
        baseUrl = "http://dummy.restapiexample.com/api/v1";
    }

    @Test
    public void createEmployeeData() {
        response = apiPage.postMethodAPI(baseUrl, utils
                .getRequestBodyPath("createEmployee"), "/create");
        Assert.assertEquals(apiPage.getStatusCode(response), 200);
        createdRecordId = apiPage.getCreatedRecordId(response);
    }

    @Test
    public void getEmployeeData() {
        response = apiPage.getMethodAPI(baseUrl, "/employees");
        Assert.assertEquals(apiPage.getStatusCode(response), 200);
        Assert.assertEquals(apiPage.getStatusMessage(response),"success");
    }

    @Test
    public void deleteEmployeeData() {
        response = apiPage.deleteMethodAPI(baseUrl,"/delete/"+createdRecordId);
        Assert.assertEquals(apiPage.getStatusCode(response), 200);
        Assert.assertEquals(apiPage.getDeleteConfirmation(response),"Successfully! Record has been deleted");
    }

}
