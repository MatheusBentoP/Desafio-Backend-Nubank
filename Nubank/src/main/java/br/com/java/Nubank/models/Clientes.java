package br.com.java.Nubank.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "DB_Clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;



    @OneToMany(mappedBy = "clientes",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    public List<Contatos> contatos  = new ArrayList<>();




}
