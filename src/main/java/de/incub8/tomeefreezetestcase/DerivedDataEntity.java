package de.incub8.tomeefreezetestcase;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DerivedDataEntity
{
    private Long id;

    private String data;

    public DerivedDataEntity(SignalEntity signalEntity)
    {
        data = signalEntity.getData();
    }
}
