package sample.activity;

import java.util.ArrayList;
import java.util.List;
import com.poscoict.glueframework.biz.activity.GlueActivity;
import com.poscoict.glueframework.biz.control.GlueBizControlConstants;
import com.poscoict.glueframework.context.GlueContext;
import com.poscoict.glueframework.dao.jdbc.GlueGenericJdbcDao;
import com.poscoict.glueframework.dao.vo.GlueParameter;

public class GlueJdbcModify extends GlueActivity<GlueContext> {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String runActivity( GlueContext ctx ) {
		GlueGenericJdbcDao dao = (GlueGenericJdbcDao) this.getDao( "test-dao" );
		GlueParameter<List> param = new GlueParameter<List>();
		List paramList = new ArrayList();
		List<String> param1 = (List<String>) ctx.get( "param1" );
		List<String> param2 = (List<String>) ctx.get( "param2" );
		List<String> param3 = (List<String>) ctx.get( "param3" );
		paramList.add( param1.get( 0 ) );
		paramList.add( param2.get( 0 ) );
		paramList.add( param3.get( 0 ) );
		param.setParameter( paramList );
		int result = dao.update( "restful.emp.update", param );
		ctx.put( "update_cnt", result );
		return GlueBizControlConstants.SUCCESS;
		} 
}
