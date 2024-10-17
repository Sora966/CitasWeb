package com.example.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "cita")
public class Cita implements Serializable, Comparable<Cita> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private int idCita;

    @Column(name = "codigo_cita")
    private String codigoCita;

    @Column(name = "fecha_cita")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCita;

    private String activo;
    private String completado;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "id_consultorio", referencedColumnName = "id_consultorio")
    private Consultorio idConsultorio;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "id_medico", referencedColumnName = "id_usuario")
    private Medico idMedico;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Paciente idUsuario;

    @Override
    public int compareTo(Cita o) {
        return Integer.compare(this.idConsultorio.getIdConsultorio(), o.getIdConsultorio().getIdConsultorio());
    }
}