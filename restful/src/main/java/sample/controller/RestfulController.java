package sample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.poscoict.glueframework.biz.control.GlueBizControlConstants;
import com.poscoict.glueframework.biz.control.GlueBizController;
import com.poscoict.glueframework.biz.control.GlueBizProvider;
import com.poscoict.glueframework.context.GlueDefaultContext;
import com.poscoict.glueframework.util.log.GlueLog;
import com.poscoict.glueframework.util.log.GlueLogFactory;
import com.poscoict.glueframework.web.control.GlueWebConstants;

/**
 * RESTful방식의 웹서비스를 제공하는 Controller URI 패턴으로는 아래 두가지 방식이 제공된다. 1)
 * /glue/{serviceName} : URI의 serviceName과 Service명이 일치하는 Glue Servic가 실행 된다. 2)
 * /glue/{serviceName}/data/{gluedata} : URI의 serviceName과 Service명이 일치하는 Glue
 * Servic가 실행되며 URI의 gluedata값은 "gluedata"를 Key로 GlueContext에 저장된다.
 * GET,POST,PUT,DELETE 방식이 지원되며 어떤 방식의 요청이었는지는 "action"을 Key로 GlueContext에 소문자로
 * 저장된다. 해당 요청이 Key로도 등록되므로 Default Router로 분기도 가능하다. ajax방식이나 RestTemplate을
 * 사용하여 서비스를 호출 할 수있으며 JSON 형식의 데이터가 Return된다.
 */
@Controller
public class RestfulController {
	/** logger */
	protected GlueLog logger = GlueLogFactory.getLogger(getClass());

	/**
	 * @param serviceName
	 * @return
	 */
	@RequestMapping(value = "/glue/{serviceName}", method = RequestMethod.GET)
	public ModelAndView doGlueServiceGet(@PathVariable String serviceName) {
		ModelAndView mav = new ModelAndView(GlueWebConstants.JSON_VIEW);
		Map<String, Object> glueResult = doGlueService(serviceName, GlueWebConstants.GET, null, null);
		mav.addAllObjects(glueResult);
		return mav;
	}

	/**
	 * @param serviceName
	 * @param gluedata
	 * @return
	 */
	@RequestMapping(value = "/glue/{serviceName}/data/{gluedata}", method = RequestMethod.GET)
	public ModelAndView doGlueServiceGetByData(@PathVariable String serviceName, @PathVariable String gluedata) {
		ModelAndView mav = new ModelAndView(GlueWebConstants.JSON_VIEW);
		Map<String, Object> glueResult = doGlueService(serviceName, GlueWebConstants.GET, gluedata, null);
		mav.addAllObjects(glueResult);
		return mav;
	}

	/**
	 * @param serviceName
	 * @return
	 */
	@RequestMapping(value = "/glue/{serviceName}", method = RequestMethod.DELETE)
	public ModelAndView doGlueServiceDelete(@PathVariable String serviceName) {
		ModelAndView mav = new ModelAndView(GlueWebConstants.JSON_VIEW);
		Map<String, Object> glueResult = doGlueService(serviceName, GlueWebConstants.DELETE, null, null);
		mav.addAllObjects(glueResult);
		return mav;
	}

	/**
	 * @param serviceName
	 * @param gluedata
	 * @return
	 */
	@RequestMapping(value = "/glue/{serviceName}/data/{gluedata}", method = RequestMethod.DELETE)
	public ModelAndView doGlueServiceDeletetByData(@PathVariable String serviceName, @PathVariable String gluedata) {
		ModelAndView mav = new ModelAndView(GlueWebConstants.JSON_VIEW);
		Map<String, Object> glueResult = doGlueService(serviceName, GlueWebConstants.DELETE, gluedata, null);
		mav.addAllObjects(glueResult);
		return mav;
	}

	/**
	 * @param serviceName
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/glue/{serviceName}", method = RequestMethod.POST)
	public ModelAndView doGlueServicePost(@PathVariable String serviceName, @RequestParam Map<String, Object> params) {
		ModelAndView mav = new ModelAndView(GlueWebConstants.JSON_VIEW);
		Map<String, Object> glueResult = doGlueService(serviceName, GlueWebConstants.POST, null, params);
		mav.addAllObjects(glueResult);
		return mav;
	}

	/**
	 * @param serviceName
	 * @param gluedata
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/glue/{serviceName}/data/{gluedata}", method = RequestMethod.POST)
	public ModelAndView doGlueServicePostByData(@PathVariable String serviceName, @PathVariable String gluedata,
			@RequestParam Map<String, Object> params) {
		ModelAndView mav = new ModelAndView(GlueWebConstants.JSON_VIEW);
		Map<String, Object> glueResult = doGlueService(serviceName, GlueWebConstants.POST, gluedata, params);
		mav.addAllObjects(glueResult);
		return mav;
	}

	/**
	 * @param serviceName
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/glue/{serviceName}", method = RequestMethod.PUT)
	public ModelAndView doGlueServicePut(@PathVariable String serviceName,
			@RequestBody MultiValueMap<String, String> params) {
		ModelAndView mav = new ModelAndView(GlueWebConstants.JSON_VIEW);
		Map<String, Object> glueResult = doGlueService(serviceName, GlueWebConstants.PUT, null, params);
		mav.addAllObjects(glueResult);
		return mav;
	}

	/**
	 * @param serviceName
	 * @param gluedata
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/glue/{serviceName}/data/{gluedata}", method = RequestMethod.PUT)
	public ModelAndView doGlueServicePutByData(@PathVariable String serviceName, @PathVariable String gluedata,
			@RequestBody MultiValueMap<String, String> params) {
		ModelAndView mav = new ModelAndView(GlueWebConstants.JSON_VIEW);
		Map<String, Object> glueResult = doGlueService(serviceName, GlueWebConstants.PUT, gluedata, params);
		mav.addAllObjects(glueResult);
		return mav;
	}

	/**
	 * @param serviceName
	 * @param action
	 * @param data
	 * @param params
	 * @return
	 */
	private Map<String, Object> doGlueService(String serviceName, String action, String data, Map<String, ?> params) {
		logger.debug("Glue ServiceName : {}", serviceName);
		logger.debug("RESTful Action : {}", action);
		logger.debug("RESTful Data : {}", data);
		logger.debug("RequestBody : {}", params);
		GlueDefaultContext ctx = new GlueDefaultContext();
		Map<String, Object> result = new HashMap<String, Object>();
		List<?> result_key_list = null;
		if (params != null) {
			ctx.putAll(params);
		}
		ctx.put(GlueBizControlConstants.SERVICE_NAME, serviceName);
		ctx.put(GlueWebConstants.RESTFUL_ACTION, action);
		ctx.put(action, action);
		ctx.put(GlueWebConstants.RESTFUL_DATA, data);
		try {
			MDC.put(GlueBizControlConstants.SERVICE_NAME, serviceName);
			GlueBizController bizIF = GlueBizProvider.getController();
			bizIF.doAction(ctx);
			MDC.remove(GlueBizControlConstants.SERVICE_NAME);
			result_key_list = (List<?>) ctx.get(GlueBizControlConstants.RESULT_KEY_LIST);
		} catch (Exception e) {
			result.put(GlueWebConstants.RESTFUL_ERROR, e);
			logger.error(e.getMessage(), e);
		}
		if ((result_key_list != null) && (result_key_list.size() > 0)) {
			for (int i = 0; i < result_key_list.size(); i++) {
				result.put((String) result_key_list.get(i), ctx.get(result_key_list.get(i)));
			}
		}
		return result;
	}
}
