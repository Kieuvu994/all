package sample.activity;

import java.util.ArrayList;
import java.util.List;
import com.poscoict.glueframework.biz.activity.GlueActivity;
import com.poscoict.glueframework.biz.control.GlueBizControlConstants;
import com.poscoict.glueframework.context.GlueContext;
import com.poscoict.glueframework.dao.jdbc.GlueGenericJdbcDao;
import com.poscoict.glueframework.dao.vo.GlueParameter;

public class GlueJdbcInsert extends GlueActivity<GlueContext> {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String runActivity( GlueContext ctx ) {
		GlueGenericJdbcDao dao = (GlueGenericJdbcDao) this.getDao( "test-dao" );
		GlueParameter<List> param = new GlueParameter<List>();
		List paramList = new ArrayList();
		paramList.add( ctx.get( "param1" ) );
		paramList.add( ctx.get( "param2" ) );
		paramList.add( ctx.get( "param3" ) );
		paramList.add( ctx.get( "param4" ) );
		param.setParameter( paramList );
		int result = dao.insert( "restful.emp.insert", param );
		ctx.put( "insert_cnt", result );
		return GlueBizControlConstants.SUCCESS;
		}
}
