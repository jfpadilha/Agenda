/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenusDaAgenda;

import agenda.controle.AgendaControladorV2;
import agenda.negocio.Compromisso;
import core.Data;
import core.Entrada;

/**
 *
 * @author joao
 */
public class MenuIncluirUm implements menu3.MenuAction
{

    private final AgendaControladorV2 controladorAgenda;

    public MenuIncluirUm(AgendaControladorV2 controlador)
    {
        this.controladorAgenda = controlador;
    }

    @Override
    public void run()
    {
        agendarCompromisso();
    }

    private void agendarCompromisso()
    {
        String hj = new Data().obterData();
        int code = controladorAgenda.getMaiorCodigo();
        String compromisso = Entrada.leiaString("Informe o compromisso:", "Reunião ");
        String dataCompromisso = Entrada.leiaString("Informe a Data", hj);
        String horario = Entrada.leiaString("Informe o horario", "11:00");

        Data dt = new Data(dataCompromisso);
        String compNovo = compromisso + " " + code;
        Compromisso comp = new Compromisso(code, compNovo, dt, horario);

        controladorAgenda.inserirCompromisso(comp);
    }

}
