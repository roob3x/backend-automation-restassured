package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.Entao;
import org.junit.Assert;
import support.Filters;
import utils.Factory;

import java.util.List;
import java.util.Map;

import static constants.Endpoints.LOGIN;
import static constants.Url.BASE_URL;
import static schemas.PostUserPayload.CUSTOM_USER_PAYLOAD;

public class GetLogin {
    Factory fac = new Factory();

    @Dado("que preencho usuario {string} e senha {string}")
    public void login(String username, String password) {
        fac.getLogin(BASE_URL, LOGIN, username, password);
    }

    @Entao("valido que o usuario foi logado com sucesso")
    public void validoLoginUsuario() {
        Assert.assertEquals(200, fac.getResponse().getStatusCode());
    }
}
