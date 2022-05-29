package App;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DateTime")
@ToString
public class Date {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	@Column
	private LocalDate datum;
	@NonNull
	@Column
	private LocalTime startTime;
	@NonNull
	@Column
	private LocalTime endTime;
	@NonNull
	@Column
	private Long workTime;
	@Column
	private Long restVacatenDays;
	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false )
	private Employee employee;

}
