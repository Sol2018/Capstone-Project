package Order;

import element.htmlElement;

import java.util.Comparator;

public class dateOrder implements Comparator<htmlElement> {
    @Override
    public int compare(htmlElement e1, htmlElement e2) {
        if (e1.getLastmodified().after(e2.getLastmodified())) {
            return 1;
        } else {
            return -1;
        }
    }
}