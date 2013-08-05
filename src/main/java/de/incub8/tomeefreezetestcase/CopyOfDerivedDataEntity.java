package de.incub8.tomeefreezetestcase;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CopyOfDerivedDataEntity
{
    private Long id;

    private String data;

    public CopyOfDerivedDataEntity(DerivedDataEntity derivedDataEntity)
    {
        data = derivedDataEntity.getData();
    }
}
