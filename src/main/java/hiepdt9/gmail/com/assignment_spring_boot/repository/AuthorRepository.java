package hiepdt9.gmail.com.assignment_spring_boot.repository;

import hiepdt9.gmail.com.assignment_spring_boot.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {
}
