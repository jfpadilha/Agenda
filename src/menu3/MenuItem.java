package menu3;

public class MenuItem
{
    public MenuAction action;
    public String name;
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    public void setMenuAction(MenuAction action)
    {
        this.action = action;
    }

    public MenuAction getMenuAction()
    {
        return action;
    }
}
