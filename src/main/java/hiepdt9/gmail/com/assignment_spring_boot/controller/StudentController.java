package hiepdt9.gmail.com.assignment_spring_boot.controller;

import hiepdt9.gmail.com.assignment_spring_boot.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/student")
public class StudentController {
    public ArrayList<Student> students = new ArrayList<Student>();

    @PostMapping("")
    public ResponseEntity<ArrayList<Student>> addNewStudent1(@RequestParam String name, @RequestParam int age) {
    	Student student = new Student(name, age);
        students.add(student);
        return new ResponseEntity<ArrayList<Student>>(students, HttpStatus.OK);
    }

    @PostMapping("/{name}/{age}")
    public ResponseEntity<ArrayList<Student>> addNewStudent2(@PathVariable String name, @PathVariable int age) {
        Student student = new Student(name, age);
        students.add(student);
        return new ResponseEntity<ArrayList<Student>>(students, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ArrayList<Student>> addNewStudent3(@RequestBody Student student) {
        students.add(student);
        return new ResponseEntity<ArrayList<Student>>(students, HttpStatus.OK);
    }
}
