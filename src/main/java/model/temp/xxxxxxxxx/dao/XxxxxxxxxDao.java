package model.temp.xxxxxxxxx.dao;

import model.temp.xxxxxxxxx.dto.XxxxxxxxxDto;
import model.temp.xxxxxxxxx.entity.Xxxxxxxxx;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface XxxxxxxxxDao {


    List<Xxxxxxxxx> searchXxxxxxxxxList(XxxxxxxxxDto dto);


}
