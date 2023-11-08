import java.util.Comparator;
    public class TriNom implements Comparator<Client> {
        public int compare (Client c1, Client c2){
            return c1.getNom().compareTo(c2.getNom());
        }
    }

