package calorietracker.models;

public class NutriInfo extends Model {
    String nama;
    int energi, berat;
    double protein, lemak, karbohidrat;
    boolean isSelected; 

    public NutriInfo(int id, String nama, int energi, double protein, double lemak, double karbohidrat,int berat) {
        super(id);
        this.nama = nama;
        this.energi = energi;
        this.protein = protein;
        this.lemak = lemak;
        this.karbohidrat = karbohidrat;
        this.berat = berat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getEnergi() {
        return energi;
    }

    public void setEnergi(int energi) {
        this.energi = energi;
    }

    public int getBerat() {
        return berat;
    }

    public void setBerat(int berat) {
        this.berat = berat;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getLemak() {
        return lemak;
    }

    public void setLemak(double lemak) {
        this.lemak = lemak;
    }

    public double getKarbohidrat() {
        return karbohidrat;
    }

    public void setKarbohidrat(double karbohidrat) {
        this.karbohidrat = karbohidrat;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

}