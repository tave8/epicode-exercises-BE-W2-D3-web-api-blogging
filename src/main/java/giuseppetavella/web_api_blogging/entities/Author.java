package giuseppetavella.web_api_blogging.entities;

import java.time.LocalDate;
import java.util.UUID;

public class Author {
    
    private final UUID id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataNascita;
    
    public Author(String nome, String cognome, String email, LocalDate dataNascita) {
        this.setNome(nome);
        this.setCognome(cognome);
        this.setEmail(email);
        this.setDataNascita(dataNascita);
        this.id = UUID.randomUUID();
    }

    public String getAvatarUrl() {
        String nomeCompleto = this.getNome() + "+" + this.getCognome();
        return "https://ui-avatars.com/api/?name=" + nomeCompleto;
    }
    
    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Author{" +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", dataNascita=" + dataNascita +
                '}';
    }
}
