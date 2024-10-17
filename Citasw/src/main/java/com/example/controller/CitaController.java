package com.example.controller;

import com.example.model.Cita;
import com.example.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Date;

@RestController
@RequestMapping("/citas")
public class CitaController {
    @Autowired
    private CitaService citaService;

    @GetMapping
    public List<Cita> getAllCitas() {
        return citaService.findAll();
    }

    @GetMapping("/{id}")
    public Cita getCitaById(@PathVariable int id) {
        return citaService.findById(id);
    }

    @GetMapping("/codigo/{codigoCita}")
    public Cita getCitaByCodigoCita(@PathVariable String codigoCita) {
        return citaService.findByCodigoCita(codigoCita);
    }

    @GetMapping("/fecha/{fechaCita}/paciente/{idPaciente}")
    public List<Cita> getCitaByFechaCitaAndPaciente(@PathVariable Date fechaCita, @PathVariable int idPaciente) {
        return citaService.findByFechaCitaAndPaciente(fechaCita, idPaciente);
    }

    @GetMapping("/test")
    public List<Object[]> test(@RequestParam Date fechaCita, @RequestParam int idPaciente) {
        return citaService.test(fechaCita, idPaciente);
    }

    @PostMapping
    public Cita createCita(@RequestBody Cita cita) {
        return citaService.save(cita);
    }

    @DeleteMapping("/{id}")
    public void deleteCita(@PathVariable int id) {
        citaService.deleteById(id);
    }
}