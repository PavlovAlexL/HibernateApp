package models;

import javax.persistence.*;
@Entity
@Table(name = "autos")
public class Auto {

   @Id
   @GeneratedValue
   private int id;
   @Column(name = "model")
   private String model;
   @Column(name = "color")
   private String color;

   //@ManyToOne многим Auto может соответствовать один User/
   //@JoinColumn указывает, через какой столбец в таблице autos происходит связь с таблицей users (тот самый внешний ключ)

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "user_id")
   private User user;
   public Auto(){
   }


   public Auto(String model, String color) {
       this.model = model;
       this.color = color;
   }
   public int getId() {
           return id;
   }
   public String getModel(String model){
           return model;
   }
   public void setModel(String model){
           this.model = model;
   }
   public String getColor() {
           return color;
   }
   public void setColor(String color){
           this.color = color;
   }
   public User getUser() {
           return user;
   }
   public void setUser(User user){
           this.user = user;
   }
   @Override
   public String toString(){
       return color + " " + model;
   }




}
