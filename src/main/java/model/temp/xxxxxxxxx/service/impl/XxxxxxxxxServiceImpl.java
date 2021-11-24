package model.temp.xxxxxxxxx.service.impl;

import com.xin.sparrow.common.dto.RestResult;
import model.temp.xxxxxxxxx.dao.XxxxxxxxxMapper;
import model.temp.xxxxxxxxx.dto.XxxxxxxxxDto;
import model.temp.xxxxxxxxx.entity.Xxxxxxxxx;
import model.temp.xxxxxxxxx.service.XxxxxxxxxService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@Transactional
public class XxxxxxxxxServiceImpl implements XxxxxxxxxService {

    @Autowired
    private XxxxxxxxxMapper xxxxxxxxxMapper;

    @Override
    public RestResult searchXxxxxxxxxList(HttpServletRequest request) throws Exception {
        RestResult result = new RestResult();
        XxxxxxxxxDto dto = new XxxxxxxxxDto();
        List<Xxxxxxxxx> list = xxxxxxxxxMapper.searchXxxxxxxxxList(dto);
        result.setObject(list);
        return result;
    }

    @Override
    public void forwordXxxxxxxxxSave(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        Xxxxxxxxx entity = xxxxxxxxxMapper.selectById(id);
        request.setAttribute("xxxxxxxxx",entity);
    }

    @Override
    public RestResult xxxxxxxxxSave(XxxxxxxxxDto dto) throws Exception{
        RestResult result = new RestResult();
        String id = "";//dto.getId();
        Xxxxxxxxx entity = new Xxxxxxxxx();
        if(!StringUtils.isEmpty(id)){
            entity  = xxxxxxxxxMapper.selectById(id);
        }
        BeanUtils.copyProperties(dto,entity);
        xxxxxxxxxMapper.insert(entity);
        //dto.setId(entity.getId());
        result.setObject(dto);
        return result;
    }

    @Override
    public void xxxxxxxxxDelete(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(id)){
            throw new Exception("删除Xxxxxxxxx_ZH失败，主键为空");
        }
        xxxxxxxxxMapper.deleteById(id);
    }






}
