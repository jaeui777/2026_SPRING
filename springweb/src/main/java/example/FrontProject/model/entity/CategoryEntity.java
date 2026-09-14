package example.FrontProject.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cno;

    @Column(nullable = false, length = 100)
    private String name;

    // 카테고리 하나에 여러 제품이 연결되는 1:N 관계 매핑
    @OneToMany(mappedBy = "categoryEntity", cascade = CascadeType.ALL)
    @ToString.Exclude
    @Builder.Default
    private List<CategoryEntity> categoryEntities = new ArrayList<>();
}