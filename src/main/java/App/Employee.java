package App;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name ="Employees")

public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NonNull
	@Column(name ="Firstname", nullable = false)
	private String firstName;
	@NonNull
	@Column(name ="Lastname", nullable = false)
	private String lastName;
	
	@Column
	private String email;
	@Column
	private String telefonNumer;
	@Column
	private String adresse;
	@Column	
	private Integer vacatenDays;
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Date> date;
}
