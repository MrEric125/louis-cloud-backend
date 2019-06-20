package com.louis.server.entity.oauth;

import com.louis.core.entity.AbstractAuditable;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(of = {"clientDetails", "resourceId"}, callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "client_details_resource_xref")
public class ClientDetailsToResourceIdXrefEntity extends AbstractAuditable<Long> {

    private static final long serialVersionUID = -297545640480707057L;
    @NonNull
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "client_details_id")
    private ClientDetailsEntity clientDetails;

    @NonNull
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "resource_id")
    private ResourceIdEntity resourceId;

}
