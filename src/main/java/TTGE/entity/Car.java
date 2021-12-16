package TTGE.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column
  @NotBlank(message = "Mark can't be blank")
  private String mark;
  @Column
  @NotBlank(message = "Model can't be blank")
  private String model;
  @Column
  @Min(value=1900, message="Can't be earlier than 1900")
  @Max(value=2021, message="Can't be later than 2021")
  private Integer year;
  @Column
  @NotNull(message = "Price can't be null")
  private Double price;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "buyer_id", referencedColumnName = "id")
  private Buyer buyer;

  public Car() {
  }

  public Car(Long id, String mark, String model, Integer year, Double price, Buyer buyer) {
    this.id = id;
    this.mark = mark;
    this.model = model;
    this.year = year;
    this.price = price;
    this.buyer = buyer;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMark() {
    return mark;
  }

  public void setMark(String mark) {
    this.mark = mark;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Buyer getBuyer() {
    return buyer;
  }

  public void setBuyer(Buyer buyer) {
    this.buyer = buyer;
  }
}
