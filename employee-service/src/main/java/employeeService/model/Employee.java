package employeeService.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="employees")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="department")
	private String department;
	@Column(name="designation")
	private String designation;
	@Column(name="dob")
	private Date dob;
	@Column(name="age")
	private Integer age;
	@Column(name="doj")
	private Date doj;
	@Column(name="salary")
	private Double salary;
	@Column(name="mob_number",nullable=false)
	private String mobNumber;
	@Column(name="email_id")
	private String emailId;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="joincolumn")
	private Address address;
	
	
	
}
