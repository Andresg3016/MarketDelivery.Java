package com.proyecto.MarketDelivery.controller;

import com.proyecto.MarketDelivery.model.Agenda;
import com.proyecto.MarketDelivery.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendas")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @GetMapping
    public List<Agenda> getAllAgendas() {
        return agendaService.getAllAgendas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agenda> getAgendaById(@PathVariable Long id) {
        return agendaService.getAgendaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Agenda createAgenda(@RequestBody Agenda agenda) {
        return agendaService.saveAgenda(agenda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agenda> updateAgenda(@PathVariable Long id, @RequestBody Agenda agenda) {
        return agendaService.getAgendaById(id)
                .map(existing -> {
                    agenda.setId(id);
                    return ResponseEntity.ok(agendaService.saveAgenda(agenda));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgenda(@PathVariable Long id) {
        agendaService.deleteAgenda(id);
        return ResponseEntity.noContent().build();
    }
}
