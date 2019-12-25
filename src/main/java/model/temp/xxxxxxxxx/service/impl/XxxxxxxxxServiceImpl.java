package model.temp.xxxxxxxxx.service.impl;

import com.rain.sparrow.common.dto.RestResult;
import model.temp.xxxxxxxxx.dao.XxxxxxxxxDao;
import model.temp.xxxxxxxxx.dao.XxxxxxxxxRepository;
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
    private XxxxxxxxxDao xxxxxxxxxDao;

    @Autowired
    private XxxxxxxxxRepository xxxxxxxxxRepository;

    @Override
    public RestResult searchXxxxxxxxxList(HttpServletRequest request) throws Exception {
        RestResult result = new RestResult();
        XxxxxxxxxDto dto = new XxxxxxxxxDto();
        List<Xxxxxxxxx> list = xxxxxxxxxDao.searchXxxxxxxxxList(dto);
        result.setObject(list);
        return result;
    }

    @Override
    public void forwordXxxxxxxxxSave(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        Xxxxxxxxx entity = xxxxxxxxxRepository.findXxxxxxxxxById(id);
        request.setAttribute("xxxxxxxxx",entity);
    }

    @Override
    public void xxxxxxxxxSave(XxxxxxxxxDto dto) throws Exception{
        //TODO 判空代码 稍后添加
        String id = dto.getId();
        Xxxxxxxxx entity = new Xxxxxxxxx();
        if(!StringUtils.isEmpty(id)){
            entity  = xxxxxxxxxRepository.findXxxxxxxxxById(id);
        }
        BeanUtils.copyProperties(dto,entity);
        xxxxxxxxxRepository.save(entity);
    }

    @Override
    public void xxxxxxxxxDelete(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(id)){
            throw new Exception("删除Xxxxxxxxx_ZH失败，主键为空");
        }
        xxxxxxxxxRepository.deleteById(id);
    }






}
