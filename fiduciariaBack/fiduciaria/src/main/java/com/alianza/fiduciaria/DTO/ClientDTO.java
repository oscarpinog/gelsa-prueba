package com.alianza.fiduciaria.DTO;


import com.alianza.fiduciaria.enums.Disability;
import com.alianza.fiduciaria.enums.ResearchHotbed;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ClientDTO {
    private String ID;
    private String sharedKey;
    private String businessId;
    private String email;
    private String phone;
    private LocalDate dataAdded;
}
