import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ListVoitures {
    private List<Voiture> voitures;

    public ListVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }

    public ListVoitures() {
        this.voitures = new ArrayList<>();
    }

    public List<Voiture> getVoitures() {
        return voitures;
    }

    public void setVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }
    public void ajoutVoiture(Voiture v) throws VoitureException{
        voitures.add(v);
    }
    public void supprimeVoiture(Voiture v) throws VoitureException{
        voitures.remove(v);
    }
    public Iterator<Voiture> iterateur(){
        return voitures.iterator();
    }
    public int size(){
        return voitures.size();
    }
    public void affiche(){
        for (Voiture v : voitures) {
            System.out.println(v.toString());
        }
    }

}
