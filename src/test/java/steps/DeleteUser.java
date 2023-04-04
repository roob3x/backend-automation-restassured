package steps;

import io.cucumber.java.pt.Quando;
import utils.Factory;

import static constants.Endpoints.USER;
import static constants.Url.BASE_URL;

public class DeleteUser {

    Factory fac = new Factory();

    @Quando("tento realizar a exclusao do usuario {string}")
    public void excluirUsername(String username) throws InterruptedException {
        fac.delete(BASE_URL, USER + username);
    }
}
