package models;

public class Estudiante {
    private String name;
    private double nota;
    
    //Constructor lleno
    public Estudiante(String name, double nota) {
        this.name = name;
        this.nota = nota;
    }

    //Constructor vacio
    public Estudiante() {
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}

