package MenusDaAgenda;

import agenda.negocio.Compromisso;
import agenda.controle.AgendaControladorV2;
import core.Arquivo;
import core.Data;
import core.Entrada;
import java.util.ArrayList;

/**
 *
 * @author jfpsouza
 */
public class AgendaTelaV1
{

    private final AgendaControladorV2 controladorAgenda;

    public AgendaTelaV1(AgendaControladorV2 controlador)
    {
        this.controladorAgenda = controlador;
    }

    public void menuAgenda()
    {
        String menu = "Agenda:\n\n"
                + "[1] Agendar um compromisso\n"
                + "[2] Agendar varios Compromissos iguais\n"
                + "[3] Agendar varios compromissos iguais durante varias semanas\n"
                + "[4] Excluir compromisso\n"
                + "[5] Editar compromisso\n"
                + "[6] Consultar os Compromissos de um intervalo de datas\n"
                + "[7] Listar\n"
                + "[8] Procurar compromisso por código\n"
                + "[9] Procurar compromisso por Data\n"
                + "[0] Sair do sistema";
        int op = -1;
        while ( op != 0 )
        {
            op = Entrada.leiaInt(menu);

            if ( op == 1 )
            {
                agendarCompromisso();
            }
            else if ( op == 2 )
            {
                agendarVariosCompromissos();
            }
            else if ( op == 3 )
            {
                agendarVariosCompromissosPorVariasSemanas();
            }
            else if ( op == 4 )
            {
                excluirCompromissoData();
            }
            else if ( op == 5 )
            {
                editarCompromisso();
            }
            else if ( op == 6 )
            {
                listarEntreDatas();
            }
            else if ( op == 7 )
            {
                listar();
            }
            else if ( op == 8 )
            {
                localizarCompromissoCodigo();
            }
            else if ( op == 9 )
            {
                localizarCompromissoData();
            }
        }
        System.exit(0);
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

    private void agendarVariosCompromissos()
    {
        String hj = new Data().obterData();
        int quantidade = Entrada.leiaInt("Informe quantas vzes vai se repetir", 5);
        String compromisso = Entrada.leiaString("Informe o compromisso:", "Reunião ");
        String dataCompromisso = Entrada.leiaString("Informe a Data", hj);
        String horario = Entrada.leiaString("Informe o horario", "11:00");

        Data dataComp = new Data(dataCompromisso);

        for ( int i = 0; i < quantidade; i++ )
        {
            int code = controladorAgenda.getMaiorCodigo();
            Data novaData = dataComp.criarDataIncrementada(1);
            String compNovo = compromisso + " " + i + code;

            controladorAgenda.inserirCompromisso(new Compromisso(code, compNovo, novaData, horario));

            dataComp = novaData;
        }
    }

    private void agendarVariosCompromissosPorVariasSemanas()
    {

    }

    private void excluirCompromissoCodigo()
    {
        boolean ok = false;
        int codRem = controladorAgenda.getMaiorCodigo() - 1;
        int code = Entrada.leiaInt("Informe um código para remover", codRem);

        boolean result = controladorAgenda.removerCompromissoCodigo(code);
        if ( result )
        {
            System.out.println("Sucesso ao remover o compromisso código " + code);
        }
        else
        {
            System.out.println("Impossivel remover!");
        }
    }

    private void excluirCompromissoData()
    {
        String hj = Data.criarData().toString();
        String dtRemover = Entrada.leiaString("Informe uma data para remover ", hj);
        Data dataRem = new Data(dtRemover);

        if ( controladorAgenda.procurarCompromissoData(dataRem) != null )
        {
            controladorAgenda.removerCompromissoData(dataRem);
            System.out.println("Sucesso ao remover data!!!");
        }
        else
        {
            System.out.println("Não foi possivel remover!!!");
        }
    }

    private void editarCompromisso()
    {

        int codigo = Entrada.leiaInt("Informe o código");

        if ( controladorAgenda.procurarCompromissoCodigo(codigo) != null )
        {
            int code = controladorAgenda.procurarCompromissoCodigo(codigo).getCodigo();
            String compromissoOld = controladorAgenda.procurarCompromissoCodigo(codigo).getCompromisso();
            String dataCompromissoOld = controladorAgenda.procurarCompromissoCodigo(codigo).getDataCompromisso().toString();
            String horarioOld = controladorAgenda.procurarCompromissoCodigo(codigo).getHorario();

            String compromisso = Entrada.leiaString("Informe o compromisso: ", compromissoOld);
            String dataCompromisso = Entrada.leiaString("Informe a Data: ", dataCompromissoOld);
            String horario = Entrada.leiaString("Informe o horario: ", horarioOld);

            Data dataComp = new Data(dataCompromisso);

            Compromisso comp = new Compromisso(compromisso, dataComp, horario);

            controladorAgenda.editarCompromisso(codigo, comp);
            System.out.println("Sucesso ao editar!!!");
        }
        else
        {
            System.out.println("O código: " + codigo + " não foi encontrado!!!");
        }
    }

    public void localizarCompromissoCodigo()
    {
        int max = controladorAgenda.getMaiorCodigo() - 1;
        int code = Entrada.leiaInt("Informe um código para localizar", max);

        Compromisso t = controladorAgenda.procurarCompromissoCodigo(code);

        if ( t != null )
        {
            System.out.println(t.getCodigo() + " | " + t.getCompromisso() + " | " + t.getDataCompromisso() + " | " + t.getHorario());
        }
        else
        {
            System.out.println("Nada localizado");
        }
    }

    public void localizarCompromissoData()
    {
        String hj = new Data().obterData();
        String dt = Entrada.leiaString("Informe uma data para localizar", hj);
        Data nova = new Data(dt);

        if ( controladorAgenda.procurarCompromissoData(nova) != null )
        {
            ArrayList<Compromisso> c = controladorAgenda.procurarElistarCompromissosData(nova);

            for ( Compromisso st : c )
            {
                System.out.println(" | " + st.getCodigo() + " | " + st.getCompromisso() + " | " + st.getDataCompromisso() + " | " + st.getHorario());

            }
        }
        else
        {
            System.out.println("Nada encontrado com essa data!!!");
        }
    }

    public void listar()
    {
        for ( Compromisso c : controladorAgenda.listarTodosOsCompromissos() )
        {
            System.out.println(" | " + c.getCodigo() + " | " + c.getCompromisso() + " | " + c.getDataCompromisso() + " | " + c.getHorario() + " | ");

        }
    }

    public void listarEntreDatas()
    {
        Data hj = new Data();
        String d1 = Entrada.leiaString("Data inicial", hj.obterData());
        String d2 = Entrada.leiaString("Data Final", hj.criarDataIncrementada(30).toString());

        Data dt1 = new Data(d1);
        Data dt2 = new Data(d2);

        for ( Compromisso c : controladorAgenda.listarEntreDatas(dt1, dt2) )
        {
            System.out.println(" | " + c.getCodigo() + " | " + c.getCompromisso() + " | " + c.getDataCompromisso() + " | " + c.getHorario() + " | ");
        }
    }

}
