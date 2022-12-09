/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukrim.co.id.serversideukrim.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ukrim.co.id.serversideukrim.model.Jenisbuku;

/**
 *
 * @author MSI-JO
 */
@Repository
public interface JenisbukuRepository extends JpaRepository<Jenisbuku, Long>{
    Optional<Jenisbuku> findByName(String name);
//Select * FROM user WHERE name="?1"   
}
