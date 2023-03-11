package org.example.bookcase.model;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import lombok.*;

@Entity
@Table(name="book")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @SequenceGenerator(name = "book_id_seq", sequenceName = "book_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "book_id_seq")
    @Column(name = "ID")
    @jakarta.persistence.Id
    private long id;

    @Column(name = "BOOK_NAME")
    private String book_name;

    @Column(name = "BOOK_YEAR")
    private Integer book_year;

    @Column(name="IS_ACTIVE")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name="WRITER_ID")
    private Writer writer;
}
