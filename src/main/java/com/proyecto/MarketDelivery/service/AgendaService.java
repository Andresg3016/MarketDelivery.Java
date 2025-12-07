package com.proyecto.MarketDelivery.service;

import com.proyecto.MarketDelivery.model.Agenda;
import com.proyecto.MarketDelivery.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    public List<Agenda> getAllAgendas() {
        return agendaRepository.findAll();
    }

    public Optional<Agenda> getAgendaById(int id) {
        return agendaRepository.findById(id);
    }

    public Agenda saveAgenda(Agenda a) {
        return agendaRepository.save(a);
    }

    public void deleteAgenda(int id) {
        agendaRepository.deleteById(id);
    }
}
