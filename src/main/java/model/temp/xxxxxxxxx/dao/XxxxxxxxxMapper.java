package model.temp.xxxxxxxxx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import model.temp.xxxxxxxxx.dto.XxxxxxxxxDto;
import model.temp.xxxxxxxxx.entity.Xxxxxxxxx;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface XxxxxxxxxMapper extends BaseMapper<Xxxxxxxxx>{


    List<Xxxxxxxxx> searchXxxxxxxxxList(XxxxxxxxxDto dto);


}
