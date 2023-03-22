package ru.cgpb.securityappauth.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Setter
@Getter
public class StatForms implements Serializable {
    String id;
    String name;


}
