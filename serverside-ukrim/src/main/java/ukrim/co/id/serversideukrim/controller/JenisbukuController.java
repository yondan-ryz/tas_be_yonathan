/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukrim.co.id.serversideukrim.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ukrim.co.id.serversideukrim.model.Jenisbuku;
import ukrim.co.id.serversideukrim.service.JenisbukuService;

/**
 *
 * @author MSI-JO
 */
@RestController
@RequestMapping("/jenisbuku")
public class JenisbukuController {

    private JenisbukuService jenisbukuService;

    @Autowired
    public JenisbukuController(JenisbukuService jenisbukuService) {
        this.jenisbukuService = jenisbukuService;
    }

    // http://localhost:8088/jenisbuku
    @GetMapping
    public List<Jenisbuku> getAll() {
        return jenisbukuService.getAll();
    }

    @GetMapping("/{id}")
    public Jenisbuku getById(@PathVariable Long id) {
        return jenisbukuService.getById(id);
    }
    // http://localhost:8088/jenisbuku/1   (PathVariable) Detail

    @PostMapping
    public Jenisbuku create(@RequestBody Jenisbuku jenisbuku) {
        return jenisbukuService.create(jenisbuku);
    }
    // http://localhost:8088/jenisbuku 

    @PutMapping("/{id}")
    public Jenisbuku update(@PathVariable Long id, @RequestBody Jenisbuku jenisbuku) {
        return jenisbukuService.update(id, jenisbuku);
    }
    // http://localhost:8088/jenisbuku/1

    @DeleteMapping("/{id}")
    public Jenisbuku delete(@PathVariable Long id) {
        return jenisbukuService.delete(id);
    }
    // http://localhost:8088/jenisbuku/1

}
