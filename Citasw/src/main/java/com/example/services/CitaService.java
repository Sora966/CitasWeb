package com.example.services;

import com.example.model.Cita;
import com.example.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService {
    @Autowired
    private CitaRepository citaRepository;

    public List<Cita> findAll() {
        return citaRepository.findAll();
    }

    public Cita findById(int idCita) {
        return citaRepository.findByIdCita(idCita);
    }

    public Cita findByCodigoCita(String codigoCita) {
        return citaRepository.findByCodigoCita(codigoCita);
    }

    public List<Cita> findByFechaCitaAndPaciente(Date fechaCita, int idPaciente) {
        return citaRepository.findByFechaCitaAndPaciente(fechaCita, idPaciente);
    }

    public List<Object[]> test(Date fechaCita, int idPaciente) {
        return citaRepository.test(fechaCita, idPaciente);
    }

    public Cita save(Cita cita) {
        return citaRepository.save(cita);
    }

    public void deleteById(int idCita) {
        citaRepository.deleteById(idCita);
    }
}