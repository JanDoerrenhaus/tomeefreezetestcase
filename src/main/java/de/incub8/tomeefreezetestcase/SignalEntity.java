package de.incub8.tomeefreezetestcase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class SignalEntity
{
    @Id
    @GeneratedValue
    private Long id;

    private String data;
}
