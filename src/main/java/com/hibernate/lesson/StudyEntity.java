package com.hibernate.lesson;

import javax.persistence.*;

@Entity
@Table(name = "study", schema = "text", catalog = "")
public class StudyEntity {
    private int id;
    private String lesson;
    private String name;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "lesson", nullable = true, length = 10)
    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 10)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudyEntity that = (StudyEntity) o;

        if (id != that.id) return false;
        if (lesson != null ? !lesson.equals(that.lesson) : that.lesson != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (lesson != null ? lesson.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
