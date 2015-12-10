package agenda.controle;

import agenda.negocio.Compromisso;
import core.Data;
import core.Entrada;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;

/**
 * Classe auxiliar implementada da TableModel ajuda na implementação de telas
 * com tabelas
 *
 * @author Joao Francisco Padilha Souza
 * @version 01/05/2015
 *
 */
public class AgendaTableModel implements TableModel
{

    AgendaControladorV2 controlador;

    public AgendaTableModel(AgendaControladorV2 controlador)
    {
        this.controlador = controlador;
    }

    @Override
    public int getRowCount()
    {
        return controlador.listarTodosOsCompromissos().size();
    }

    @Override
    public int getColumnCount()
    {
        return 4;//a relação "agenda" da base de dados "agenda" tem 4 colunas
    }

    @Override
    public String getColumnName(int columnIndex)
    {
        String name = "";
        ArrayList cols = new ArrayList();

        cols.add("Código");
        cols.add("Compromisso");
        cols.add("Data");
        cols.add("Horario");

        for ( int i = 0; i < cols.size(); i++ )
        {
            if ( columnIndex == i )
            {
                name = (String) cols.get(i);
            }
        }
        return name;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        Class aux = String.class;
        ArrayList k = new ArrayList();

        k.add(Integer.class);
        k.add(String.class);
        k.add(Data.class);
        k.add(String.class);

        for ( int i = 0; i < k.size(); i++ )
        {
            if ( columnIndex == i )
            {
                aux = (Class) k.get(i);
            }
        }
        return aux;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Compromisso comps = controlador.listarTodosOsCompromissos().get(rowIndex);

        Object ob = null;

        ArrayList j = new ArrayList();
        j.add(comps.getCodigo());
        j.add(comps.getCompromisso());
        j.add(comps.getDataCompromisso());
        j.add(comps.getHorario());

        for ( int i = 0; i < j.size(); i++ )
        {
            if ( columnIndex == i )
            {
                ob = j.get(i);
            }
        }

        return ob;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
    }

    @Override
    public void addTableModelListener(TableModelListener l)
    {
    }

    @Override
    public void removeTableModelListener(TableModelListener l)
    {
    }

}
