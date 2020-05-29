package com.lpp.edas;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@NacosPropertySource(dataId = "pp", autoRefreshed = true,groupId ="demo")
public class EchoController {

//  @NacosValue(value = "${name}", autoRefreshed = true)
//	private String userName;

  @NacosValue(value = "${ip}", autoRefreshed = true)
  private String ip;

  @RequestMapping(value = "/")
	public String echo() {
		return "-----"+ip;
	}
}
