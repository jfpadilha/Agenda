package agenda.negocio;

import core.Data;
import core.Entrada;

/**
 *
 * @author jfpsouza
 */
public class Compromisso
{

    //Variaveis
    private static int codigoSeq = 0;
    private int codigo;
    private String compromisso;
    private Data dataCompromisso;
    private String horario;

    //construtores

    public Compromisso(String comp, Data dataCompromisso, String horario)
    {
        Compromisso.codigoSeq++;
        this.codigo = codigoSeq;
        this.compromisso = comp;
        this.dataCompromisso = dataCompromisso;
        this.horario = horario;
    }

    public Compromisso(int codigo, String compromisso, Data dataCompromisso, String horario)
    {
        this.codigo = codigo;
        Compromisso.codigoSeq = codigo;
        this.compromisso = compromisso;
        this.dataCompromisso = dataCompromisso;
        this.horario = horario;
    }
    
    //Setters

    private void setCodigo(int codigo)
    {
        this.codigo = getCodigoSeq();
    }        

    private static void setCodigoSeq(int codigoSeq)
    {
        Compromisso.codigoSeq = codigoSeq;
    }        

    public void setCompromisso(String Compromisso)
    {
        this.compromisso = Compromisso;
    }

    public void setDataCompromisso(Data dataCompromisso)
    {
        this.dataCompromisso = dataCompromisso;
    }

    public void setHorario(String horario)
    {
        this.horario = horario;
    }

    //Getters

    public int getCodigo()
    {
        return codigo;
    }

    public static int getCodigoSeq()
    {
        return codigoSeq;
    }

    public String getCompromisso()
    {
        return compromisso;
    }

    public Data getDataCompromisso()
    {
        return dataCompromisso;
    }

    public String getHorario()
    {
        return horario;
    }

}
