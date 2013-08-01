package de.incub8.tomeefreezetestcase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class DerivedDataEntity
{
    @Id
    @GeneratedValue
    private Long id;

    private String data;

    public DerivedDataEntity(SignalEntity signalEntity)
    {
        data = signalEntity.getData();
    }
}
