package ifmt.cba.vo;

import jakarta.persistence.*;
@MappedSuperclass
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name; 

    // Getters Setters

    public String getName(){
        return this.name;
    }
    public int getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    


}
