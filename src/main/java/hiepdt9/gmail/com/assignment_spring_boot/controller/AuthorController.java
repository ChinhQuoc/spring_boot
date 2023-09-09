package hiepdt9.gmail.com.assignment_spring_boot.controller;

import hiepdt9.gmail.com.assignment_spring_boot.entity.AuthorEntity;
import hiepdt9.gmail.com.assignment_spring_boot.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tacgia")
public class AuthorController {
    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("")
    public ResponseEntity<List<AuthorEntity>> getAuthors() {
        List<AuthorEntity> authors = authorRepository.findAll();

        return new ResponseEntity<List<AuthorEntity>>(authors, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> saveAuthors(@RequestParam String authorName, @RequestParam String fullName, @RequestParam int gender) {
        AuthorEntity author = new AuthorEntity();
        author.setAuthorName(authorName);
        author.setFullName(fullName);
        author.setGender(gender);

        authorRepository.save(author);

        return new ResponseEntity<>("Tạo tác giả thành công", HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<?> updateAuthors(@RequestParam int id, @RequestParam String authorName, @RequestParam String fullName, @RequestParam int gender) {
        AuthorEntity author = new AuthorEntity();
        author.setId(id);
        author.setAuthorName(authorName);
        author.setFullName(fullName);
        author.setGender(gender);

        authorRepository.save(author);

        return new ResponseEntity<>("Cập nhật tác giả thành công", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAuthors(@RequestParam int id) {
        AuthorEntity author = new AuthorEntity();
        author.setId(id);

        authorRepository.save(author);

        return new ResponseEntity<>("Xóa tác giả thành công", HttpStatus.OK);
    }
}
