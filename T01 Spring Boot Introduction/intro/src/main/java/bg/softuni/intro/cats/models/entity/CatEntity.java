package bg.softuni.intro.cats.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cats")
public class CatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long catId;

    @Column(nullable = false)
    private String catName;

    @ManyToOne
    private OwnerEntity owner;

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public OwnerEntity getOwner() {
        return owner;
    }

    public void setOwner(OwnerEntity owner) {
        this.owner = owner;
    }
}
