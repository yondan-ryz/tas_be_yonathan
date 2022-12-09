package ukrim.co.id.serversideukrim.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ukrim.co.id.serversideukrim.model.Buku;
import ukrim.co.id.serversideukrim.repository.BukuRepository;

@Service
@AllArgsConstructor
public class BukuService {

    private BukuRepository BukuRepository;

    public List<Buku> getAll() {
        return BukuRepository.findAll();
    }

    public Buku getById(Long id) {
        return BukuRepository
                .findById(id)
                .orElseThrow(()
                        -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Buku not found")
                );
    }

    public Buku create(Buku Buku) {
        if (Buku.getId() != null) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Buku already exists"
            );
        }
        if (BukuRepository.existsByName(Buku.getName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Buku name already exists");
        }
        return BukuRepository.save(Buku);
    }

    public Buku update(Long id, Buku Buku) {
        getById(id);
        Buku.setId(id);
        return BukuRepository.save(Buku);
    }

    public Buku delete(Long id) {
        Buku Buku = getById(id);
        BukuRepository.delete(Buku);
        return Buku;
    }
}
