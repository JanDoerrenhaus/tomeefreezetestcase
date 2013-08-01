package de.incub8.tomeefreezetestcase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class CopyOfDerivedDataEntity
{
    @Id
    @GeneratedValue
    private Long id;

    private String data;

    public CopyOfDerivedDataEntity(DerivedDataEntity derivedDataEntity)
    {
        data = derivedDataEntity.getData();
    }
}
