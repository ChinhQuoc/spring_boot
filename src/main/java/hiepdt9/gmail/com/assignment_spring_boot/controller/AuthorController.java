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
    public ResponseEntity<String> saveAuthors(@RequestBody AuthorEntity newAuthor) {
        AuthorEntity author = new AuthorEntity();
        author.setAuthorName(newAuthor.getAuthorName());
        author.setFullName(newAuthor.getFullName());
        author.setGender(newAuthor.getGender());

        authorRepository.save(author);

        return new ResponseEntity<String>("Tạo tác giả thành công", HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<String> updateAuthors(@RequestBody AuthorEntity oldAuthor) {
        AuthorEntity author = new AuthorEntity();
        author.setId(oldAuthor.getId());
        author.setAuthorName(oldAuthor.getAuthorName());
        author.setFullName(oldAuthor.getFullName());
        author.setGender(oldAuthor.getGender());

        authorRepository.save(author);

        return new ResponseEntity<String>("Cập nhật tác giả thành công", HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteAuthors(@RequestParam int id) {
        authorRepository.deleteById(id);

        return new ResponseEntity<String>("Xóa tác giả thành công", HttpStatus.OK);
    }
}
