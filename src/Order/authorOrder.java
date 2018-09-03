package Order;

import element.htmlElement;

import java.util.Comparator;

public class authorOrder implements Comparator<htmlElement> {
    @Override
    public int compare(htmlElement e1, htmlElement e2) {
        if (e1.getAuthor().compareTo(e2.getAuthor()) >= 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
