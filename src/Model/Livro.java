package Model;

// CRIAÇÃO DO OBJETO LIVRO

public class Livro {

    // atributos
    private String titulo;
    private String autor;
    private Integer ano;


    // construtor

    public Livro(String titulo, String autor, Integer ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    // getters

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Integer getAno() {
        return ano;
    }

    // setters

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    //toString

    @Override
    public String toString(){
        return "Título: " + titulo + "\nAutor: "
                + autor + "\nAno: " + ano;

    }



}
