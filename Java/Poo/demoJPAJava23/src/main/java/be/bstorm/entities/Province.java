package be.bstorm.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Province implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String name;

    @OrderBy("name")
    @OneToMany(mappedBy = "province",
               fetch = FetchType.EAGER)
    private List<Municipality> municipalities;

    public Province(){
        this.municipalities = new ArrayList<>();
    }

    public Province(String name){
        this();
        setName(name);
    }

    public List<Municipality> getMunicipalities() {

        return new ArrayList<>(this.municipalities);
    }

    public void addMunicipality(Municipality m){

        this.municipalities.add(m);
    }

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
