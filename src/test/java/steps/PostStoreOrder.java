package steps;

import beans.PetBean;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.Entao;
import org.junit.Assert;
import org.junit.Before;
import support.Filters;
import utils.Factory;

import java.util.List;
import java.util.Map;

import static constants.Data.USER_NAME_FIX;
import static constants.Endpoints.ORDER;
import static constants.Url.BASE_URL;
import static schemas.PostPetPayload.CUSTOM_PET_PAYLOAD;
import static schemas.PostStoreOrderPayload.STORE_ORDER_CUSTON_PAYLOAD;

public class PostStoreOrder {

    Factory fac = new Factory();
    PostPet postPet = new PostPet();
    Filters filters = new Filters();
    String json = "";

    @Dado("que preencho os dados para a venda")
    public void preenchoDadosParaVenda() {
        json = STORE_ORDER_CUSTON_PAYLOAD;
        json = json.replace("STOREID", Integer.toString(Filters.generateRandomNumberUntilTen()));
        json = json.replace("PETID", Integer.toString(postPet.petBean.getId()));
        json = json.replace("QUANTITY", "1");
        json = json.replace("SHIPDATE", Filters.getCurrentDateTime());
        json = json.replace("STATUS", "placed");
    }

    @Entao("valido que o pet foi vendido com sucesso")
    public void validoVendaPet() {
        fac.post(BASE_URL, ORDER, json);
        Assert.assertEquals(200, fac.getResponse().getStatusCode());
    }

}
