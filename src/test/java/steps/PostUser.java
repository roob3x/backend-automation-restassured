package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.Entao;
import org.junit.Assert;
import support.Filters;
import utils.Factory;

import java.util.List;
import java.util.Map;

import static constants.Data.USER_NAME_FIX;
import static constants.Endpoints.USER;
import static constants.Url.BASE_URL;
import static schemas.PostUserPayload.CUSTOM_USER_PAYLOAD;

public class PostUser {
    String json = "";
    Map<String, String> firstRow;
    Factory fac = new Factory();
    DeleteUser deleteUser = new DeleteUser();

    @Dado("que preencho os dados minimos")
    public void preenchoOsDadosMinimos(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        firstRow = rows.get(0);
        json = CUSTOM_USER_PAYLOAD;
        json = json.replace("ID", Integer.toString(Filters.generateRandomNumber()));
        json = json.replace("USERNAME", firstRow.get("username"));
        json = json.replace("FIRSTNAME", firstRow.get("firstName"));
        json = json.replace("LASTNAME", firstRow.get("lastName"));
        json = json.replace("EMAIL", firstRow.get("email"));
        json = json.replace("PASSWORD", firstRow.get("password"));
        json = json.replace("PHONE", firstRow.get("phone"));
        json = json.replace("USERSTATUS", firstRow.get("userStatus"));

    }

    @Entao("valido que o usuario foi cadastrado com sucesso")
    public void validoCadastroUsuario() {
        fac.post(BASE_URL, USER, json);
        validoStatusCode(200);
    }

    @Entao("valido que o statuscode com {int}")
    public void validoStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, fac.getResponse().getStatusCode());
    }

    @After
    public void afterScenario(Scenario scenario) throws InterruptedException {
        if (scenario.getName().contains("Verifico que é possivel cadastrar novo usuario ainda nao cadastrado")) {
            deleteUser.excluirUsername(USER_NAME_FIX);
        }
    }
}
