import java.util.Comparator;

public class Tri implements Comparator<Client> {

    @Override
    public int compare(Client c1, Client c2) {
        if (c1.getCode() == c2.getCode())
            return 1;
    else return -1;
    }

}
