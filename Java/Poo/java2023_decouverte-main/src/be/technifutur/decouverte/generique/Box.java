package be.technifutur.decouverte.generique;

public class Box<T> {

    private T contenu;

    public Box(T leContenu){
        this.contenu = leContenu;
    }

    public T getContenu() {
        return contenu;
    }

    public void setContenu(T contenu) {
        this.contenu = contenu;
    }
}
