package steps;

import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.Entao;
import org.junit.Assert;
import tdm.Tdm;
import utils.Factory;

import static constants.Endpoints.PET;
import static constants.Url.BASE_URL;

public class UpdatePet {

    Factory fac = new Factory();
    String name = "";
    String status = "";

    @Dado("desejo alterar os dados do meu pet nome {string} e status {string}")
    public void preenchoDadosUpdate(String name, String status) {
        this.name = name;
        this.status = status;
    }

    @Entao("valido que o pet foi alterado com sucesso")
    public void validoPetUpdatpet() {;
        fac.updatePet(BASE_URL, PET+ Tdm.pet.getId(), name, status);
        Assert.assertEquals(200, fac.getResponse().getStatusCode());
    }

}
