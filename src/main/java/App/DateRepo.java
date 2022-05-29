package App;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DateRepo extends JpaRepository<Date, Long> {
	

	List<Date> findByDatum(LocalDate date);

}
