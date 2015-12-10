package agenda.controle;

import agenda.negocio.Compromisso;
import java.util.ArrayList;

/**
 *
 * @author joao
 */
public interface ControladorV2Interface
{

    int getMaiorCodigo();

    void inserirCompromisso(Compromisso comp);

    ArrayList<Compromisso> listarTodosOsCompromissos();

    boolean removerCompromissoCodigo(int code);
    
}
