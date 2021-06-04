package com.id.entities;

import com.id.dto.IdInfoDTO;
import com.id.models.IdInfoModel;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Table(name = "id_information")
@Entity(name = "IdInformation")
@Getter
@Setter
public class IdInformation extends AbstractBaseEntity{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="branch")
    private String branch;

    @Column(name="image")
    private String image;

    @Column(name="qr_code")
    private String qrCode;

    public static IdInformation from(final IdInfoModel idInfoModel){
        IdInformation idInformation=new IdInformation();
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.map(idInfoModel,idInformation);
        return  idInformation;
    }

    public IdInfoDTO to(){
IdInfoDTO idInfoDTO=new IdInfoDTO();
ModelMapper modelMapper=new ModelMapper();
modelMapper.map(this,idInfoDTO);
return idInfoDTO;
    }

}
