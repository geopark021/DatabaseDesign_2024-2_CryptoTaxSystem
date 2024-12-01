package com.cryptotaxsystem.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "coin")
@Getter
@Setter
@NoArgsConstructor
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coin_id")
    private Integer id;

    @Column(name = "coin_symbol", nullable = false, unique = true, length = 50)
    private String coinSymbol;

    @Column(name = "coin_name", nullable = false, length = 50)
    private String coinName;

    @Column(name = "chain_name", length = 50)
    private String chainName;

    @Column(name = "coin_img", length = 255)
    private String coinImg;
}
