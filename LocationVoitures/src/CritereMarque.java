public class CritereMarque implements Critere{
    private String marque;
    CritereMarque(String marque) {
        this.marque = marque;
    }
    @Override
    public boolean estSatisfaitPar(Voiture v) {
        return v.getMarque().equals(marque);
    }
}
