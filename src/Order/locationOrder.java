package Order;

import element.htmlElement;

import java.util.Comparator;

public class locationOrder implements Comparator<htmlElement>
{
    @Override
    public int compare(htmlElement e1, htmlElement e2)
    {
        return Integer.compare(e1.getLocation().compareTo(e2.getLocation()), 0);
    }
}