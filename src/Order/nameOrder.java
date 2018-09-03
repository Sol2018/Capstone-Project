package Order;

import element.htmlElement;

import java.util.Comparator;

public class nameOrder implements Comparator<htmlElement> {
    @Override
    public int compare(htmlElement e1, htmlElement e2) {
        if (e1.getName().compareTo(e2.getName()) >= 0) {
            return 1;
        } else {
            return -1;
        }
    }
}