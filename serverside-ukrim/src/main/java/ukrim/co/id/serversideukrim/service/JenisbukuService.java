/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukrim.co.id.serversideukrim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ukrim.co.id.serversideukrim.model.Jenisbuku;
import ukrim.co.id.serversideukrim.repository.JenisbukuRepository;

/**
 *
 * @author MSI-JO
 */
@Service
public class JenisbukuService {

    private JenisbukuRepository jenisbukuRepository;

    @Autowired
    public JenisbukuService(JenisbukuRepository jenisbukuRepository) {
        this.jenisbukuRepository = jenisbukuRepository;
    }

    public List<Jenisbuku> getAll() {
        return jenisbukuRepository.findAll();
    }

    public Jenisbuku getById(Long id) {
        return jenisbukuRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jenisbuku not found"));
    }

    public Jenisbuku create(Jenisbuku jenisbuku) {
        if (jenisbukuRepository.findByName(jenisbuku.getName()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Jenisbuku name already exists");
        }
        return jenisbukuRepository.save(jenisbuku);
    }

    public Jenisbuku update(Long id, Jenisbuku jenisbuku) {
        getById(id);
        jenisbuku.setId(id);
        return jenisbukuRepository.save(jenisbuku);
    }

    public Jenisbuku delete(Long id) {
        Jenisbuku jenisbuku = getById(id);
        jenisbukuRepository.delete(jenisbuku);
        return jenisbuku;
    }

}
