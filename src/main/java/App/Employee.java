package App;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	@Column(name ="Firstname")
	private String firstName;
	@NonNull
	@Column(name ="Lastname")
	private String lastName;
	
	@Column
	private String email;
	@Column
	private String telefonNumer;
	@Column
	private String adresse;
	@Column	
	private Integer vacatenDays;
	@JsonManagedReference
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Date> date;
}
