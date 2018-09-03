package Order;

import element.htmlElement;

import java.util.Comparator;

public class sizeOrder implements Comparator<htmlElement> {
    @Override
    public int compare(htmlElement e1, htmlElement e2) {
        if (e1.getSize() >= e2.getSize()) {
            return 1;
        } else {
            return -1;
        }
    }
}