package com.example.repository;

import com.example.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Integer> {
    List<Cita> findAll();

    @Query("SELECT c FROM Cita c WHERE c.idCita = :idCita")
    Cita findByIdCita(@Param("idCita") int idCita);

    @Query("SELECT c FROM Cita c WHERE c.codigoCita = :codigoCita")
    Cita findByCodigoCita(@Param("codigoCita") String codigoCita);

    @Query("SELECT c FROM Cita c WHERE c.fechaCita = :fechaCita AND c.idUsuario.idUsuario = :idPaciente")
    List<Cita> findByFechaCitaAndPaciente(@Param("fechaCita") Date fechaCita, @Param("idPaciente") int idPaciente);

    @Query("SELECT c.activo, c.codigoCita FROM Cita c WHERE c.fechaCita = :fechaCita AND c.idUsuario.idUsuario = :idPaciente")
    List<Object[]> test(@Param("fechaCita") Date fechaCita, @Param("idPaciente") int idPaciente);
}