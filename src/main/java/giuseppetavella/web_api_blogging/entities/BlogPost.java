package giuseppetavella.web_api_blogging.entities;

import java.util.UUID;

public class BlogPost {

    private final UUID id;
    private String categoria;
    private String titolo;
    private String contenuto;
    private int tempoDiLettura;

    public BlogPost(String titolo, String categoria, String contenuto, int tempoDiLettura) {
        this.setTitolo(titolo);
        this.setCategoria(categoria);
        this.setContenuto(contenuto);
        this.setTempoDiLettura(tempoDiLettura);
        this.id = UUID.randomUUID();
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public int getTempoDiLettura() {
        return tempoDiLettura;
    }

    public void setTempoDiLettura(int tempoDiLettura) {
        this.tempoDiLettura = tempoDiLettura;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public UUID getId() {
        return id;
    }

    public String getCover() {
        return "https://fastly.picsum.photos/id/217/200/300.jpg?hmac=3GPQ-pPnL4D8miCKA0qNqIg4zr5Ponvl9OVH83CeGuc";
    }
    
}
