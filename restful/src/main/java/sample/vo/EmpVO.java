package sample.vo;

import java.util.Date;

/**
 * <pre>
 * EMP Table Column Definition
 * - EMPNO   Long(4)
 * - ENAME   VARCHAR2(10)
 * - JOB VARCHAR2(9)
 * - MGR Long(4)
 * - HIREDATE    DATE
 * - SAL Long(7,2)
 * - COMM    Long(7,2)
 * - DEPTNO  Long(2)
 * 
 * Caution for using BeanPropertyRowMapper
 * 1. Create with the class specified in the resultType of QueryEditor
 * 2. When generating a getter, setter variable, be aware of the following
 *   - Only the first letter of the DB columnID will be uppercase and the rest will be generated in lowercase
 *     ex) getEmpno(), setEmpno
 *   - Maintain UnderBar(_) in the DB columnID. 
 *     ex) getPhone_Long(), setPhone_Long()
 * </pre>
 */
public class EmpVO
{
    private Long empno;
    private String ename;
    private String job;
    private Long mgr;
    private Date hiredate;
    private Long sal;
    private Long comm;
    private Long deptno;

    public Long getEmpno()
    {
        return empno;
    }

    public void setEmpno( Long empno )
    {
        this.empno = empno;
    }

    public String getEname()
    {
        return ename;
    }

    public void setEname( String ename )
    {
        this.ename = ename;
    }

    public String getJob()
    {
        return job;
    }

    public void setJob( String job )
    {
        this.job = job;
    }

    public Long getMgr()
    {
        return mgr;
    }

    public void setMgr( Long mgr )
    {
        this.mgr = mgr;
    }

    public Date getHiredate()
    {
        return hiredate;
    }

    public void setHiredate( Date hiredate )
    {
        this.hiredate = hiredate;
    }

    public Long getSal()
    {
        return sal;
    }

    public void setSal( Long sal )
    {
        this.sal = sal;
    }

    public Long getComm()
    {
        return comm;
    }

    public void setComm( Long comm )
    {
        this.comm = comm;
    }

    public Long getDeptno()
    {
        return deptno;
    }

    public void setDeptno( Long deptno )
    {
        this.deptno = deptno;
    }
}
