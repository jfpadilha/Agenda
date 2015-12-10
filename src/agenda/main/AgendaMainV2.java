package agenda.main;

import agenda.apresentacao.CompromissosTelaPrincipal;
import agenda.controle.AgendaControladorV2;

/**
 *
 * @author joao
 */
public class AgendaMainV2
{
    public static void main(String[] args)
    {
        AgendaControladorV2 controlador = new AgendaControladorV2();
        CompromissosTelaPrincipal tela = new CompromissosTelaPrincipal(controlador);
        tela.setVisible(true);
    }
    
}
