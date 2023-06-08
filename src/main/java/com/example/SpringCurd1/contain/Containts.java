package com.example.SpringCurd1.contain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@ToString
@Builder
@Entity
@Table(name = "containts")
public class Containts {
    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(
            name = "UUDi",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    @Column
    @NonNull
    private String contact;
    @Column
    @NonNull
    private String name;
    @Column
    @NonNull
    private String profile;
    @Column
    @NonNull
    private String facebookurl;

}
