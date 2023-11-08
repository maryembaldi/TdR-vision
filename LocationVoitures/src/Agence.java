import java.util.*;

public class Agence {

    private String nom;
    private ListVoitures vs;

    private Map<Client, ListVoitures> ClientVoitureLoue;

    public Agence(String nom) {
        this.nom = nom;
        this.vs = new ListVoitures();
        this.ClientVoitureLoue = new HashMap<>();
    }

    public void ajoutVoiture(Voiture v) throws VoitureException {
        try {
            vs.ajoutVoiture(v);
        } catch (VoitureException e) {
            System.out.println("Erreur lors de l'ajout de la voiture : " + e.getMessage());
        }
    }

    public void suppVoiture(Voiture v) throws VoitureException {
        vs.supprimeVoiture(v);
    }

    public void loueClientVoiture(Client cl, Voiture v)throws VoitureException{
        if (!ClientVoitureLoue.containsKey(cl)) {
            ClientVoitureLoue.put(cl, new ListVoitures());
        }
        ListVoitures clientVoitures = ClientVoitureLoue.get(cl);
        clientVoitures.ajoutVoiture(v);
    }

    public void retourClientVoiture(Client cl , Voiture v) throws VoitureException{
        if (ClientVoitureLoue.containsKey(cl)) {
            ListVoitures clientVoitures = ClientVoitureLoue.get(cl);
            clientVoitures.supprimeVoiture(v);
        }
    }
    public List<Voiture> selectVoitureSelonCritere(Critere c){
        List<Voiture> result = new ArrayList<>();
        for (Voiture v : vs.getVoitures()) {
            if (c.estSatisfaitPar(v)) {
                result.add(v);
            }
        }
        return result;
    }
    public Set<Client> ensembleClientsLoueurs(){
        return ClientVoitureLoue.keySet();
    }
    public Collection<ListVoitures> collectionVoituresLouees(){
        return ClientVoitureLoue.values();
    }
    public void afficheLesClientsEtLeursListesVoitures(){
        for (Map.Entry<Client, ListVoitures> entry : ClientVoitureLoue.entrySet()) {
            Client client = entry.getKey();
            ListVoitures voituresLouees = entry.getValue();
            System.out.println("Client: " + client.toString());
            System.out.println("Voitures louées:");
            voituresLouees.affiche();
        }
    }
    public Map<Client, ListVoitures> triParCode() {
            Map<Client, ListVoitures> sortedMap = new TreeMap<>(new Tri());
            sortedMap.putAll(ClientVoitureLoue);
            return sortedMap;
        }
    public Map<Client, ListVoitures> triParNomCroissant() {
        Map<Client, ListVoitures> sortedMap = new TreeMap<>(new TriNom());
        sortedMap.putAll(ClientVoitureLoue);
        return sortedMap;
    }

    }

