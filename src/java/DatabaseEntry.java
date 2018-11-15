
public class DatabaseEntry {

    int id;
    String imie;
    String nazwisko;
    String miasto;
    String numerTelefonu;
    String grupa;

    public DatabaseEntry() {

    }

    public DatabaseEntry(int id,
            String imie,
            String nazwisko,
            String miasto,
            String numerTelefonu,
            String grupa) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.miasto = miasto;
        this.numerTelefonu = numerTelefonu;
        this.grupa = grupa;
    }

    /**
     * @return the imie
     */
    public String getImie() {
        return imie;
    }

    /**
     * @param imie the imie to set
     */
    public void setImie(String imie) {
        this.imie = imie;
    }

    /**
     * @return the nazwisko
     */
    public String getNazwisko() {
        return nazwisko;
    }

    /**
     * @param nazwisko the nazwisko to set
     */
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    /**
     * @return the miasto
     */
    public String getMiasto() {
        return miasto;
    }

    /**
     * @param miasto the miasto to set
     */
    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    /**
     * @return the numerTelefonu
     */
    public String getNumerTelefonu() {
        return numerTelefonu;
    }

    /**
     * @param numerTelefonu the numerTelefonu to set
     */
    public void setNumerTelefonu(String numerTelefonu) {
        this.numerTelefonu = numerTelefonu;
    }

    /**
     * @return the grupa
     */
    public String getGrupa() {
        return grupa;
    }

    /**
     * @param grupa the grupa to set
     */
    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
