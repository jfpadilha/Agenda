package menu3;

import core.Entrada;
import java.util.ArrayList;

public class Menu 
{
    private ArrayList<MenuItem> items;

    public Menu()
    {
        this.items = new ArrayList();
    }
    
    public void gerar()
    {
        String menu = "";
        for (int i = 0; i < items.size(); i++)
        {
            menu += (i+1)+") "+items.get(i).getName()+"\n";
        }
        menu += "0) Sair";
        int op = -1;
        while (op != 0)
        {
            op = Entrada.leiaInt(menu);
            if (op > 0 && op <= items.size())
            {
                items.get(op-1).getMenuAction().run();
            }
        }
    }

    public MenuItem getMenuItem(int index)
    {
        return items.get(index);
    }

    public void addItem(MenuItem item)
    {
        this.items.add(item);
    }

    
    
    

}
