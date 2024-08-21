package ccmello.simplestore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select id, category, name, quantity, available from product where category = ?1", nativeQuery = true)
    List<Product> findByCategory(String category);
}
