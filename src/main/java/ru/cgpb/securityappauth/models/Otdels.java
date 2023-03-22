package ru.cgpb.securityappauth.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.Serializable;


@AllArgsConstructor
@Getter
@Setter
public class Otdels implements Serializable {
    String V40V;
    String OTDEL;

}
