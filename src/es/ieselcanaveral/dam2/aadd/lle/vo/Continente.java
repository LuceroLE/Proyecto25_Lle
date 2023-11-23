package es.ieselcanaveral.dam2.aadd.lle.vo;

public class Continente {
	//Atributos:
    private String codigoContinente;
    private String nombreContinente;

    // Constructor:
    public Continente(String codigoContinente, String nombreContinente) {
        this.codigoContinente = codigoContinente;
        this.nombreContinente = nombreContinente;
    }

    // Getters y setters
    public String getCodigoContinente() {
        return codigoContinente;
    }

    public void setCodigoContinente(String codigoContinente) {
        this.codigoContinente = codigoContinente;
    }

    public String getNombreContinente() {
        return nombreContinente;
    }

    public void setNombreContinente(String nombreContinente) {
        this.nombreContinente = nombreContinente;
    }
    
    @Override
    public String toString() {
        return "Código Continente: " + codigoContinente + ", Nombre Continente: " + nombreContinente;
    }

}

