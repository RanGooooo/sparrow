package com.xin.view;


import com.xin.common.model.enums.SysViewEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sysForwardController")
public class SysForwardController {


    /**
     * @Author:  zhaohongyu
     * @CreateDate:  2021-11-16 15:53
     */
    @RequestMapping(value="/{systemcode}")
    public String fundNetWorthReport(@PathVariable("systemcode")String systemcode) {
        SysViewEnum viewEnum = SysViewEnum.getEnumBySystemcode(systemcode);
        return viewEnum.systempath;
    }

}
