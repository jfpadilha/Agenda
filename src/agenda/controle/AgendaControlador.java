package agenda.controle;

import agenda.negocio.Compromisso;
import core.Arquivo;
import core.BancoDados;
import core.Data;
import core.Entrada;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author jfpsouza
 */
public class AgendaControlador implements ControladorV1Interface
{

    private final ArrayList<Compromisso> agenda;

    //Construtores
    public AgendaControlador()
    {
        this.agenda = new ArrayList();
        carregarDb();
        
    }

    public ArrayList<Compromisso> getAgenda()
    {
        return agenda;
    }

    @Override
    public void inserirCompromisso(Compromisso compromisso)
    {
        agenda.add(compromisso);
        gravarNaBase(compromisso);
    }

    public void excluirCompromisso(Compromisso compromisso)
    {
        agenda.remove(compromisso);
        gravarNaBase(compromisso);
    }

    public void editarCompromisso(Compromisso compromisso)
    {
        gravarNaBase(compromisso);
    }

    @Override
    public Compromisso procurar(int codigo)
    {
        Compromisso compromissoEncontrado = null;
        for (Compromisso compromisso : agenda)
        {
            if (compromisso.getCodigo() == codigo)
            {
                compromissoEncontrado = compromisso;
            }
        }
        return compromissoEncontrado;
    }

    public Compromisso procurarData(Data data)
    {
        Compromisso compromissoEncontrado = null;

        for (Compromisso dataCompromisso : agenda)
        {
            if (dataCompromisso.getDataCompromisso().éIgual(data))
            {
                compromissoEncontrado = dataCompromisso;
            }
        }
        return compromissoEncontrado;
    }

    //Localiza os compromissos desde a data atual (hoje)
    //até a data informada
    @Override
    public ArrayList consultarIntervalo(Data dataFinal)
    {
        ArrayList compromissosLocalizados = null;
        Data hoje = new Data();

        for (Compromisso compromisso : agenda)
        {
            while (compromisso.getDataCompromisso().éIgual(dataFinal))
            {
                compromissosLocalizados.add(compromisso);

            }
            hoje.incrementarUmDia();
        }
        return compromissosLocalizados;
    }

    public void gravarNaBase(Compromisso comp)
    {
        BancoDados db = new BancoDados("agenda");
        criarTabelas(db);

        db.conectar();
        db.executarSQL("INSERT INTO agenda VALUES ('" + comp.getCodigo() + "' , '" + comp.getCompromisso() + "', '" + comp.getDataCompromisso() + "', '" + comp.getHorario() + "')");
        ResultSet rs = db.executarConsultaSQL("SELECT * FROM agenda");
        try
        {
            while (rs.next())
            {
                int codigo = rs.getInt("codigo");
                String compromisso = rs.getString("compromisso");
                String datacompromisso = rs.getString("datacompromisso");
                String horario = rs.getString("horario");

                System.out.println(codigo);
                System.out.println(compromisso);
                System.out.println(datacompromisso);
                System.out.println(horario);
            }
        }
        catch (Exception e)
        {
            System.out.println("Erro ao salvar dados");
        }
        db.fechar();
    }

    public static void criarTabelas(BancoDados db)
    {
        db.conectar();
        db.executarSQL("CREATE TABLE  IF NOT EXISTS agenda(codigo INT NOT NULL, compromisso VARCHAR (150), dataCompromisso DATE, horario VARCHAR(5), CONSTRAINT pkAgenda PRIMARY KEY (codigo))");
        db.fechar();
    }

    private void carregarDb()
    {
        BancoDados db = new BancoDados("agenda");
        db.conectar();
        ResultSet carreg = db.executarConsultaSQL("SELECT * FROM agenda");
        try
        {
            while (carreg.next())
            {
                int codigo = carreg.getInt("codigo");
                String compromisso = carreg.getString("compromisso");
                String datacompromisso = carreg.getString("datacompromisso");
                String horario = carreg.getString("horario");

                System.out.println("Código: " + codigo + " | Compromisso: " + compromisso + " |             Data do compromisso" + datacompromisso + " | Horario: " + horario);

                Data nd = new Data(datacompromisso);
                Compromisso ag = new Compromisso(codigo, compromisso, nd, horario);
                this.agenda.add(ag);
            }

        }
        catch (Exception e)
        {
            System.out.println("Erro ao carregar dados");
        }
        db.fechar();
    }
}
