package com.louis.server.entity.oauth;

import com.louis.core.entity.AbstractAuditable;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@EqualsAndHashCode(of = "value", callSuper = false)
@ToString(of = "value", callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "resource")
public class ResourceIdEntity extends AbstractAuditable<Long> {

    private static final long serialVersionUID = 1085025991798998273L;
    @NonNull
    @NotNull
    @Column(name = "value", nullable = false)
    private String value;

    @Singular
    @OneToMany(mappedBy = "resourceId", fetch = FetchType.LAZY)
    private Set<ClientDetailsToResourceId> clientDetailsToResourceIdXrefs;
}
