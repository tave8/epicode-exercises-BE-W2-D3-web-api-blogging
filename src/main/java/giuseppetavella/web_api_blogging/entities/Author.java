package giuseppetavella.web_api_blogging.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;


@Entity
@Table(name = "authors")
public class Author {
    
    @Id
    @GeneratedValue
    @Column(name = "author_id")
    private UUID authorId;
    
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;
    
    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "data_nascita", nullable = false)
    private LocalDate dataNascita;
    
    @Column(name = "avatar_url", nullable = false)
    private String avatarUrl;
    
    protected Author() {}
    
    public Author(String nome, String cognome, String email, LocalDate dataNascita) {
        this.setNome(nome);
        this.setCognome(cognome);
        this.setEmail(email);
        this.setDataNascita(dataNascita);
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

    public UUID getAuthorId() {
        return authorId;
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
                ", id=" + getAuthorId() +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", dataNascita=" + dataNascita +
                '}';
    }
}
