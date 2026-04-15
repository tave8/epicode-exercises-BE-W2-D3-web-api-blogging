package giuseppetavella.web_api_blogging.payloads;

import java.util.UUID;

public class NewBlogPostPayload {

    private String categoria;
    private String titolo;
    private String contenuto;
    private int tempoDiLettura;

    public NewBlogPostPayload(String titolo, String categoria, String contenuto, int tempoDiLettura) {
        this.titolo = titolo;
        this.categoria = categoria;
        this.contenuto = contenuto;
        // FIX 
        // if (tempoDiLettura == null) {
        //    
        // }
        this.tempoDiLettura = tempoDiLettura;
    }

    public String getCategoria() {
        return categoria;
    }



    public String getContenuto() {
        return contenuto;
    }


    public int getTempoDiLettura() {
        return tempoDiLettura;
    }

   

    public String getTitolo() {
        return titolo;
    }



}
