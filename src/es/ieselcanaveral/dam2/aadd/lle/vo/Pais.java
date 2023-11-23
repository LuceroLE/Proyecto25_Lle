package es.ieselcanaveral.dam2.aadd.lle.vo;

public class Pais {
    private int codigoPais;
    private String nombrePais;
    private String capitalPais;
    //Como continente es PK su tipo es Continente.
    private Continente continente;

    // Constructor
    public Pais(int codigoPais, String nombrePais, String capitalPais, Continente continente) {
        this.codigoPais = codigoPais;
        this.nombrePais = nombrePais;
        this.capitalPais = capitalPais;
        this.continente = continente;
    }

    // Getters y setters
    public int getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(int codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getCapitalPais() {
        return capitalPais;
    }

    public void setCapitalPais(String capitalPais) {
        this.capitalPais = capitalPais;
    }

    public Continente getContinente() {
        return continente;
    }

    public void setContinente(Continente continente) {
        this.continente = continente;
    }
    
    @Override
    public String toString() {
        return "Código País: " + codigoPais + ", Nombre País: " + nombrePais + ", Capital País: " + capitalPais + "\n" + "Continente: " + continente;
    }

}
