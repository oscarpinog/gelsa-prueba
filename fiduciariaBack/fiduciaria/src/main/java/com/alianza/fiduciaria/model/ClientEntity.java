package com.alianza.fiduciaria.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "clients")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String ID;
    private String sharedKey;
    private String businessId;
    private String email;
    private String phone;
    private LocalDate dataAdded;

   }
