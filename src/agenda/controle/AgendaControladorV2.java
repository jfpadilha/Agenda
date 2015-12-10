package agenda.controle;

import agenda.negocio.Compromisso;
import core.BancoDados;
import core.Entrada;
import core.Data;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author joao
 */
public class AgendaControladorV2 implements ControladorV2Interface
{

    private final BancoDados db;

    public AgendaControladorV2()
    {
        db = new BancoDados("Agenda");
        db.conectar();
        db.executarSQL("CREATE TABLE IF NOT EXISTS agenda(codigo INT NOT NULL, compromisso VARCHAR (150) NOT NULL, dataCompromisso DATE NOT NULL, horario VARCHAR(5) NOT NULL, CONSTRAINT pkAgenda PRIMARY KEY (codigo))");
        db.fechar();
    }

    @Override
    public void inserirCompromisso(Compromisso comp)
    {
        String sql = "INSERT INTO agenda VALUES('"
                + comp.getCodigo() + " ', '"
                + comp.getCompromisso() + "', ' "
                + comp.getDataCompromisso() + "', '"
                + comp.getHorario() + "')";

        db.conectar();
        db.executarSQL(sql);
        db.fechar();
    }

    @Override
    public int getMaiorCodigo()
    {
        String sql = "SELECT MAX(codigo) AS max FROM agenda";
        int codigo = 0;
        db.conectar();
        ResultSet dados = db.executarConsultaSQL(sql);
        try
        {
            if ( dados.next() )
            {
                codigo = dados.getInt("max") + 1;
            }
        }
        catch ( Exception e )
        {
            System.out.println("Erro!");
        }
        finally
        {
            db.fechar();
        }
        return codigo;
    }

    public Compromisso procurarCompromissoCodigo(int code)
    {
        Compromisso compEncontrado = null;
        String sql = "SELECT * FROM agenda WHERE codigo = '" + code + "'";
        db.conectar();
        ResultSet dados = db.executarConsultaSQL(sql);

        try
        {
            if ( dados.next() )
            {
                int codigo = dados.getInt("codigo");
                String compromisso = dados.getString("compromisso");
                String dataCompromisso = dados.getString("datacompromisso");
                String horario = dados.getString("horario");

                Data nd = new Data(dataCompromisso);
                compEncontrado = new Compromisso(codigo, compromisso, nd, horario);
            }
        }
        catch ( Exception e )
        {
            System.out.println("Erro!");
        }
        finally
        {
            db.fechar();
        }

        return compEncontrado;
    }

    public Compromisso procurarCompromissoData(Data data)
    {
        Compromisso compEncontrado = null;
        String sql = "SELECT * FROM agenda WHERE datacompromisso = '" + data.toString() + "'";
        db.conectar();
        ResultSet dados = db.executarConsultaSQL(sql);
        try
        {
            if ( dados.next() )
            {
                int codigo = dados.getInt("codigo");
                String compromisso = dados.getString("compromisso");
                String dataCompromisso = dados.getString("datacompromisso");
                String horario = dados.getString("horario");
                Data nd = new Data(dataCompromisso);
                compEncontrado = new Compromisso(codigo, compromisso, nd, horario);
            }
        }
        catch ( Exception e )
        {
            System.out.println("Erro!");
        }
        finally
        {
            db.fechar();
        }
        return compEncontrado;
    }

    public boolean editarCompromisso(int code, Compromisso comp)
    {
        boolean ok = false;
        if ( procurarCompromissoCodigo(code) != null )
        {

            String sql = "UPDATE agenda SET (compromisso, datacompromisso, horario) = ('"
                    + comp.getCompromisso() + "','"
                    + comp.getDataCompromisso().toString() + "','"
                    + comp.getHorario() + "') WHERE codigo = '" + code + "'";

            db.conectar();
            db.executarSQL(sql);
            db.fechar();
            ok = true;
        }

        return ok;

    }

    public ArrayList<Compromisso> procurarElistarCompromissosCodigo(int code)
    {
        ArrayList<Compromisso> list = new ArrayList<>();

        Compromisso compEncontrado = null;

        String sql = "SELECT * FROM agenda WHERE codigo = '" + code + "' ORDER BY datacompromisso DESC";

        db.conectar();

        ResultSet dados = db.executarConsultaSQL(sql);

        try
        {
            while ( dados.next() )
            {
                int codigo = dados.getInt("codigo");
                String compromisso = dados.getString("compromisso");
                String dataCompromisso = dados.getString("datacompromisso");
                String horario = dados.getString("horario");

                Data nd = new Data(dataCompromisso);
                compEncontrado = new Compromisso(codigo, compromisso, nd, horario);

                list.add(compEncontrado);
            }
        }
        catch ( Exception e )
        {
            System.out.println("Erro!");
        }
        finally
        {
            db.fechar();
        }
        return list;
    }

    public ArrayList<Compromisso> procurarElistarCompromissosData(Data data)
    {
        ArrayList<Compromisso> list = new ArrayList<>();

        Compromisso compEncontrado = null;
        
        String sql = "SELECT * FROM agenda WHERE datacompromisso = '" + data.toString() + "'";

        db.conectar();

        ResultSet dados = db.executarConsultaSQL(sql);

        try
        {
            while ( dados.next() )
            {
                int codigo = dados.getInt("codigo");
                String compromisso = dados.getString("compromisso");
                String dataCompromisso = dados.getString("datacompromisso");
                String horario = dados.getString("horario");

                Data nd = new Data(dataCompromisso);
                compEncontrado = new Compromisso(codigo, compromisso, nd, horario);

                list.add(compEncontrado);
            }
        }
        catch ( Exception e )
        {
            System.out.println("Erro!");
        }
        db.fechar();
        return list;
    }

    public ArrayList<Compromisso> listarEntreDatas(Data d1, Data d2)
    {
        ArrayList<Compromisso> list = new ArrayList<>();
        Compromisso encontrados = null;

        String sql = "SELECT * FROM agenda WHERE datacompromisso BETWEEN '" + d1 + "' AND '" + d2 + "'";

        db.conectar();
        ResultSet dados = db.executarConsultaSQL(sql);

        try
        {
            while ( dados.next() )
            {
                int codigo = dados.getInt("codigo");
                String comp = dados.getString("compromisso");
                String data = dados.getString("datacompromisso");
                String horario = dados.getString("horario");

                Data nd = new Data(data);

                encontrados = new Compromisso(codigo, horario, nd, horario);
                list.add(encontrados);
            }
        }
        catch ( Exception e )
        {
            System.out.println("Erro!");
        }
        finally
        {
            db.fechar();
        }
        return list;
    }

    @Override
    public boolean removerCompromissoCodigo(int code)
    {
        boolean ok = false;
        if ( procurarCompromissoCodigo(code) != null )
        {
            String sql = "DELETE FROM agenda WHERE codigo = '" + code + "'";
            ok = true;
            db.conectar();
            db.executarSQL(sql);
            db.fechar();
        }
        return ok;
    }

    public boolean removerCompromissoData(Data data)
    {
        boolean ok = false;
        if ( procurarCompromissoData(data) != null )
        {
            String dt = data.toString();
            String sql = "DELETE FROM agenda WHERE datacompromisso = '" + dt + "'";
            db.conectar();
            db.executarSQL(sql);
            db.fechar();
        }
        return ok;
    }

    @Override
    public ArrayList<Compromisso> listarTodosOsCompromissos()
    {
        ArrayList<Compromisso> list = new ArrayList<>();

        String sql = "SELECT * FROM agenda ORDER BY datacompromisso DESC";

        db.conectar();
        ResultSet dados = db.executarConsultaSQL(sql);
        try
        {
            while ( dados.next() )
            {
                int codigo = dados.getInt("codigo");
                String comp = dados.getString("compromisso");
                String data = dados.getString("datacompromisso");
                String qeHorasZeh = dados.getString("horario");

                Data nt = new Data(data);

                Compromisso c = new Compromisso(codigo, comp, nt, qeHorasZeh);

                list.add(c);
            }
        }
        catch ( Exception e )
        {
            System.out.println("Erro!");
        }
        finally
        {
            db.fechar();
        }
        return list;
    }
}
