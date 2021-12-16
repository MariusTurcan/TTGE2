package TTGE.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    @NotBlank(message = "Mark can't be blank")
    private String name;
    @Column
    @NotBlank(message = "Mark can't be blank")
    private String number;
    @Column
    @NotBlank(message = "Mark can't be blank")
    private String address;

    public Buyer() {
    }

    public Buyer(Long id, String name, String number, String address) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
