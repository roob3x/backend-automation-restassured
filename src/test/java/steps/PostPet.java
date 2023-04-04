package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.Entao;
import org.junit.Assert;
import support.Filters;
import utils.Factory;

import java.util.List;
import java.util.Map;

import static constants.Endpoints.PET;
import static constants.Url.BASE_URL;
import static schemas.PostPetPayload.CUSTOM_PET_PAYLOAD;

public class PostPet {

    String json = "";

    Map<String, String> firstRow;
    Factory fac = new Factory();

    @Dado("que preencho os dados minimos do pet como")
    public void preenchoOsDadosMinimos(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        firstRow = rows.get(0);
        json = CUSTOM_PET_PAYLOAD;
        json = json.replace("IDENTIFICATION", Integer.toString(Filters.generateRandomNumber()));
        json = json.replace("CATEGORYID", Integer.toString(Filters.generateRandomNumber()));
        json = json.replace("CATEGORYNAME", firstRow.get("raca"));
        json = json.replace("PETNAME", firstRow.get("nome"));
        json = json.replace("TAGID", Integer.toString(Filters.generateRandomNumber()));
        json = json.replace("STATUS", firstRow.get("status"));
        System.out.println(json);

    }

    @Entao("valido que o pet foi cadastrado com sucesso")
    public void validoCadastroUsuario() {
        fac.post(BASE_URL, PET, json);
        Assert.assertEquals(200, fac.getResponse().getStatusCode());
    }
}
