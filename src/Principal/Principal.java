package Principal;

import InterfaceGrafica.MenuPrincipal;
import java.io.IOException;
import java.net.URISyntaxException;



public class Principal {

    public static void main(String[] args) throws IOException, URISyntaxException {

        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
    }
}
