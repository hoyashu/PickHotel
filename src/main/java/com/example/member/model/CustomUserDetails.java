package com.example.member.model;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class CustomUserDetails {
    @NonNull
    private String username;
    @NonNull
    private String name;
    @NonNull
    private int grade;
    private String role;
}
