package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.Entao;
import org.junit.Assert;
import support.Filters;
import tdm.Tdm;
import utils.Factory;

import static constants.Data.*;
import static constants.Data.NAME_PET;
import static constants.Endpoints.ORDER;
import static constants.Url.BASE_URL;
import static schemas.PostStoreOrderPayload.STORE_ORDER_CUSTON_PAYLOAD;

public class PostStoreOrder {

    Factory fac = new Factory();
    GetLogin getLogin = new GetLogin();
    PostPet postPet = new PostPet();
    UpdatePet updatePet = new UpdatePet();
    Filters filters = new Filters();
    String json = "";

    @Before
    public void beforeScenario(Scenario scenario) throws InterruptedException {
        if (scenario.getName().contains("Verifico que é possivel realizar venda de pet cadastrado e disponivel")) {
            getLogin.login(USERNAME, PASSWORD);
            postPet.preenchoOsDadosMinimos(RACE_PET,NAME_PET);
            postPet.validoCadastroPet();
        }
    }

    @Dado("que preencho os dados para a venda")
    public void preenchoDadosParaVenda() {
        json = STORE_ORDER_CUSTON_PAYLOAD;
        json = json.replace("STOREID", Integer.toString(Filters.generateRandomNumberUntilTen()));
        json = json.replace("PETID", Integer.toString(Tdm.pet.getId()));
        json = json.replace("QUANTITY", "1");
        json = json.replace("SHIPDATE", Filters.getCurrentDateTime());
        json = json.replace("STATUS", "placed");
    }

    @Entao("valido que o pet foi vendido com sucesso")
    public void validoVendaPet() {
        fac.post(BASE_URL, ORDER, json);
        Assert.assertEquals(200, fac.getResponse().getStatusCode());
    }

    @After
    public void afterScenario(Scenario scenario) throws InterruptedException {
        if (scenario.getName().contains("Verifico que é possivel realizar venda de pet cadastrado e disponivel")) {
            updatePet.preenchoDadosUpdate("Chico", "delivered");
            updatePet.validoPetUpdatpet();
        }
    }

}
