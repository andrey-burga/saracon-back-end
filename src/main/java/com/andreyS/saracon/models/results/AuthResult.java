package com.andreyS.saracon.models.results;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResult {
    private boolean authenticated;
    private String userType;

}
