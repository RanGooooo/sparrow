package model.temp.xxxxxxxxx.controller;


import com.rain.sparrow.common.dto.RestResult;
import model.temp.xxxxxxxxx.dto.XxxxxxxxxDto;
import model.temp.xxxxxxxxx.service.XxxxxxxxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("XxxxxxxxxController")
public class XxxxxxxxxController {

    private static final String xxxxxxxxxPath = "system/xxxxxxxxx/";

    @Autowired
    private XxxxxxxxxService xxxxxxxxxService;

    @RequestMapping("forwordXxxxxxxxxList")
    public String forwordXxxxxxxxxList(){
        return xxxxxxxxxPath + "xxxxxxxxx-list";
    }

    @RequestMapping("searchXxxxxxxxxList")
    @ResponseBody
    public RestResult searchXxxxxxxxxList(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            result = xxxxxxxxxService.searchXxxxxxxxxList(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("forwordXxxxxxxxxSave")
    public String forwordXxxxxxxxxSave(HttpServletRequest request){
        try {
            xxxxxxxxxService.forwordXxxxxxxxxSave(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xxxxxxxxxPath + "xxxxxxxxx-save";
    }

    @RequestMapping("xxxxxxxxxSave")
    @ResponseBody
    public RestResult xxxxxxxxxSave(XxxxxxxxxDto dto) {
        RestResult result = new RestResult();
        try {
            xxxxxxxxxService.xxxxxxxxxSave(dto);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("xxxxxxxxxDelete")
    @ResponseBody
    public RestResult xxxxxxxxxDelete(HttpServletRequest request) {
        RestResult result = new RestResult();
        try {
            xxxxxxxxxService.xxxxxxxxxDelete(request);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }
        return result;
    }

}
