package steps.hooks;

import beans.PetBean;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import steps.GetLogin;
import steps.PostPet;
import steps.UpdatePet;
import utils.Factory;

import static constants.Data.*;

public class ServiceHooks {
    GetLogin getLogin = new GetLogin();
    PostPet postPet = new PostPet();
    Factory fac = new Factory();
    UpdatePet updatePet = new UpdatePet();

    @Before
    public void beforeScenario(Scenario scenario) throws InterruptedException {
        if (scenario.getName().contains("Verifico que é possivel realizar venda de pet cadastrado e disponivel")) {
            getLogin.login(USERNAME, PASSWORD);
            postPet.preenchoOsDadosMinimos(RACE_PET,NAME_PET);
            postPet.validoCadastroPet();
        }
    }

    @After
    public void afterScenario(Scenario scenario) throws InterruptedException {
        if (scenario.getName().contains("Verifico que é possivel realizar venda de pet cadastrado e disponivel")) {
            updatePet.preenchoDadosUpdate("Chico", "sold");
            updatePet.validoPetUpdatet();
        }
    }
}
