package ukrim.co.id.serversideukrim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ukrim.co.id.serversideukrim.model.Buku;

@Repository
public interface BukuRepository extends JpaRepository<Buku, Long> {
    Boolean existsByName(String name);
}
