package com.exampleJMS;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Email {

    private String to;
    private String body;

}