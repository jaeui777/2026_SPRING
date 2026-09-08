package example.day05.Practice3;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "test")
@AllArgsConstructor@NoArgsConstructor@Builder
@Getter@Setter@ToString
public class TestEntity extends BaseTime {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer no;
    @Column( name = "name" , nullable = false, length = 100 , unique = true)
    private String name;
   


    
} 
