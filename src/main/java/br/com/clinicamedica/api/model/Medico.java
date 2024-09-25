package br.com.clinicamedica.api.model;

import br.com.clinicamedica.api.enums.EspecialidadeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "medico")
public class Medico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "crm", nullable = false, unique = true, length = 9)
    private String crm;

    @Column(name = "especialidade", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private EspecialidadeEnum especialidade;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "telefone", length = 11)
    private String telefone;

}
