package org.acme.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class UserDetailedDto {

    public Integer id;

    public String name;

    public String registration;

    public String password;

    public String profile_type;

    public List<SolicitationDto> solicitations;

    public List<ContributionDto> contributions;

}
