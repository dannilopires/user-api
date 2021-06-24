package one.digitalinnovation.UserAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.UserAPI.enums.PhoneyType;

import javax.persistence.*;

@Data //Adiciona getters e setters
@Builder //Padrão de projeto e construção de objetos
@AllArgsConstructor  //Adiciona construtores
@NoArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhoneyType type;

    @Column(nullable = false)
    private String number;
}
