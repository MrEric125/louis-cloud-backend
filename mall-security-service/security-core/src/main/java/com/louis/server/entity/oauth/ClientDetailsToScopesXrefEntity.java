package com.louis.server.entity.oauth;

import com.louis.core.entity.AbstractAuditable;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(of = {"clientDetails", "scope"}, callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "client_details_scope_xref")
public class ClientDetailsToScopesXrefEntity extends AbstractAuditable<Long> {

    private static final long serialVersionUID = -2622127467030114011L;
    @NonNull
    @NotNull
    @Column(name = "auto_approve", nullable = false)
    private Boolean autoApprove;

    @NonNull
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "client_details_id")
    private ClientDetailsEntity clientDetails;

    @NonNull
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "scope_id")
    private ScopeEntity scope;

}
