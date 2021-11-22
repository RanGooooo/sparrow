package model.temp.xxxxxxxxx.service;

import com.xin.sparrow.common.dto.RestResult;
import model.temp.xxxxxxxxx.dto.XxxxxxxxxDto;

import javax.servlet.http.HttpServletRequest;

public interface XxxxxxxxxService {

    RestResult searchXxxxxxxxxList(HttpServletRequest request) throws Exception;

    void forwordXxxxxxxxxSave(HttpServletRequest request) throws Exception;

    RestResult xxxxxxxxxSave(XxxxxxxxxDto dto) throws Exception;

    void xxxxxxxxxDelete(HttpServletRequest request) throws Exception;

}
