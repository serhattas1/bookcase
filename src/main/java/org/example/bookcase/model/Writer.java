package org.example.bookcase.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="writer")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Writer {
    @SequenceGenerator(name = "writer_id_seq", sequenceName = "writer_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "writer_id_seq")
    @Column(name = "ID")
    @jakarta.persistence.Id
    private long id;

    @Column(name = "WRITER_NAME")
    private String writer_name;

    @Column(name = "WRITER_SURNAME")
    private String writer_surname;
}
