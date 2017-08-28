package io.khasang.teamnote.entity;

import javax.persistence.*;
import java.util.Arrays;

/**
 * @author gothmog on 28.08.2017.
 */
@Entity
@Table(name = "items")
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "items_id")
    private Long id;

    @Column(name="name", length=100, nullable=false)
    private String name;

    @Column(name="description", length=255)
    private String description;

    @Column(name="type", length=100, nullable=false)
    private String type;

    @Lob @Basic(fetch = FetchType.LAZY)
    @Column(name="content", nullable=false)
    private byte[] content;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    public Items() {
    }

    public Items(String name, byte[] content) {
        this.name = name;
        this.content = content;
    }

    public Items(String name, String type, byte[] content) {
        this.name = name;
        this.type = type;
        this.content = content;
    }

    public Items(String name, String description, String type, byte[] content) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.content = content;
    }

    public Items(String name, String description, String type, byte[] content, User user) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.content = content;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Items))
            return false;
        Items other = (Items) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", content=" + Arrays.toString(content) +
                ", user=" + user +
                '}';
    }
}
