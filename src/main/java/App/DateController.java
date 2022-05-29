package App;

import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/date")
@Controller
public class DateController {
	@Autowired
	private DateRepo repo;

	@GetMapping("/alldate")
	public List<Date> showAll() {
		return repo.findAll();
	}
	//OUTPUT-DATA
//	@Value("${spring.application.name}")
//	String appName ;

	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("Name", "MyApp");
		return "index";
	}

	@GetMapping("/date/{date}")
	public ResponseEntity<?> findByDate(@PathVariable LocalDate date) {
		var findDate = repo.findByDatum(date);
		return ResponseEntity.ok(findDate);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Date insterDatum(@RequestBody Date date) {
		date.setId(null);
		return repo.save(date);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editTheDate(@RequestBody Date date, @RequestParam Long id) {
		if (!repo.existsById(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		repo.save(date);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleDatum(@PathVariable Long id) {
		if (!repo.existsById(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		repo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@DeleteMapping("/deleteAll")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletAll() {
		
		 repo.deleteAll();
	}

//
//    @GetMapping("/title/{bookTitle}")
//    public List findByTitle(@PathVariable String bookTitle) {
//        return bookRepository.findByTitle(bookTitle);
//    }
//
//	@GetMapping("/{id}")
//	public Date findOne(@PathVariable Long id) throws AttributeNotFoundException {
//		return repo.findById(id).orElseThrow(AttributeNotFoundException::new);
//	}
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Book create(@RequestBody Book book) {
//        return bookRepository.save(book);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//        bookRepository.findById(id)
//          .orElseThrow(BookNotFoundException::new);
//        bookRepository.deleteById(id);
//    }
//
//    @PutMapping("/{id}")
//    public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
//        if (book.getId() != id) {
//          throw new BookIdMismatchException();
//        }
//        bookRepository.findById(id)
//          .orElseThrow(BookNotFoundException::new);
//        return bookRepository.save(book);
//    }
}
