package com.louis.server.entity.oauth;

import com.louis.core.entity.AbstractAuditable;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(of = {"clientDetails", "value"}, callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "redirect_uri")
public class RedirectUriEntity extends AbstractAuditable<Long> {

    private static final long serialVersionUID = -4117894101852428855L;
    @NonNull
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "client_details_id", nullable = false)
    private ClientDetailsEntity clientDetails;

    @NonNull
    @NotNull
    @Column(name = "value", nullable = false)
    private String value;

}
