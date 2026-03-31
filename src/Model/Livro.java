package Model;

// CRIAÇÃO DO OBJETO LIVRO

public class Livro {

    // atributos
    private String titulo;
    private String autor;
    private Integer ano;
    private Boolean disponivel;


    // construtor

    public Livro(String titulo, String autor, Integer ano, Boolean disponivel) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.disponivel = disponivel;
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

    public Boolean isDisponivel() {
        return disponivel;
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

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    // equals para não repetir o livro
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Livro livro = (Livro) o;

        return getAno().equals(livro.getAno()) &&
                getTitulo().equals(livro.getTitulo()) &&
                getAutor().equals(livro.getAutor());
    }

    //toString
    @Override
    public String toString(){
        return "Título: " + titulo + "\nAutor: "
                + autor + "\nAno: " + ano;

    }



}
