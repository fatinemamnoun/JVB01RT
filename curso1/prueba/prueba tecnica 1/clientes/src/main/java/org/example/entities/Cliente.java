package org.example.entities;

import jakarta.persistence.*;

@Entity(name ="clientes")
public class Cliente {
    //nombre, apellidos, sexo, ciudad, fecha de nacimiento, teléfono, Email

  /*atributos*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

   @Column
    private String nombre;

   @Column
    private String apellidos;

   @Column
    private String sexo;

   @Column
    private String ciudad;

   @Column
    private String fechaDeNacimiento;

   @Column
    private int telefono;

   @Column
    private String Email;


    //constructores


    public Cliente() {
    }

    public Cliente(Integer id, String nombre, String apellidos, String sexo, String ciudad, String fechaDeNacimiento, int telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.ciudad = ciudad;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.telefono = telefono;
        Email = email;
    }



//getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", sexo='" + sexo + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", fechaDeNacimiento='" + fechaDeNacimiento + '\'' +
                ", telefono=" + telefono +
                ", Email='" + Email + '\'' +
                '}';
    }
}