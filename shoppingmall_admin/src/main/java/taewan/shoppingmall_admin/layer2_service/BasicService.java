package taewan.shoppingmall_admin.layer2_service;

import taewan.shoppingmall_admin.dto.AllInfoDto;

import java.util.List;

public interface BasicService {

    List<AllInfoDto> searchAll(String repositoryName);

}
