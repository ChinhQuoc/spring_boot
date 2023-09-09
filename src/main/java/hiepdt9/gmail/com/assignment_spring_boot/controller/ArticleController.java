package hiepdt9.gmail.com.assignment_spring_boot.controller;

import hiepdt9.gmail.com.assignment_spring_boot.entity.ArticleEntity;
import hiepdt9.gmail.com.assignment_spring_boot.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/baiviet")
public class ArticleController {
    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("")
    public ResponseEntity<List<ArticleEntity>> getArticles() {
        List<ArticleEntity> articles = articleRepository.findAll();

        return new ResponseEntity<List<ArticleEntity>>(articles, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> saveArticle(@RequestParam String title, @RequestParam String content, @RequestParam Date startDate, @RequestParam int idAuthor) {
        ArticleEntity article = new ArticleEntity();
        article.setTitle(title);
        article.setContent(content);
        article.setStartDate(startDate);
        article.setIdAuthor(idAuthor);

        articleRepository.save(article);

        return new ResponseEntity<>("Tạo bài viết thành công", HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<?> updateArticle(@RequestParam int id, @RequestParam String title, @RequestParam String content, @RequestParam Date startDate, @RequestParam int idAuthor) {
        ArticleEntity article = new ArticleEntity();
        article.setId(id);
        article.setTitle(title);
        article.setContent(content);
        article.setStartDate(startDate);
        article.setIdAuthor(idAuthor);

        articleRepository.save(article);

        return new ResponseEntity<>("Cập nhật bài viết thành công", HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteArticle(@RequestParam int id) {
        ArticleEntity article = new ArticleEntity();
        article.setId(id);

        articleRepository.delete(article);

        return new ResponseEntity<>("Xóa bài viết thành công", HttpStatus.OK);
    }
}
