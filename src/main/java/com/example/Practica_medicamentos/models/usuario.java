package com.example.Practica_medicamentos.models;

import jakarta.persistence.*;

@Entity
@Table(name="usuarios")
public class usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private int edad;
    @ManyToOne
    @JoinColumn(name = "idTipoUsuario")
    private tipo_usuario idTipoUsuario;
    @ManyToOne
    @JoinColumn(name = "especialidad_id")
    private especialidad idEspecialidad;
    private Boolean estado;

    public usuario() {}
    public usuario(Long id,String nombre, String apellido, String correo, int edad, tipo_usuario idTipoUsuario, especialidad idEspecialidad, Boolean estado) {
        this.id=id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.edad = edad;
        this.idTipoUsuario = idTipoUsuario;
        this.idEspecialidad = idEspecialidad;
        this.estado=estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public tipo_usuario getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(tipo_usuario idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public especialidad getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(especialidad idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
