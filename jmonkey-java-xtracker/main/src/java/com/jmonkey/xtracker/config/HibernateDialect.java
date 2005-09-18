package com.jmonkey.xtracker.config;

import java.util.HashMap;
import java.util.Map;

public class HibernateDialect {
	private static Map<String, String>	dialectMap	= new HashMap<String, String>();
	static {
		dialectMap.put("DB2", "net.sf.hibernate.dialect.DB2Dialect");
		dialectMap.put("DB2", "AS/400 net.sf.hibernate.dialect.DB2400Dialect");
		dialectMap.put("DB2", "OS390 net.sf.hibernate.dialect.DB2390Dialect");
		dialectMap.put("PostgreSQL", "net.sf.hibernate.dialect.PostgreSQLDialect");
		dialectMap.put("MySQL", "net.sf.hibernate.dialect.MySQLDialect");
		dialectMap.put("Oracle (any version)", "net.sf.hibernate.dialect.OracleDialect");
		dialectMap.put("Oracle 9/10g", "net.sf.hibernate.dialect.Oracle9Dialect");
		dialectMap.put("Sybase", "net.sf.hibernate.dialect.SybaseDialect");
		dialectMap.put("Sybase Anywhere", "net.sf.hibernate.dialect.SybaseAnywhereDialect");
		dialectMap.put("Microsoft SQL Server", "net.sf.hibernate.dialect.SQLServerDialect");
		dialectMap.put("SAP DB", "net.sf.hibernate.dialect.SAPDBDialect");
		dialectMap.put("Informix", "net.sf.hibernate.dialect.InformixDialect");
		dialectMap.put("HypersonicSQL", "net.sf.hibernate.dialect.HSQLDialect");
		dialectMap.put("Ingres", "net.sf.hibernate.dialect.IngresDialect");
		dialectMap.put("Progress", "net.sf.hibernate.dialect.ProgressDialect");
		dialectMap.put("Mckoi SQL", "net.sf.hibernate.dialect.MckoiDialect");
		dialectMap.put("Interbase", "net.sf.hibernate.dialect.InterbaseDialect");
		dialectMap.put("Pointbase", "net.sf.hibernate.dialect.PointbaseDialect");
		dialectMap.put("FrontBase", "net.sf.hibernate.dialect.FrontbaseDialect");
		dialectMap.put("Firebird", "net.sf.hibernate.dialect.FirebirdDialect");
	}

	public HibernateDialect() {
		super();
	}

}
