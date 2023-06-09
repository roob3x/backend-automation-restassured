package steps;

import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.Entao;
import org.junit.Assert;
import support.Filters;
import tdm.Pet;
import tdm.Tdm;
import utils.Factory;

import java.util.Map;

import static constants.Endpoints.PET;
import static constants.Url.BASE_URL;
import static schemas.PostPetPayload.CUSTOM_PET_PAYLOAD;

public class PostPet {

    String json = "";

    Map<String, String> firstRow;
    Factory fac = new Factory();

    @Dado("que preencho os dados minimos raca {string} e nome {string}")
    public void preenchoOsDadosMinimos(String raca, String nome) {
        json = CUSTOM_PET_PAYLOAD;
        Tdm.pet.setId(Filters.generateRandomNumber());
        json = json.replace("IDENTIFICATION", Integer.toString(Tdm.pet.getId()));
        json = json.replace("CATEGORYID", Integer.toString(Filters.generateRandomNumber()));
        json = json.replace("CATEGORYNAME", raca);
        json = json.replace("PETNAME", nome);
        json = json.replace("TAGID", Integer.toString(Filters.generateRandomNumber()));

    }

    @Entao("valido que o pet foi cadastrado com sucesso")
    public void validoCadastroPet() {
        fac.post(BASE_URL, PET, json);
        Assert.assertEquals(200, fac.getResponse().getStatusCode());
    }
}
