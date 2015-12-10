package agenda.controle;

import agenda.negocio.Compromisso;
import core.Data;
import java.util.ArrayList;

/**
 *
 * @author joao
 */
public interface ControladorV1Interface
{

    //Localiza os compromissos desde a data atual (hoje)
    //até a data informada
    ArrayList consultarIntervalo(Data dataFinal);

    void inserirCompromisso(Compromisso compromisso);

    Compromisso procurar(int codigo);
    
    
    
}
