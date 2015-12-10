package agenda.main;

import MenusDaAgenda.AgendaTelaV1;
import agenda.controle.AgendaControladorV2;

/**
 *
 * @author Joao
 */
public class AgendaMainV1
{
    public static void main(String[] args)
    {
        AgendaControladorV2 controlador = new AgendaControladorV2();
        AgendaTelaV1 tela = new AgendaTelaV1(controlador);
        
        tela.menuAgenda();
        System.exit(0);
    }
}
