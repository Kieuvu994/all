package sample.activity;

import java.util.ArrayList;
import java.util.List;
import com.poscoict.glueframework.biz.activity.GlueActivity;
import com.poscoict.glueframework.biz.control.GlueBizControlConstants;
import com.poscoict.glueframework.context.GlueContext;
import com.poscoict.glueframework.dao.jdbc.GlueGenericJdbcDao;
import com.poscoict.glueframework.dao.vo.GlueParameter;

public class GlueJdbcSearch extends GlueActivity<GlueContext> {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String runActivity( GlueContext ctx ) {
		GlueGenericJdbcDao dao = (GlueGenericJdbcDao) this.getDao( "test-dao" );
		GlueParameter<List> param = new GlueParameter<List>();
		List paramList = new ArrayList();
		paramList.add( ctx.get( "restfulData" ) );
		param.setParameter( paramList );
		List<?> result = dao.find( "restful.emp.select", param );
		ctx.put( "search_result", result );
		return GlueBizControlConstants.SUCCESS;
		}

}
