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
    public ResponseEntity<String> saveArticle(@RequestBody ArticleEntity newArticle) {
        ArticleEntity article = new ArticleEntity();
        article.setTitle(newArticle.getTitle());
        article.setContent(newArticle.getContent());
        article.setStartDate(newArticle.getStartDate());
        article.setIdAuthor(newArticle.getIdAuthor());

        articleRepository.save(article);

        return new ResponseEntity<String>("Tạo bài viết thành công", HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<String> updateArticle(@RequestBody ArticleEntity oldArticle) {
        ArticleEntity article = new ArticleEntity();
        article.setId(oldArticle.getId());
        article.setTitle(oldArticle.getTitle());
        article.setContent(oldArticle.getContent());
        article.setStartDate(oldArticle.getStartDate());
        article.setIdAuthor(oldArticle.getIdAuthor());

        articleRepository.save(article);

        return new ResponseEntity<String>("Cập nhật bài viết thành công", HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteArticle(@RequestParam int id) {
        articleRepository.deleteById(id);

        return new ResponseEntity<String>("Xóa bài viết thành công", HttpStatus.OK);
    }
}
