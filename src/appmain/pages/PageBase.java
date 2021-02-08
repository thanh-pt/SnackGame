package appmain.pages;

import java.awt.*;

public abstract class PageBase {
    protected IPageListener client = null;
    public void setClient(IPageListener clientObj){
        client = clientObj;
    }
    public abstract Container getContainer();
}
