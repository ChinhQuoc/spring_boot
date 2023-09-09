package hiepdt9.gmail.com.assignment_spring_boot.repository;

import hiepdt9.gmail.com.assignment_spring_boot.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer> {
}
